package dto.field.validation;

import exception.FieldException;
import org.junit.Test;

import java.util.logging.Logger;

public class AllFieldsMandatoryVisitorImplTest {
    public static final Logger LOGGER = Logger.getLogger(AllFieldsMandatoryVisitorImplTest.class.getClass().getName());

    @Test
    public void customerIdValidValueTest() throws FieldException {
        AllFieldsMandatoryVisitorImpl validationVisitor = new AllFieldsMandatoryVisitorImpl();
        validationVisitor.validateCustomerId("2343225");
        LOGGER.info("Validation Passed!");
    }

    @Test(expected = FieldException.class)
    public void customerIdInvalidValueTest() throws FieldException {
        AllFieldsMandatoryVisitorImpl validationVisitor = new AllFieldsMandatoryVisitorImpl();
        LOGGER.info("Invalid customerId value testing.");
        validationVisitor.validateCustomerId("2$43225");
        LOGGER.info("This line should not have been printed.");
    }

    @Test(expected = FieldException.class)
    public void customerIdNullValueTest() throws FieldException {
        AllFieldsMandatoryVisitorImpl validationVisitor = new AllFieldsMandatoryVisitorImpl();
        validationVisitor.validateCustomerId(null);
        LOGGER.info("This line should not have been printed.");
    }

    @Test
    public void contractIdValidValueTest() throws FieldException {
        AllFieldsMandatoryVisitorImpl validationVisitor = new AllFieldsMandatoryVisitorImpl();
        validationVisitor.validateContractId("2345");
        LOGGER.info("Validation Passed!");
    }

    @Test(expected = FieldException.class)
    public void contractIdInvalidValueTest() throws FieldException {
        AllFieldsMandatoryVisitorImpl validationVisitor = new AllFieldsMandatoryVisitorImpl();
        LOGGER.info("Invalid contractId value testing.");
        validationVisitor.validateContractId("23w45");
        LOGGER.info("This line should not have been printed.");
    }

    @Test(expected = FieldException.class)
    public void contractIdNullValueTest() throws FieldException {
        AllFieldsMandatoryVisitorImpl validationVisitor = new AllFieldsMandatoryVisitorImpl();
        validationVisitor.validateContractId(null);
        LOGGER.info("This line should not have been printed.");
    }

    @Test
    public void buildDurationValidValueTest() throws FieldException {
        AllFieldsMandatoryVisitorImpl validationVisitor = new AllFieldsMandatoryVisitorImpl();
        validationVisitor.validateBuildduration("3445s");
        LOGGER.info("Validation Passed!");
    }

    @Test(expected = FieldException.class)
    public void buildDurationInvalidValueTest() throws FieldException {
        AllFieldsMandatoryVisitorImpl validationVisitor = new AllFieldsMandatoryVisitorImpl();
        LOGGER.info("Invalid buildduration value testing.");
        validationVisitor.validateContractId("3445s1");
        LOGGER.info("This line should not have been printed.");
    }

    @Test(expected = FieldException.class)
    public void buildDurationInvalidValueWithUnitTest() throws FieldException {
        AllFieldsMandatoryVisitorImpl validationVisitor = new AllFieldsMandatoryVisitorImpl();
        LOGGER.info("Invalid buildduration value testing.");
        validationVisitor.validateContractId("s");
        LOGGER.info("This line should not have been printed.");
    }

    @Test(expected = FieldException.class)
    public void buildDurationNullValueTest() throws FieldException {
        AllFieldsMandatoryVisitorImpl validationVisitor = new AllFieldsMandatoryVisitorImpl();
        validationVisitor.validateBuildduration(null);
        LOGGER.info("This line should not have been printed.");
    }

    @Test(expected = FieldException.class)
    public void geoZoneNullValueTest() throws FieldException {
        AllFieldsMandatoryVisitorImpl validationVisitor = new AllFieldsMandatoryVisitorImpl();
        validationVisitor.validateGeozone(null);
        LOGGER.info("This line should not have been printed.");
    }

    @Test(expected = FieldException.class)
    public void projectCodeNullValueTest() throws FieldException {
        AllFieldsMandatoryVisitorImpl validationVisitor = new AllFieldsMandatoryVisitorImpl();
        validationVisitor.validateProjectcode(null);
        LOGGER.info("This line should not have been printed.");
    }

    @Test(expected = FieldException.class)
    public void teamCodeNullValueTest() throws FieldException {
        AllFieldsMandatoryVisitorImpl validationVisitor = new AllFieldsMandatoryVisitorImpl();
        validationVisitor.validateTeamcode(null);
        LOGGER.info("This line should not have been printed.");
    }
}
