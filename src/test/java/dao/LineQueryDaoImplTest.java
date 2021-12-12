package dao;

import dto.field.validation.AllFieldsMandatoryVisitorImpl;
import dto.query.AverageBuildDurationForEachGeoZoneDto;
import dto.query.CountUniqueCustomerPerContractDto;
import dto.query.CountUniqueCustomerPerGeozoneDto;
import dto.query.UniqueCustomersPerGeozoneDto;
import exception.LineException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

public class LineQueryDaoImplTest {
    public static final Logger LOGGER = Logger.getLogger(LineQueryDaoImplTest.class.getClass().getName());

    @Test
    public void getUniqueCountCustomerPerContractTest() throws LineException {
        StringBuilder lineValidStringBuilder =
                new StringBuilder()
                        .append("1,2,us_east,RedTeam,ProjectApple,3445s")
                        .append(System.lineSeparator())
                        .append("1,2,us_west,BlueTeam,ProjectBanana,2211s")
                        .append(System.lineSeparator())
                        .append("2,2,eu_west,YellowTeam3,ProjectCarrot,4322s")
                        .append(System.lineSeparator())
                        .append("2,1,eu_west,YellowTeam3,ProjectCarrot,4322s")
                        .append(System.lineSeparator())
                        .append("2,1,us_west,BlueTeam,ProjectDate,2221s")
                        .append(System.lineSeparator())
                        .append("1,2,eu_west,YellowTeam3,ProjectEgg,4122s");

        LineDao dao = new LineDaoImpl(new ArrayList<>(), new AllFieldsMandatoryVisitorImpl());
        dao.addLine(lineValidStringBuilder.toString());

        LineQueryDao queryDao = new LineQueryDaoImpl(dao.getLines());
        List<CountUniqueCustomerPerContractDto> countUniqueCustomerPerContractDtos = queryDao.getUniqueCountCustomerPerContract();
        LOGGER.info(countUniqueCustomerPerContractDtos.toString());
        Optional<CountUniqueCustomerPerContractDto> contractResult =
                countUniqueCustomerPerContractDtos.stream().filter(e -> e.getContractId().equals(2L)).findFirst();
        Integer count = contractResult.get().getUniqueCustomerIdCount();

        Assert.assertEquals(Integer.valueOf(2), count);
    }

    @Test
    public void getUniqueCountCustomerPerGeozoneTest() throws LineException {
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
        List<CountUniqueCustomerPerGeozoneDto> result = queryDao.getUniqueCountCustomerPerGeozone();
        LOGGER.info(result.toString());
        Optional<CountUniqueCustomerPerGeozoneDto> contractResult =
                result.stream().filter(e -> e.getGeozone().equals("eu_west")).findFirst();
        Integer count = contractResult.get().getUniqueCustomerIdCount();
        Assert.assertEquals(Integer.valueOf(3), count);
    }

    @Test
    public void getAverageBuildDurationForEachGeoZoneTest() throws LineException {
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
        List<AverageBuildDurationForEachGeoZoneDto> result = queryDao.getAverageBuildDurationForEachGeoZone();
        LOGGER.info(result.toString());
        Optional<AverageBuildDurationForEachGeoZoneDto> contractResult =
                result.stream().filter(e -> e.getGeozone().equals("eu_west")).findFirst();
        Long duration = contractResult.get().getAverageBuildDuration();
        Assert.assertEquals(Long.valueOf(20), duration);
    }

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
        List<UniqueCustomersPerGeozoneDto> result = queryDao.getUniqueCustomersPerGeozoneDto();
        LOGGER.info(result.toString());
        Optional<UniqueCustomersPerGeozoneDto> uniqueCustomers = result.stream().filter(e -> e.getGeozone().equals("eu_west")).findFirst();
        Set<Long> ids = uniqueCustomers.get().getCustomerIds();
        Assert.assertEquals(3, ids.size());
    }
}
