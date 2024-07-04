import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        
        for (int test = 1; test <= testCases; test++) {
            int n = in.nextInt();
            int d = in.nextInt();
            double[] slices = new double[n];
            
            for (int i = 0; i < n; i++) {
                slices[i] = in.nextLong();
            }
            
            printResult(test, slices, d);
        }
    }
    
    private static void printResult(int test, double[] slices, int d) {
        int minCuts = Integer.MAX_VALUE;
        
        for (int tries = 1; tries < 10; tries++) {
            for (double slice : slices) {
                int cuts = calculateCuts(slices, slice / tries, d);
                
                if (cuts != -1 && cuts < minCuts) {
                    minCuts = cuts;
                }
            }
        }
        
        if (minCuts != Integer.MAX_VALUE) {
            System.out.println("Case #" + test + ": " + minCuts);
        } else {
            System.out.println("Case #" + test + ": " + (d - 1));
        }
    }
    
    private static int calculateCuts(double[] slices, double size, int d) {
        long[][] cuts = new long[slices.length][3];
        double[] efficiency = new double[slices.length];
        
        for (int i = 0; i < slices.length; i++) {
            cuts[i][0] = (long) slices[i];
            if (slices[i] >= size) {
                cuts[i][1] = (long) (slices[i] / size);
                cuts[i][2] = (slices[i] % size <= 1e-15) ? cuts[i][1] - 1 : cuts[i][1];
            }
        }
        
        for (int i = 0; i < slices.length; i++) {
            efficiency[i] = (cuts[i][1] == 0) ? -1 : (double) cuts[i][2] / cuts[i][1];
        }
        
        int totalCuts = 0;
        int pieces = 0;
        
        while (pieces < d) {
            double minEfficiency = Double.MAX_VALUE;
            int minIndex = -1;
            
            for (int i = 0; i < efficiency.length; i++) {
                if (efficiency[i] != -1 && efficiency[i] < minEfficiency) {
                    minEfficiency = efficiency[i];
                    minIndex = i;
                }
            }
            
            if (minIndex == -1) {
                return -1;
            }
            
            efficiency[minIndex] = -1;
            if (pieces + cuts[minIndex][1] <= d) {
                pieces += cuts[minIndex][1];
                totalCuts += cuts[minIndex][2];
            } else {
                totalCuts += (d - pieces);
                pieces = d;
            }
        }
        
        return totalCuts;
    }
}