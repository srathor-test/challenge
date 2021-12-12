package dto.query;

public class CountUniqueCustomerPerContractDto {
    private Long contractId;
    private Integer uniqueCustomerIdCount;

    public CountUniqueCustomerPerContractDto(Long contractId, Integer count) {
        this.contractId = contractId;
        this.uniqueCustomerIdCount = count;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Integer getUniqueCustomerIdCount() {
        return uniqueCustomerIdCount;
    }

    public void setUniqueCustomerIdCount(Integer uniqueCustomerIdCount) {
        this.uniqueCustomerIdCount = uniqueCustomerIdCount;
    }

    @Override
    public String toString() {
        return "{" + contractId + "=" + uniqueCustomerIdCount + "}";
    }
}
