package org.example.app;


import org.example.calculator.ShoelaceAreaCalculator;
import org.example.exception.InvalidPolygonException;
import org.example.model.Polygon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PolygonAreaApp {
    private static final Logger logger = LoggerFactory.getLogger(PolygonAreaApp.class);

    public static void main(String[] args) {
        try {
            int[][] points = {{0, 0}, {4, 0}, {4, 3}, {0, 4}};

            Polygon polygon = new Polygon(points, new ShoelaceAreaCalculator());

            double area = polygon.getArea();
            logger.info("Area of the polygon: {}", area);
        } catch (InvalidPolygonException e) {
            logger.error("Error calculating area: {}", e.getMessage());
        } catch (Exception e) {
            logger.error("An unexpected error occurred: {}", e.getMessage());
        }
    }
}
