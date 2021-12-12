package dao;

import dto.query.AverageBuildDurationForEachGeoZoneDto;
import dto.query.CountUniqueCustomerPerContractDto;
import dto.query.CountUniqueCustomerPerGeozoneDto;
import dto.query.UniqueCustomersPerGeozoneDto;

import java.util.List;

public interface LineQueryDao {
    List<CountUniqueCustomerPerContractDto> getUniqueCountCustomerPerContract();
    List<CountUniqueCustomerPerGeozoneDto> getUniqueCountCustomerPerGeozone();
    List<AverageBuildDurationForEachGeoZoneDto> getAverageBuildDurationForEachGeoZone();
    List<UniqueCustomersPerGeozoneDto> getUniqueCustomersPerGeozoneDto();
}
