package dto.field;

import dto.field.validation.LineValidationVisitorImpl;
import exception.FieldException;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class TeamCodeTest extends BaseFieldTest {
    public static final Logger LOGGER = Logger.getLogger(TeamCodeTest.class.getClass().getName());

    @Test(expected = FieldException.class)
    public void nullValidatorTest() throws FieldException {
        TeamCode.Builder builder = TeamCode.Builder.newInstance(null);
        builder.value("ProjectApple").build();
        LOGGER.info("Unreachable code.");
    }

    @Test
    public void validInputTest() throws FieldException {
        TeamCode.Builder builder = TeamCode.Builder.newInstance(noValidationVisitor);
        TeamCode teamCode = builder.value("ProjectApple").build();
        Assert.assertEquals("ProjectApple", teamCode.getValue());
    }

    @Test
    public void nullValueTest() throws FieldException {
        TeamCode.Builder builder = TeamCode.Builder.newInstance(noValidationVisitor);
        TeamCode teamCode = builder.value(null).build();
        Assert.assertEquals(null, teamCode.getValue());
    }
}
