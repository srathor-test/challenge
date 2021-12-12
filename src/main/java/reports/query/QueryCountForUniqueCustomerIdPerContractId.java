package reports.query;

import dao.LineQueryDao;

public class QueryCountForUniqueCustomerIdPerContractId implements ReportQuery {

    private String message = "The number of unique customerId for each contractId ";
    private LineQueryDao dao;

    public QueryCountForUniqueCustomerIdPerContractId(LineQueryDao dao) {
        this.dao = dao;
    }

    @Override
    public String summary() {
        return message + dao.getUniqueCountCustomerPerContract();
    }
}
