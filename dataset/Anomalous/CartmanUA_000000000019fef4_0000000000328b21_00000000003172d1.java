import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            double[] slices = new double[n];
            
            for (int i = 0; i < n; i++) {
                slices[i] = (double) scanner.nextLong();
            }
            
            processTestCase(testCase, slices, d);
        }
    }
    
    private static void processTestCase(int testCase, double[] slices, int d) {
        String result = "";
        int minCuts = -1;
        
        for (int tries = 1; tries < 7; tries++) {
            for (double slice : slices) {
                int cuts = calculateCutsNeeded(slices, slice / tries, d);
                if (cuts != -1 && (minCuts == -1 || cuts < minCuts)) {
                    minCuts = cuts;
                }
            }
        }
        
        if (minCuts != -1) {
            result = String.valueOf(minCuts);
        } else {
            result = String.valueOf(d - 1);
        }
        
        System.out.println("Case #" + testCase + ": " + result);
    }
    
    private static int calculateCutsNeeded(double[] slices, double size, int d) {
        long[][] cutsInfo = new long[slices.length][3];
        double[] efficiency = new double[slices.length];
        
        for (int i = 0; i < slices.length; i++) {
            cutsInfo[i][0] = (long) slices[i];
            cutsInfo[i][1] = (slices[i] >= size) ? (long) (slices[i] / size) : 0;
            cutsInfo[i][2] = (slices[i] % size <= 1e-15) ? cutsInfo[i][1] - 1 : cutsInfo[i][1];
        }
        
        for (int i = 0; i < cutsInfo.length; i++) {
            efficiency[i] = (cutsInfo[i][1] == 0) ? -1 : (double) cutsInfo[i][2] / cutsInfo[i][1];
        }
        
        int totalCuts = 0;
        int totalPieces = 0;
        
        while (totalPieces < d) {
            double minEfficiency = -1.0;
            int minIndex = -1;
            
            for (int i = 0; i < efficiency.length; i++) {
                if (efficiency[i] != -1.0 && (minEfficiency == -1.0 || efficiency[i] < minEfficiency)) {
                    minEfficiency = efficiency[i];
                    minIndex = i;
                }
            }
            
            if (minIndex == -1) return -1;
            
            efficiency[minIndex] = -1.0;
            if (totalPieces + cutsInfo[minIndex][1] <= d) {
                totalPieces += cutsInfo[minIndex][1];
                totalCuts += cutsInfo[minIndex][2];
            } else {
                totalCuts += (d - totalPieces);
                totalPieces = d;
            }
        }
        
        return totalCuts;
    }
}