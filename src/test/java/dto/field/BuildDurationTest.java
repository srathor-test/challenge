package dto.field;

import dto.field.validation.LineValidationVisitorImpl;
import exception.FieldException;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class BuildDurationTest extends BaseFieldTest {
    public static final Logger LOGGER = Logger.getLogger(BuildDuration.class.getClass().getName());

    @Test(expected = FieldException.class)
    public void nullValidatorTest() throws FieldException {
        BuildDuration.Builder builder = BuildDuration.Builder.newInstance(null);
        BuildDuration buildDuration = builder.value("2s").build();
        LOGGER.info("Unreachable code.");
    }

    @Test
    public void validInputTest() throws FieldException {
        BuildDuration.Builder builder = BuildDuration.Builder.newInstance(noValidationVisitor);
        BuildDuration buildDuration = builder.value("2s").build();
        Assert.assertEquals(Long.valueOf(2L), buildDuration.getValue());
    }

    @Test
    public void nullValueTest() throws FieldException {
        BuildDuration.Builder builder = BuildDuration.Builder.newInstance(noValidationVisitor);
        BuildDuration buildDuration = builder.value(null).build();
        Assert.assertEquals(null, buildDuration.getValue());
    }
}
