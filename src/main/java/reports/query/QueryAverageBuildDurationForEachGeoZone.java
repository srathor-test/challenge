package reports.query;

import dao.LineQueryDao;

public class QueryAverageBuildDurationForEachGeoZone implements ReportQuery {

    private String message = "The average buildduration for each geozone ";
    private LineQueryDao dao;

    public QueryAverageBuildDurationForEachGeoZone(LineQueryDao dao) {
        this.dao = dao;
    }

    @Override
    public String summary() {
        return message + dao.getAverageBuildDurationForEachGeoZone();
    }
}
