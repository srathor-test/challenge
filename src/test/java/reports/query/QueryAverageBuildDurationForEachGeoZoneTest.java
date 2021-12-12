package reports.query;

import dao.LineDao;
import dao.LineDaoImpl;
import dao.LineQueryDao;
import dao.LineQueryDaoImpl;
import dto.field.validation.AllFieldsMandatoryVisitorImpl;
import exception.LineException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.logging.Logger;

public class QueryAverageBuildDurationForEachGeoZoneTest {
    public static final Logger LOGGER =
            Logger.getLogger(QueryAverageBuildDurationForEachGeoZoneTest.class.getClass().getName());

    @Test
    public void testQuery() throws LineException {
        StringBuilder lineValidStringBuilder =
                new StringBuilder()
                        .append("1,2,eu_west,RedTeam,ProjectApple,30s")
                        .append(System.lineSeparator())
                        .append("1,2,us_west,BlueTeam,ProjectBanana,20s")
                        .append(System.lineSeparator())
                        .append("2,2,eu_west,YellowTeam3,ProjectCarrot,10s")
                        .append(System.lineSeparator())
                        .append("3,2,eu_west,YellowTeam3,ProjectEgg,20s");

        LineDao dao = new LineDaoImpl(new ArrayList<>(), new AllFieldsMandatoryVisitorImpl());
        dao.addLine(lineValidStringBuilder.toString());

        LineQueryDao queryDao = new LineQueryDaoImpl(dao.getLines());

        QueryAverageBuildDurationForEachGeoZone classUnderTest = new QueryAverageBuildDurationForEachGeoZone(queryDao);

        String summary = classUnderTest.summary();
        LOGGER.info(summary);
        Assert.assertNotNull(summary);
    }
}
