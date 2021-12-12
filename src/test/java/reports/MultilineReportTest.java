package reports;

import dao.LineDao;
import dao.LineDaoImpl;
import dao.LineQueryDao;
import dao.LineQueryDaoImpl;
import dto.field.validation.AllFieldsMandatoryVisitorImpl;
import exception.LineException;
import org.junit.Assert;
import org.junit.Test;
import reports.query.QueryAverageBuildDurationForEachGeoZone;
import reports.query.QueryCountForUniqueCustomerIdPerContractId;
import reports.query.QueryCountUniqueCustomerIdPerGeozone;
import reports.query.QueryUniqueCustomersPerGeozone;

import java.util.ArrayList;
import java.util.logging.Logger;

public class MultilineReportTest {

    public static final Logger LOGGER =
            Logger.getLogger(MultilineReportTest.class.getClass().getName());

    public static final String LINE_SEPARATORS = "\\r?\\n";


    @Test
    public void multilineReportGenerationTest() throws LineException {
        Report report = new MultilineReport(new ArrayList<>());

        StringBuilder lineValidStringBuilder =
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

        LineDao dao = new LineDaoImpl(new ArrayList<>(), new AllFieldsMandatoryVisitorImpl());
        dao.addLine(lineValidStringBuilder.toString());

        LineQueryDao queryDao = new LineQueryDaoImpl(dao.getLines());

        report.addReportQuery(new QueryCountForUniqueCustomerIdPerContractId(queryDao));
        report.addReportQuery(new QueryCountUniqueCustomerIdPerGeozone(queryDao));
        report.addReportQuery(new QueryAverageBuildDurationForEachGeoZone(queryDao));
        report.addReportQuery(new QueryUniqueCustomersPerGeozone(queryDao));

        String multilineReport = report.generateReport();
        LOGGER.info(multilineReport);
        String[] lines = multilineReport.split(LINE_SEPARATORS);
        Assert.assertEquals(4, lines.length);
    }
}
