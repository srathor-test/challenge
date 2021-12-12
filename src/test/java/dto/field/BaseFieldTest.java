package dto.field;

import dto.field.validation.LineValidationVisitor;
import exception.FieldException;

public class BaseFieldTest {
    protected LineValidationVisitor noValidationVisitor = new LineValidationVisitor() {

        @Override
        public void validateContractId(String contractId) throws FieldException {}

        @Override
        public void validateCustomerId(String customerId) throws FieldException {}

        @Override
        public void validateGeozone(String geozone) throws FieldException {}

        @Override
        public void validateTeamcode(String teamcode) throws FieldException {}

        @Override
        public void validateProjectcode(String projectcode) throws FieldException {}

        @Override
        public void validateBuildduration(String buildduration) throws FieldException {}
    };
}
