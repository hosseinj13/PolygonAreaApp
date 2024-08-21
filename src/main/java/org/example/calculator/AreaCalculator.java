package org.example.calculator;


import org.example.exception.InvalidPolygonException;

public interface AreaCalculator {
    double calculateArea(int[][] points) throws InvalidPolygonException;
}
