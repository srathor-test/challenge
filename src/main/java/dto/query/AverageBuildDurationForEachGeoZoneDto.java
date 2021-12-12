package dto.query;

public class AverageBuildDurationForEachGeoZoneDto {
    private String geozone;
    private Long averageBuildDuration;

    public AverageBuildDurationForEachGeoZoneDto(String geozone, Long averageBuildDuration) {
        this.geozone = geozone;
        this.averageBuildDuration = averageBuildDuration;
    }

    public String getGeozone() {
        return geozone;
    }

    public void setGeozone(String geozone) {
        this.geozone = geozone;
    }

    public Long getAverageBuildDuration() {
        return averageBuildDuration;
    }

    public void setAverageBuildDuration(Long averageBuildDuration) {
        this.averageBuildDuration = averageBuildDuration;
    }

    @Override
    public String toString() {
        return "{" + geozone + "=" + averageBuildDuration + "}";
    }
}
