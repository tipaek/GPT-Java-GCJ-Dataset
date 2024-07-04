import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int test = 1; test <= testCases; test++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            double[] slices = new double[n];

            for (int i = 0; i < n; i++) {
                slices[i] = scanner.nextDouble();
            }

            processTestCase(test, slices, d);
        }
    }

    private static void processTestCase(int test, double[] slices, int d) {
        int minCuts = Integer.MAX_VALUE;

        for (int tries = 1; tries < 6; tries++) {
            for (double slice : slices) {
                int cuts = calculateCutsNeeded(slices, slice / tries, d);
                if (cuts != -1 && cuts < minCuts) {
                    minCuts = cuts;
                }
            }
        }

        if (minCuts != Integer.MAX_VALUE) {
            System.out.println("Case #" + test + ": " + minCuts);
        }
    }

    private static int calculateCutsNeeded(double[] slices, double targetSize, int d) {
        long[][] sliceData = new long[slices.length][3];
        double[] efficiencies = new double[slices.length];

        for (int i = 0; i < slices.length; i++) {
            sliceData[i][0] = (long) slices[i];
            sliceData[i][1] = (long) (slices[i] / targetSize);

            if (slices[i] % targetSize <= 1e-12) {
                sliceData[i][2] = sliceData[i][1] - 1;
            } else {
                sliceData[i][2] = sliceData[i][1];
            }

            efficiencies[i] = sliceData[i][1] == 0 ? -1 : (double) sliceData[i][2] / sliceData[i][1];
        }

        int totalCuts = 0;
        int totalPieces = 0;

        while (totalPieces < d) {
            double minEfficiency = Double.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < efficiencies.length; i++) {
                if (efficiencies[i] != -1 && efficiencies[i] < minEfficiency) {
                    minEfficiency = efficiencies[i];
                    minIndex = i;
                }
            }

            if (minIndex == -1) {
                return -1;
            }

            efficiencies[minIndex] = -1;

            if (totalPieces + sliceData[minIndex][1] <= d) {
                totalPieces += sliceData[minIndex][1];
                totalCuts += sliceData[minIndex][2];
            } else {
                totalCuts += (d - totalPieces);
                totalPieces = d;
            }
        }

        return totalCuts;
    }
}