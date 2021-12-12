package dto.query;

public class CountUniqueCustomerPerGeozoneDto {
    private String geozone;
    private Integer uniqueCustomerIdCount;

    public CountUniqueCustomerPerGeozoneDto(String geozone, Integer uniqueCustomerIdCount) {
        this.geozone = geozone;
        this.uniqueCustomerIdCount = uniqueCustomerIdCount;
    }

    public String getGeozone() {
        return geozone;
    }

    public void setGeozone(String geozone) {
        this.geozone = geozone;
    }

    public Integer getUniqueCustomerIdCount() {
        return uniqueCustomerIdCount;
    }

    public void setUniqueCustomerIdCount(Integer uniqueCustomerIdCount) {
        this.uniqueCustomerIdCount = uniqueCustomerIdCount;
    }

    @Override
    public String toString() {
        return "{" + geozone + "=" + uniqueCustomerIdCount + "}";
    }
}
