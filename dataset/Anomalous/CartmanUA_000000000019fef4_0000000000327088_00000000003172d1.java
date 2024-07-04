import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();
        
        for (int test = 1; test <= numberOfTests; test++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            double[] slices = new double[n];
            
            for (int i = 0; i < n; i++) {
                slices[i] = (double) scanner.nextLong();
            }
            
            findMinimumCuts(test, slices, d);
        }
    }
    
    private static void findMinimumCuts(int test, double[] slices, int d) {
        String result;
        int minCuts = Integer.MAX_VALUE;
        
        for (int tries = 1; tries < 40; tries++) {
            for (double slice : slices) {
                int cuts = calculateCuts(slices, slice / tries, d);
                if (cuts != -1) {
                    minCuts = Math.min(minCuts, cuts);
                }
            }
        }
        
        if (minCuts != Integer.MAX_VALUE) {
            result = String.valueOf(minCuts);
            System.out.println("Case #" + test + ": " + result);
        }
    }
    
    private static int calculateCuts(double[] slices, double size, int d) {
        int n = slices.length;
        long[][] cutsData = new long[n][3];
        double[] efficiency = new double[n];
        
        for (int i = 0; i < n; i++) {
            cutsData[i][0] = (long) slices[i];
            cutsData[i][1] = 0;
            cutsData[i][2] = 0;
            
            if (slices[i] < size) {
                continue;
            }
            
            cutsData[i][1] = (long) (slices[i] / size);
            if (slices[i] % size <= 1e-15) {
                cutsData[i][2] = cutsData[i][1] - 1;
            } else {
                cutsData[i][2] = cutsData[i][1];
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (cutsData[i][1] == 0) {
                efficiency[i] = -1;
            } else {
                efficiency[i] = (double) cutsData[i][2] / cutsData[i][1];
            }
        }
        
        int totalCuts = 0;
        int totalPieces = 0;
        
        while (totalPieces < d) {
            double minEfficiency = Double.MAX_VALUE;
            int minIndex = -1;
            
            for (int i = 0; i < n; i++) {
                if (efficiency[i] != -1 && efficiency[i] < minEfficiency) {
                    minEfficiency = efficiency[i];
                    minIndex = i;
                }
            }
            
            if (minIndex == -1) {
                return -1;
            }
            
            efficiency[minIndex] = -1;
            if (totalPieces + cutsData[minIndex][1] <= d) {
                totalPieces += cutsData[minIndex][1];
                totalCuts += cutsData[minIndex][2];
            } else {
                totalCuts += (d - totalPieces);
                totalPieces = d;
            }
        }
        
        return totalCuts;
    }
}