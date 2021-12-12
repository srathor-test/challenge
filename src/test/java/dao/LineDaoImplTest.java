package dao;

import dto.field.validation.AllFieldsMandatoryVisitorImpl;
import exception.LineException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.logging.Logger;

public class LineDaoImplTest {
    public static final Logger LOGGER = Logger.getLogger(LineDaoImplTest.class.getClass().getName());

    @Test
    public void populateDaoWithValidDataSingleLineTest() throws LineException {
        StringBuilder lineValidSingleLineStringBuilder =
                new StringBuilder()
                        .append("2343225,2345,us_east,RedTeam,ProjectApple,3445s");

        LineDao dao = new LineDaoImpl(new ArrayList<>(), new AllFieldsMandatoryVisitorImpl());
        dao.addLine(lineValidSingleLineStringBuilder.toString());
        Assert.assertEquals(1, dao.getLines().size());
    }

    @Test
    public void populateDaoWithValidDataTest() throws LineException {
        StringBuilder lineValidStringBuilder =
                new StringBuilder()
                        .append("2343225,2345,us_east,RedTeam,ProjectApple,3445s")
                        .append(System.lineSeparator())
                        .append("1223456,2345,us_west,BlueTeam,ProjectBanana,2211s")
                        .append(System.lineSeparator())
                        .append("3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s")
                        .append(System.lineSeparator())
                        .append("1233456,2345,us_west,BlueTeam,ProjectDate,2221s")
                        .append(System.lineSeparator())
                        .append("3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s");

        LineDao dao = new LineDaoImpl(new ArrayList<>(), new AllFieldsMandatoryVisitorImpl());
        dao.addLine(lineValidStringBuilder.toString());
        Assert.assertEquals(5, dao.getLines().size());
    }

    @Test(expected = LineException.class)
    public void populateDaoWithInvalidLargerColumnCountTest() throws LineException {
        StringBuilder lineInvalidLargerColumnCount =
                new StringBuilder()
                        .append("2343225,2345,us_east,RedTeam,Project,Apple,3445s")
                        .append(System.lineSeparator())
                        .append("1223456,2345,us_west,BlueTeam,ProjectBanana,2211s");

        LineDao dao = new LineDaoImpl(new ArrayList<>(), new AllFieldsMandatoryVisitorImpl());
        try {
            dao.addLine(lineInvalidLargerColumnCount.toString());
        } catch (LineException le) {
            LOGGER.info(le.getMessage());
            throw le;
        }
    }

    @Test(expected = LineException.class)
    public void populateDaoWithInvalidSmallerColumnCountTest() throws LineException {
        StringBuilder lineInvalidSmallerColumnCount =
                new StringBuilder()
                        .append("2343225,2345,us_east,RedTeamProjectApple")
                        .append(System.lineSeparator())
                        .append("1223456,2345,us_west,BlueTeam,ProjectBanana,2211s");
        LineDao dao = new LineDaoImpl(new ArrayList<>(), new AllFieldsMandatoryVisitorImpl());
        try {
            dao.addLine(lineInvalidSmallerColumnCount.toString());
        } catch (LineException le) {
            LOGGER.info(le.getMessage());
            throw le;
        }
    }

    @Test(expected = LineException.class)
    public void populateDaoWithEmptyStringTest() throws LineException {
        LineDao dao = new LineDaoImpl(new ArrayList<>(), new AllFieldsMandatoryVisitorImpl());
        try {
            dao.addLine("");
        } catch (LineException le) {
            LOGGER.info(le.getMessage());
            throw le;
        }
    }

    @Test(expected = LineException.class)
    public void populateDaoWithNullStringTest() throws LineException {
        LineDao dao = new LineDaoImpl(new ArrayList<>(), new AllFieldsMandatoryVisitorImpl());
        try {
            dao.addLine(null);
        } catch (LineException le) {
            LOGGER.info(le.getMessage());
            throw le;
        }
    }

    @Test(expected = LineException.class)
    public void populateDaoWithInvalidDataInFieldTest() throws LineException {
        StringBuilder lineInvalidDataInFieldCustomerId =
                new StringBuilder()
                        .append("fsdfsd,2345,us_east,RedTeam,ProjectApple,3445s");
        LineDao dao = new LineDaoImpl(new ArrayList<>(), new AllFieldsMandatoryVisitorImpl());
        try {
        dao.addLine(lineInvalidDataInFieldCustomerId.toString());
        } catch (LineException le) {
            LOGGER.info(le.getMessage());
            throw le;
        }
        Assert.assertEquals(5, dao.getLines().size());
    }


}
