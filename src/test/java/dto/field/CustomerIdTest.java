package dto.field;

import exception.FieldException;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class CustomerIdTest extends BaseFieldTest {
    public static final Logger LOGGER = Logger.getLogger(CustomerIdTest.class.getClass().getName());

    @Test(expected = FieldException.class)
    public void nullValidatorTest() throws FieldException {
        CustomerId.Builder builder = CustomerId.Builder.newInstance(null);
        builder.value("234").build();
        LOGGER.info("Unreachable code.");
    }

    @Test
    public void validInputTest() throws FieldException {
        CustomerId.Builder builder = CustomerId.Builder.newInstance(noValidationVisitor);
        CustomerId customerId = builder.value("23455").build();
        Assert.assertEquals(Long.valueOf(23455L), customerId.getValue());
    }

    @Test
    public void nullValueTest() throws FieldException {
        CustomerId.Builder builder = CustomerId.Builder.newInstance(noValidationVisitor);
        CustomerId customerId = builder.value(null).build();
        Assert.assertNull(customerId.getValue());
    }
}
