package dto.field;

import dto.field.validation.LineValidationVisitorImpl;
import exception.FieldException;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class ProjectCodeTest extends BaseFieldTest {
    public static final Logger LOGGER = Logger.getLogger(ProjectCodeTest.class.getClass().getName());

    @Test(expected = FieldException.class)
    public void nullValidatorTest() throws FieldException {
        ProjectCode.Builder builder = ProjectCode.Builder.newInstance(null);
        builder.value("ProjectApple").build();
        LOGGER.info("Unreachable code.");
    }

    @Test
    public void validInputTest() throws FieldException {
        ProjectCode.Builder builder = ProjectCode.Builder.newInstance(noValidationVisitor);
        ProjectCode projectCode = builder.value("ProjectApple").build();
        Assert.assertEquals("ProjectApple", projectCode.getValue());
    }

    @Test
    public void nullValueTest() throws FieldException {
        ProjectCode.Builder builder = ProjectCode.Builder.newInstance(noValidationVisitor);
        ProjectCode projectCode = builder.value(null).build();
        Assert.assertEquals(null, projectCode.getValue());
    }
}
