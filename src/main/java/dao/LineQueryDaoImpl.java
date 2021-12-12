package dao;

import dto.Line;
import dto.field.ContractId;
import dto.field.CustomerId;
import dto.field.GeoZone;
import dto.query.AverageBuildDurationForEachGeoZoneDto;
import dto.query.CountUniqueCustomerPerContractDto;
import dto.query.CountUniqueCustomerPerGeozoneDto;
import dto.query.UniqueCustomersPerGeozoneDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class LineQueryDaoImpl implements LineQueryDao {

    private List<Line> lines;

    public LineQueryDaoImpl(List<Line> lines) {
        this.lines = lines;
    }

    @Override
    public List<CountUniqueCustomerPerContractDto> getUniqueCountCustomerPerContract() {
        if(lines == null) {
            return new ArrayList<>();
        }

        Map<ContractId, Map<CustomerId, List<Line>>> map = lines.stream()
                .collect(groupingBy(Line::getContractId, groupingBy(Line::getCustomerId)));

        Set<ContractId> contracts = map.keySet();
        List<CountUniqueCustomerPerContractDto> result = new ArrayList<>(contracts.size());

        for(ContractId contractId: contracts) {
            Map<CustomerId, List<Line>> customerIds = map.get(contractId);
            Set<CustomerId> customers = customerIds.keySet();
            CountUniqueCustomerPerContractDto item = new CountUniqueCustomerPerContractDto(contractId.getValue(), customers.size());
            result.add(item);
        }
        return result;
    }

    @Override
    public List<CountUniqueCustomerPerGeozoneDto> getUniqueCountCustomerPerGeozone() {
        if(lines == null) {
            return new ArrayList<>();
        }

        Map<GeoZone, Map<CustomerId, List<Line>>> map = lines.stream()
                .collect(groupingBy(Line::getGeozone, groupingBy(Line::getCustomerId)));

        Set<GeoZone> geoZones = map.keySet();
        List<CountUniqueCustomerPerGeozoneDto> result = new ArrayList<>(geoZones.size());

        for(GeoZone geoZone: geoZones) {
            Map<CustomerId, List<Line>> customerIds = map.get(geoZone);
            Set<CustomerId> customers = customerIds.keySet();
            CountUniqueCustomerPerGeozoneDto item = new CountUniqueCustomerPerGeozoneDto(geoZone.getValue(), customers.size());
            result.add(item);
        }
        return result;
    }

    @Override
    public List<AverageBuildDurationForEachGeoZoneDto> getAverageBuildDurationForEachGeoZone() {
        if(lines == null) {
            return new ArrayList<>();
        }

        Map<GeoZone, List<Line>> map = lines.stream()
                .collect(groupingBy(Line::getGeozone));

        Set<GeoZone> geoZones = map.keySet();
        List<AverageBuildDurationForEachGeoZoneDto> result = new ArrayList<>(geoZones.size());

        for(GeoZone geoZone: geoZones) {
            List<Line> geoZoneLines = map.get(geoZone);
            long sumOfBuildDurations = geoZoneLines.stream()
                    .mapToLong(i -> i.getBuildduration().getValue()).reduce(0L, Long::sum);

            AverageBuildDurationForEachGeoZoneDto item = new AverageBuildDurationForEachGeoZoneDto(geoZone.getValue()
                    , sumOfBuildDurations/geoZoneLines.size());
            result.add(item);
        }
        return result;
    }

    @Override
    public List<UniqueCustomersPerGeozoneDto> getUniqueCustomersPerGeozoneDto() {
        if(lines == null) {
            return new ArrayList<>();
        }

        Map<GeoZone, Map<CustomerId, List<Line>>> map = lines.stream()
                .collect(groupingBy(Line::getGeozone, groupingBy(Line::getCustomerId)));

        Set<GeoZone> geoZones = map.keySet();

        List<UniqueCustomersPerGeozoneDto> result = new ArrayList<>();

        for(GeoZone geoZone: geoZones) {
            Map<CustomerId, List<Line>> customerIds = map.get(geoZone);
            Set<CustomerId> customers = customerIds.keySet();
            Set<Long> listOfCustomerIds = customers.stream().map( item -> item.getValue()).collect(Collectors.toSet());
            UniqueCustomersPerGeozoneDto item = new UniqueCustomersPerGeozoneDto(geoZone.getValue(), listOfCustomerIds);
            result.add(item);
        }
        return result;
    }
}
