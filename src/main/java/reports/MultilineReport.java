package reports;

import reports.query.ReportQuery;

import java.util.List;

public class MultilineReport implements Report {
    private List<ReportQuery> reportQueries;

    public MultilineReport(List<ReportQuery> reportQueries) {
        this.reportQueries = reportQueries;
    }

    @Override
    public void addReportQuery(ReportQuery reportQuery) {
        reportQueries.add(reportQuery);
    }

    @Override
    public String generateReport() {
        StringBuilder result = new StringBuilder();
        Boolean firstElement = true;
        for(ReportQuery reportQuery: reportQueries) {
            if(firstElement) {
                result.append(reportQuery.summary());
                firstElement = false;
            } else {
                result.append(System.lineSeparator());
                result.append(reportQuery.summary());
            }
        }
        return result.toString();
    }
}
