import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numberOfSlices = scanner.nextInt();
            int desiredPieces = scanner.nextInt();
            double[] slices = new double[numberOfSlices];
            
            for (int i = 0; i < numberOfSlices; i++) {
                slices[i] = (double) scanner.nextLong();
            }
            
            processTestCase(testCase, slices, desiredPieces);
        }
    }
    
    private static void processTestCase(int testCase, double[] slices, int desiredPieces) {
        String result = "";
        int minimumCuts = Integer.MAX_VALUE;

        for (int tries = 1; tries < 6; tries++) {
            if (tries == 4) continue;

            for (double slice : slices) {
                int cutsNeeded = calculateCuts(slices, slice / tries, desiredPieces);
                if (cutsNeeded != -1 && cutsNeeded < minimumCuts) {
                    minimumCuts = cutsNeeded;
                }
            }
        }

        if (minimumCuts != Integer.MAX_VALUE) {
            result = String.valueOf(minimumCuts);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }
    
    private static int calculateCuts(double[] slices, double targetSize, int desiredPieces) {
        long[][] cuts = new long[slices.length][3];
        double[] efficiency = new double[slices.length];

        for (int i = 0; i < slices.length; i++) {
            cuts[i][0] = (long) slices[i];
            cuts[i][1] = 0;
            cuts[i][2] = 0;

            if (slices[i] < targetSize) {
                continue;
            }

            cuts[i][1] = (long) (slices[i] / targetSize);
            cuts[i][2] = (slices[i] % targetSize <= 1e-15) ? cuts[i][1] - 1 : cuts[i][1];
        }

        for (int i = 0; i < cuts.length; i++) {
            efficiency[i] = (cuts[i][1] == 0) ? -1 : (double) cuts[i][2] / cuts[i][1];
        }

        int totalCuts = 0;
        int totalPieces = 0;

        while (totalPieces < desiredPieces) {
            double minEfficiency = Double.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < efficiency.length; i++) {
                if (efficiency[i] != -1 && efficiency[i] < minEfficiency) {
                    minEfficiency = efficiency[i];
                    minIndex = i;
                }
            }

            if (minIndex == -1) return -1;

            efficiency[minIndex] = -1;

            if (totalPieces + cuts[minIndex][1] <= desiredPieces) {
                totalPieces += cuts[minIndex][1];
                totalCuts += cuts[minIndex][2];
            } else {
                totalCuts += (desiredPieces - totalPieces);
                totalPieces = desiredPieces;
            }
        }

        return totalCuts;
    }
}