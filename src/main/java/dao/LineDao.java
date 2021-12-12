package dao;

import dto.Line;
import exception.LineException;

import java.util.List;

public interface LineDao {

    List<Line> getLines();
    void addLine(String line) throws LineException;


}
