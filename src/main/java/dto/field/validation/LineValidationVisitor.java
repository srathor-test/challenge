package dto.field.validation;

import exception.FieldException;

public interface LineValidationVisitor {
    void validateContractId(String contractId) throws FieldException;
    void validateCustomerId(String customerId) throws FieldException;
    void validateGeozone(String geozone) throws FieldException;
    void validateTeamcode(String teamcode) throws FieldException;
    void validateProjectcode(String projectcode) throws FieldException;
    void validateBuildduration(String buildduration) throws FieldException;
}
