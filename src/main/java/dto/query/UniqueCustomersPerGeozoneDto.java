package dto.query;

import java.util.Set;

public class UniqueCustomersPerGeozoneDto {
    private String geozone;
    private Set<Long> customerIds;

    public UniqueCustomersPerGeozoneDto(String geozone, Set<Long> customerIds) {
        this.geozone = geozone;
        this.customerIds = customerIds;
    }

    public String getGeozone() {
        return geozone;
    }

    public void setGeozone(String geozone) {
        this.geozone = geozone;
    }

    public Set<Long> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(Set<Long> customerIds) {
        this.customerIds = customerIds;
    }

    @Override
    public String toString() {
        return "{" + geozone  + "=" + idsToString(customerIds) + "}";
    }

    public String idsToString(Set<Long> ids) {
        StringBuilder sb = new StringBuilder();
        Boolean firstId = true;
        sb.append("(");
        for(Long id : ids) {
            if(firstId) {

                sb.append(id);
                firstId = false;
            } else {
                sb.append(", ");
                sb.append(id);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
