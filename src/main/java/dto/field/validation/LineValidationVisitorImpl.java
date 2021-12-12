package dto.field.validation;

import exception.FieldException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineValidationVisitorImpl implements LineValidationVisitor{

    @Override
    public void validateContractId(String contractId) throws FieldException {
        if(contractId != null && !contractId.isBlank()) {
            try {
                Long.valueOf(contractId);
            } catch (NumberFormatException e) {
                throw new FieldException("Exception in field contractId, NumberFormatException: " + e.getMessage());
            }
        }
    }

    @Override
    public void validateCustomerId(String customerId) throws FieldException {
        if(customerId != null && !customerId.isBlank()) {
            try {
                Long.valueOf(customerId);
            } catch (NumberFormatException e) {
                throw new FieldException("Exception in field customerId, NumberFormatException: " + e.getMessage());
            }
        }
    }

    @Override
    public void validateGeozone(String geozone) throws FieldException {}

    @Override
    public void validateTeamcode(String teamcode) throws FieldException {}

    @Override
    public void validateProjectcode(String projectcode) throws FieldException {}

    @Override
    public void validateBuildduration(String buildduration) throws FieldException {
        if(buildduration != null && !buildduration.isBlank()) {
            Pattern pattern = Pattern.compile("[0-9][0-9]*s");
            Matcher matcher = pattern.matcher(buildduration);
            boolean matches = matcher.matches();
            if(!matches) {
                throw new FieldException("Exception in field buildduration, invalid format(valid format [0-9][0-9]*s, example '344s') in value: " + buildduration);
            }
        }

    }
}
