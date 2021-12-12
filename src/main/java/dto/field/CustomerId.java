package dto.field;

import dto.field.validation.LineValidationVisitor;
import exception.FieldException;

import java.util.Objects;

public class CustomerId {
    private Long value;

    private CustomerId(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public static class Builder {
        private Long value;
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
            visitor.validateCustomerId(value);
            if(value != null && !value.isBlank()) {
                this.value = Long.valueOf(value);
            }
            return this;
        }

        public CustomerId build() {
            return new CustomerId(this.value);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerId that = (CustomerId) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
