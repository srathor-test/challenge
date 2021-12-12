package dto.field.validation;

import exception.FieldException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllFieldsMandatoryVisitorImpl implements LineValidationVisitor{

    @Override
    public void validateContractId(String contractId) throws FieldException {
        if(contractId == null || contractId.isBlank()) {
            throw new FieldException("contractId field cannot be null.");
        }
        try {
            Long.valueOf(contractId);
        } catch (NumberFormatException e) {
            throw new FieldException("Exception in field contractId, NumberFormatException: " + e.getMessage());
        }

    }

    @Override
    public void validateCustomerId(String customerId) throws FieldException {
        if(customerId == null || customerId.isBlank()) {
            throw new FieldException("customerId field cannot be null.");
        }
        try {
            Long.valueOf(customerId);
        } catch (NumberFormatException e) {
            throw new FieldException("Exception in field customerId, NumberFormatException: " + e.getMessage());
        }
    }

    @Override
    public void validateGeozone(String geozone) throws FieldException {
        if(geozone == null || geozone.isBlank()) {
            throw new FieldException("geozone field cannot be null.");
        }
    }

    @Override
    public void validateTeamcode(String teamcode) throws FieldException {
        if(teamcode == null || teamcode.isBlank()) {
            throw new FieldException("teamcode field cannot be null.");
        }
    }

    @Override
    public void validateProjectcode(String projectcode) throws FieldException {
        if(projectcode == null || projectcode.isBlank()) {
            throw new FieldException("projectcode field cannot be null.");
        }
    }

    @Override
    public void validateBuildduration(String buildduration) throws FieldException {
        if(buildduration == null || buildduration.isBlank()) {
            throw new FieldException("buildduration field cannot be null.");
        }
        Pattern pattern = Pattern.compile("[0-9][0-9]*s");
        Matcher matcher = pattern.matcher(buildduration.trim());
        boolean matches = matcher.matches();
        if(!matches) {
            throw new FieldException("Exception in field buildduration, invalid format(valid format [0-9][0-9]*s, example '344s') in value: " + buildduration);
        }
    }
}

