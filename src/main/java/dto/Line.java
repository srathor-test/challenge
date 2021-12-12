package dto;

import dto.field.*;

public class Line {
    private CustomerId customerId;
    private ContractId contractId;
    private GeoZone geozone;
    private TeamCode teamcode;
    private ProjectCode projectcode;
    private BuildDuration buildduration;

    public Line(CustomerId customerId, ContractId contractId, GeoZone geozone, TeamCode teamcode, ProjectCode projectcode, BuildDuration buildduration) {
        this.customerId = customerId;
        this.contractId = contractId;
        this.geozone = geozone;
        this.teamcode = teamcode;
        this.projectcode = projectcode;
        this.buildduration = buildduration;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerId customerId) {
        this.customerId = customerId;
    }

    public ContractId getContractId() {
        return contractId;
    }

    public void setContractId(ContractId contractId) {
        this.contractId = contractId;
    }

    public GeoZone getGeozone() {
        return geozone;
    }

    public void setGeozone(GeoZone geozone) {
        this.geozone = geozone;
    }

    public TeamCode getTeamcode() {
        return teamcode;
    }

    public void setTeamcode(TeamCode teamcode) {
        this.teamcode = teamcode;
    }

    public ProjectCode getProjectcode() {
        return projectcode;
    }

    public void setProjectcode(ProjectCode projectcode) {
        this.projectcode = projectcode;
    }

    public BuildDuration getBuildduration() {
        return buildduration;
    }

    public void setBuildduration(BuildDuration buildduration) {
        this.buildduration = buildduration;
    }

    public static class Builder {
        private CustomerId customerId;
        private ContractId contractId;
        private GeoZone geozone;
        private TeamCode teamcode;
        private ProjectCode projectcode;
        private BuildDuration buildduration;

        public static Builder newInstance() {
            return new Builder();
        }

        public Builder customerId(CustomerId customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder contractId(ContractId contractId) {
            this.contractId = contractId;
            return this;
        }

        public Builder geozone(GeoZone geozone) {
            this.geozone = geozone;
            return this;
        }

        public Builder teamcode(TeamCode teamcode) {
            this.teamcode = teamcode;
            return this;
        }

        public Builder projectcode(ProjectCode projectcode) {
            this.projectcode = projectcode;
            return this;
        }

        public Builder buildduration(BuildDuration buildduration) {
            this.buildduration = buildduration;
            return this;
        }

        public Line build() {
            return new Line(this.customerId
                    , this.contractId
                    ,this.geozone
                    ,this.teamcode
                    ,this.projectcode
                    ,this.buildduration);
        }
    }
}
