package dto.field;

import exception.FieldException;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class ContractIdTest extends BaseFieldTest {
    public static final Logger LOGGER = Logger.getLogger(ContractIdTest.class.getClass().getName());

    @Test(expected = FieldException.class)
    public void nullValidatorTest() throws FieldException {
        ContractId.Builder builder = ContractId.Builder.newInstance(null);
        builder.value("234").build();
        LOGGER.info("Unreachable code.");
    }

    @Test
    public void validInputTest() throws FieldException {
        ContractId.Builder builder = ContractId.Builder.newInstance(noValidationVisitor);
        ContractId contractId = builder.value("23455").build();
        Assert.assertEquals(Long.valueOf(23455L), contractId.getValue());
    }

    @Test
    public void nullValueTest() throws FieldException {
        ContractId.Builder builder = ContractId.Builder.newInstance(noValidationVisitor);
        ContractId contractId = builder.value(null).build();
        Assert.assertNull(contractId.getValue());
    }
}
