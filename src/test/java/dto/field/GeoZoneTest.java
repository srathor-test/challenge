package dto.field;

import dto.field.validation.LineValidationVisitorImpl;
import exception.FieldException;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class GeoZoneTest extends BaseFieldTest {
    public static final Logger LOGGER = Logger.getLogger(GeoZoneTest.class.getClass().getName());

    @Test(expected = FieldException.class)
    public void nullValidatorTest() throws FieldException {
        GeoZone.Builder builder = GeoZone.Builder.newInstance(null);
        builder.value("us_east").build();
        LOGGER.info("Unreachable code.");
    }

    @Test
    public void validInputTest() throws FieldException {
        GeoZone.Builder builder = GeoZone.Builder.newInstance(noValidationVisitor);
        GeoZone geoZone = builder.value("us_east").build();
        Assert.assertEquals("us_east", geoZone.getValue());
    }

    @Test
    public void nullValueTest() throws FieldException {
        GeoZone.Builder builder = GeoZone.Builder.newInstance(noValidationVisitor);
        GeoZone geoZone = builder.value(null).build();
        Assert.assertEquals(null, geoZone.getValue());
    }
}
