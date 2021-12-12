package dto.field.validation;

import exception.FieldException;
import org.junit.Test;

import java.util.logging.Logger;

public class NullableFieldsValidationVisitorImplTest {

    public static final Logger LOGGER = Logger.getLogger(NullableFieldsValidationVisitorImplTest.class.getClass().getName());

    @Test
    public void customerIdValidValueTest() throws FieldException {
        LineValidationVisitorImpl validationVisitor = new LineValidationVisitorImpl();
        validationVisitor.validateCustomerId("2343225");
        LOGGER.info("Validation Passed!");
    }

    @Test(expected = FieldException.class)
    public void customerIdInvalidValueTest() throws FieldException {
        LineValidationVisitorImpl validationVisitor = new LineValidationVisitorImpl();
        LOGGER.info("Invalid customerId value testing.");
        validationVisitor.validateCustomerId("2$43225");
        LOGGER.info("This line should not have been printed.");
    }

    @Test
    public void customerIdNullValueTest() throws FieldException {
        LineValidationVisitorImpl validationVisitor = new LineValidationVisitorImpl();
        validationVisitor.validateCustomerId(null);
        LOGGER.info("Validation Passed!");
    }

    @Test
    public void contractIdValidValueTest() throws FieldException {
        LineValidationVisitorImpl validationVisitor = new LineValidationVisitorImpl();
        validationVisitor.validateContractId("2345");
        LOGGER.info("Validation Passed!");
    }

    @Test(expected = FieldException.class)
    public void contractIdInvalidValueTest() throws FieldException {
        LineValidationVisitorImpl validationVisitor = new LineValidationVisitorImpl();
        LOGGER.info("Invalid contractId value testing.");
        validationVisitor.validateContractId("23w45");
        LOGGER.info("This line should not have been printed.");
    }

    @Test
    public void contractIdNullValueTest() throws FieldException {
        LineValidationVisitorImpl validationVisitor = new LineValidationVisitorImpl();
        validationVisitor.validateContractId(null);
        LOGGER.info("Validation Passed!");
    }

    @Test
    public void buildDurationValidValueTest() throws FieldException {
        LineValidationVisitorImpl validationVisitor = new LineValidationVisitorImpl();
        validationVisitor.validateBuildduration("3445s");
        LOGGER.info("Validation Passed!");
    }

    @Test(expected = FieldException.class)
    public void buildDurationInvalidValueTest() throws FieldException {
        LineValidationVisitorImpl validationVisitor = new LineValidationVisitorImpl();
        LOGGER.info("Invalid buildduration value testing.");
        validationVisitor.validateContractId("3445s1");
        LOGGER.info("This line should not have been printed.");
    }

    @Test(expected = FieldException.class)
    public void buildDurationInvalidValueWithUnitTest() throws FieldException {
        LineValidationVisitorImpl validationVisitor = new LineValidationVisitorImpl();
        LOGGER.info("Invalid buildduration value testing.");
        validationVisitor.validateContractId("s");
        LOGGER.info("This line should not have been printed.");
    }

    @Test
    public void buildDurationNullValueTest() throws FieldException {
        LineValidationVisitorImpl validationVisitor = new LineValidationVisitorImpl();
        validationVisitor.validateBuildduration(null);
        LOGGER.info("Validation Passed!");
    }
}
