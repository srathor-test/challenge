package dto.field;

import dto.field.validation.LineValidationVisitor;
import exception.FieldException;

public class ProjectCode {
    private String value;

    private ProjectCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static class Builder {
        private String value;
        private LineValidationVisitor visitor;

        public Builder(LineValidationVisitor visitor) {
            this.visitor = visitor;
        }

        public static Builder newInstance(LineValidationVisitor visitor) {
            return new Builder(visitor);
        }

        public Builder value(String value) throws FieldException {
            if(visitor == null) {
                throw new FieldException("Field Validator is null");
            }
            visitor.validateProjectcode(value);
            this.value = value;
            return this;
        }

        public ProjectCode build() {
            return new ProjectCode(this.value);
        }
    }
}
