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
        int minCuts = -1;

        for (int tries = 1; tries < 6; tries++) {
            for (double slice : slices) {
                int cuts = calculateCuts(slices, slice / tries, d);
                if (cuts != -1 && (minCuts == -1 || cuts < minCuts)) {
                    minCuts = cuts;
                }
            }
        }

        if (minCuts != -1) {
            System.out.println("Case #" + testCase + ": " + minCuts);
        } else {
            System.out.println("Case #" + testCase + ": " + (d - 1));
        }
    }

    private static int calculateCuts(double[] slices, double size, int d) {
        long[][] cuts = new long[slices.length][3];
        double[] efficiency = new double[slices.length];

        for (int i = 0; i < slices.length; i++) {
            cuts[i][0] = (long) slices[i];
            cuts[i][1] = slices[i] >= size ? (long) (slices[i] / size) : 0;
            cuts[i][2] = slices[i] % size <= 1e-15 ? cuts[i][1] - 1 : cuts[i][1];
        }

        for (int i = 0; i < slices.length; i++) {
            efficiency[i] = cuts[i][1] == 0 ? -1 : (double) cuts[i][2] / cuts[i][1];
        }

        int totalCuts = 0;
        int totalPieces = 0;

        while (totalPieces < d) {
            double minEfficiency = -1;
            int minIndex = -1;

            for (int i = 0; i < efficiency.length; i++) {
                if (efficiency[i] != -1 && (efficiency[i] < minEfficiency || minEfficiency == -1)) {
                    minEfficiency = efficiency[i];
                    minIndex = i;
                }
            }

            if (minIndex == -1) return -1;

            efficiency[minIndex] = -1;
            if (totalPieces + cuts[minIndex][1] <= d) {
                totalPieces += cuts[minIndex][1];
                totalCuts += cuts[minIndex][2];
            } else {
                totalCuts += (d - totalPieces);
                totalPieces = d;
            }
        }

        return totalCuts;
    }
}