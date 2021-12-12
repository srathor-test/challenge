package reports.query;

import dao.LineQueryDao;

public class QueryCountUniqueCustomerIdPerGeozone implements ReportQuery {

    private String message = "The number of unique customerId for each geozone ";
    private LineQueryDao dao;

    public QueryCountUniqueCustomerIdPerGeozone(LineQueryDao dao) {
        this.dao = dao;
    }

    @Override
    public String summary() {
        return message + dao.getUniqueCountCustomerPerGeozone();
    }
}