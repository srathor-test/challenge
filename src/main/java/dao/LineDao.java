package dao;

import dto.Line;
import dto.query.AverageBuildDurationForEachGeoZoneDto;
import dto.query.CountUniqueCustomerPerContractDto;
import dto.query.CountUniqueCustomerPerGeozoneDto;
import dto.query.UniqueCustomersPerGeozoneDto;
import exception.LineException;

import java.util.List;

public interface LineDao {

    List<Line> getLines();
    void addLine(String line) throws LineException;


}
