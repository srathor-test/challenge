package app;

import dao.LineDao;
import dao.LineDaoImpl;
import dao.LineQueryDao;
import dao.LineQueryDaoImpl;
import dto.field.validation.AllFieldsMandatoryVisitorImpl;
import exception.LineException;
import reports.MultilineReport;
import reports.Report;
import reports.query.QueryAverageBuildDurationForEachGeoZone;
import reports.query.QueryCountForUniqueCustomerIdPerContractId;
import reports.query.QueryCountUniqueCustomerIdPerGeozone;
import reports.query.QueryUniqueCustomersPerGeozone;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Solution {
    public static final Logger LOGGER =
            Logger.getLogger(Solution.class.getClass().getName());

    private Report report;
    private LineDao dao;
    private LineQueryDao queryDao;

    public Solution(Report report, LineDao dao) {
        this.report = report;
        this.dao = dao;
    }

    public static void main(String[] args) throws LineException {

        StringBuilder inputStringBuilder =
                new StringBuilder()
                        .append("1,2,eu_west,RedTeam,ProjectApple,30s")
                        .append(System.lineSeparator())
                        .append("1,2,us_west,BlueTeam,ProjectBanana,20s")
                        .append(System.lineSeparator())
                        .append("2,2,eu_west,YellowTeam3,ProjectCarrot,10s")
                        .append(System.lineSeparator())
                        .append("2,2,eu_west,YellowTeam3,ProjectCarrot,10s")
                        .append(System.lineSeparator())
                        .append("3,2,eu_west,YellowTeam3,ProjectEgg,20s");

        Solution solution =
                new Solution(new MultilineReport(new ArrayList<>())
                        , new LineDaoImpl(new ArrayList<>(), new AllFieldsMandatoryVisitorImpl()));
        String reportString = solution.processInput(inputStringBuilder.toString());
        LOGGER.info(reportString);
    }

    public String processInput(String input) throws LineException {
        dao.addLine(input);
        queryDao = new LineQueryDaoImpl(dao.getLines());

        report.addReportQuery(new QueryCountForUniqueCustomerIdPerContractId(queryDao));
        report.addReportQuery(new QueryCountUniqueCustomerIdPerGeozone(queryDao));
        report.addReportQuery(new QueryAverageBuildDurationForEachGeoZone(queryDao));
        report.addReportQuery(new QueryUniqueCustomersPerGeozone(queryDao));

        return report.generateReport();
    }
}
