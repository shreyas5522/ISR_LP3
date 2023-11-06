import java.util.*;

public class MetricsCalculator {
    public static double calculateF1(double precision, double recall) {
        if (precision + recall == 0) {
            return 0;
        }
        return 2 * (precision * recall) / (precision + recall);
    }

    public static double calculateEMeasure(double precision, double recall, double alpha) {
        if (precision == 0 && recall == 0) {
            return 0;
        }
        return 1 / ((alpha / precision) + ((1 - alpha) / recall));
    }

    public static void main(String[] args) {
        // Example values
        double precision = 0.75;
        double recall = 0.80;
        double alpha = 0.5;
        // Calculate F-measure
        double f1Score = calculateF1(precision, recall);
        System.out.println("F-measure (F1-score): " +
                String.format("%.2f", f1Score));
        // Calculate E-measure
        double eMeasure = calculateEMeasure(precision, recall, alpha);
        System.out.println("E-measure: " + String.format("%.2f",
                eMeasure));
    }
}