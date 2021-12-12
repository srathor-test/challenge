package dto.field;

import dto.field.validation.LineValidationVisitor;
import exception.FieldException;

import java.util.Objects;

public class GeoZone {
    private String value;

    private GeoZone(String value) {
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
            visitor.validateGeozone(value);
            this.value = value;
            return this;
        }

        public GeoZone build() {
            return new GeoZone(this.value);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeoZone geoZone = (GeoZone) o;
        return value.equals(geoZone.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
