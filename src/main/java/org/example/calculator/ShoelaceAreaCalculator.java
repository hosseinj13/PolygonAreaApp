package org.example.calculator;



import lombok.AllArgsConstructor;
import org.example.exception.InvalidPolygonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class ShoelaceAreaCalculator implements AreaCalculator {

    private static final Logger logger = LoggerFactory.getLogger(ShoelaceAreaCalculator.class);

    @Override
    public double calculateArea(int[][] points) throws InvalidPolygonException {
        validatePolygon(points);

        int n = points.length;
        double area = 0;

        area += calculateForwardSummation(points, n);
        area -= calculateBackwardSummation(points, n);

        double result = Math.abs(area) / 2.0;

        logger.info("Calculated area: {}", result);
        return result;
    }

    private void validatePolygon(int[][] points) throws InvalidPolygonException {
        if (points == null || points.length < 3) {
            logger.error("Invalid polygon: must have at least 3 points.");
            throw new InvalidPolygonException("A polygon must have at least 3 points.");
        }
    }

    private double calculateForwardSummation(int[][] points, int n) {
        double sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += points[i][0] * points[i + 1][1];
        }
        sum += points[n - 1][0] * points[0][1];
        logger.debug("Forward summation result: {}", sum);
        return sum;
    }

    private double calculateBackwardSummation(int[][] points, int n) {
        double sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += points[i][1] * points[i + 1][0];
        }
        sum += points[n - 1][1] * points[0][0];
        logger.debug("Backward summation result: {}", sum);
        return sum;
    }
}
