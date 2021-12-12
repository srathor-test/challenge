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

public class QueryUniqueCustomersPerGeozoneTest {
    public static final Logger LOGGER =
            Logger.getLogger(QueryUniqueCustomersPerGeozoneTest.class.getClass().getName());
    @Test
    public void getUniqueCustomersPerGeozoneDtoTest() throws LineException {
        StringBuilder lineValidStringBuilder =
                new StringBuilder()
                        .append("1,2,eu_west,RedTeam,ProjectApple,3445s")
                        .append(System.lineSeparator())
                        .append("1,2,us_west,BlueTeam,ProjectBanana,2211s")
                        .append(System.lineSeparator())
                        .append("2,2,eu_west,YellowTeam3,ProjectCarrot,4322s")
                        .append(System.lineSeparator())
                        .append("2,1,eu_west,YellowTeam3,ProjectCarrot,4322s")
                        .append(System.lineSeparator())
                        .append("2,1,us_west,BlueTeam,ProjectDate,2221s")
                        .append(System.lineSeparator())
                        .append("3,2,eu_west,YellowTeam3,ProjectEgg,4122s");

        LineDao dao = new LineDaoImpl(new ArrayList<>(), new AllFieldsMandatoryVisitorImpl());
        dao.addLine(lineValidStringBuilder.toString());

        LineQueryDao queryDao = new LineQueryDaoImpl(dao.getLines());
        QueryUniqueCustomersPerGeozone classUnderTest = new QueryUniqueCustomersPerGeozone(queryDao);

        String summary = classUnderTest.summary();
        LOGGER.info(summary);
        Assert.assertNotNull(summary);
    }
}
