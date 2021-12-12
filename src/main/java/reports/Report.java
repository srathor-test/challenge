package reports;

import reports.query.ReportQuery;

public interface Report {

    void addReportQuery(ReportQuery reportQuery);
    String generateReport();

}
