package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.example.calculator.AreaCalculator;
import org.example.exception.InvalidPolygonException;

@Getter
@AllArgsConstructor
@ToString

public class Polygon {

    private final int[][] points;
    private final AreaCalculator areaCalculator;

    public double getArea() throws InvalidPolygonException {
        return areaCalculator.calculateArea(points);
    }
}
