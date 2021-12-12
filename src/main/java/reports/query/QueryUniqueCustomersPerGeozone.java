package reports.query;

import dao.LineQueryDao;

public class QueryUniqueCustomersPerGeozone implements ReportQuery {

    private String message = "The list of unique customerId for each geozone ";
    private LineQueryDao dao;

    public QueryUniqueCustomersPerGeozone(LineQueryDao dao) {
        this.dao = dao;
    }

    @Override
    public String summary() {
        return message + dao.getUniqueCustomersPerGeozoneDto();
    }
}