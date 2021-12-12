package dao;

import dto.Line;
import dto.field.*;
import dto.field.validation.LineValidationVisitor;
import exception.LineException;

import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class LineDaoImpl implements LineDao {

    public static final Logger LOGGER = Logger.getLogger(LineDaoImpl.class.getClass().getName());
    public static final String LINE_SEPARATORS = "\\r?\\n";

    private List<Line> lines;
    private LineValidationVisitor fieldValidator;

    public LineDaoImpl(List<Line> lines, LineValidationVisitor fieldValidator) {
        this.lines = lines;
        this.fieldValidator = fieldValidator;
    }

    @Override
    public List<Line> getLines() {
        return this.lines;
    }

    @Override
    public void addLine(String line) throws LineException {
        if(lines == null) {
            throw new LineException("lines are not initialized");
        }
        if(line == null || line.isBlank()) {
            throw new LineException("Invalid Line: empty/blank line");
        }
        populateRecords(line);
    }



    private void populateRecords(String line) throws LineException {
        String[] lineItems = line.split(LINE_SEPARATORS);
        for(String lineItem: lineItems) {
            List <String> fields = getTokensAsList(lineItem);
            if(fields == null || fields.isEmpty()) {
                throw new LineException("Invalid Line: found record with no fields");
            }
            if(fields.size() < 6 || fields.size() > 6) {
                throw new LineException("Invalid Line: no of columns found in record is not equal to expected " +
                        "number(6) of columns");
            }

            CustomerId customerId = CustomerId.Builder.newInstance(fieldValidator).value(fields.get(0)).build();
            ContractId contractId = ContractId.Builder.newInstance(fieldValidator).value(fields.get(1)).build();
            GeoZone geozone = GeoZone.Builder.newInstance(fieldValidator).value(fields.get(2)).build();
            TeamCode teamcode = TeamCode.Builder.newInstance(fieldValidator).value(fields.get(3)).build();
            ProjectCode projectcode = ProjectCode.Builder.newInstance(fieldValidator).value(fields.get(4)).build();
            BuildDuration buildduration = BuildDuration.Builder.newInstance(fieldValidator).value(fields.get(5)).build();

            Line lineRecord = Line.Builder.newInstance()
                    .customerId(customerId)
                    .contractId(contractId)
                    .geozone(geozone)
                    .teamcode(teamcode)
                    .projectcode(projectcode)
                    .buildduration(buildduration)
                    .build();

            lines.add(lineRecord);
        }
    }

    private List<String> getTokensAsList(String str) {
        return Collections.list(new StringTokenizer(str, ",")).stream()
                .map(token -> (String) token)
                .collect(Collectors.toList());
    }
}
