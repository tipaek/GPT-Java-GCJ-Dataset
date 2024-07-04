import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numPoints = scanner.nextInt();
            
            int[] xCoordinates = new int[numPoints];
            int[] yCoordinates = new int[numPoints];
            
            for (int i = 0; i < numPoints; i++) {
                xCoordinates[i] = scanner.nextInt();
                yCoordinates[i] = scanner.nextInt();
            }
            
            double[][] slopes = new double[numPoints][numPoints];
            
            for (int i = 0; i < numPoints; i++) {
                for (int j = i + 1; j < numPoints; j++) {
                    int deltaX = xCoordinates[j] - xCoordinates[i];
                    int deltaY = yCoordinates[j] - yCoordinates[i];
                    slopes[i][j] = (deltaX == 0) ? Double.POSITIVE_INFINITY : (double) deltaY / deltaX;
                }
            }
            
            Map<Double, Integer> slopeCount = new HashMap<>();
            int maxCount = 0;
            double maxSlope = 0.0;
            
            for (int i = 0; i < numPoints; i++) {
                for (int j = i + 1; j < numPoints; j++) {
                    double currentSlope = slopes[i][j];
                    int count = slopeCount.getOrDefault(currentSlope, 0) + 1;
                    slopeCount.put(currentSlope, count);
                    
                    if (count > maxCount) {
                        maxCount = count;
                        maxSlope = currentSlope;
                    }
                }
            }
            
            Set<Integer> uniquePoints = new HashSet<>();
            for (int i = 0; i < numPoints; i++) {
                for (int j = i + 1; j < numPoints; j++) {
                    if (slopes[i][j] == maxSlope) {
                        uniquePoints.add(i);
                        uniquePoints.add(j);
                    }
                }
            }
            
            int result = uniquePoints.size() + 2;
            if (result > numPoints) {
                result = numPoints;
            }
            
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}