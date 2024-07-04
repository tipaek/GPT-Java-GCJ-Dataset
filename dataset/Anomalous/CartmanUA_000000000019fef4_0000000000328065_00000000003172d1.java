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
                slices[i] = scanner.nextLong();
            }

            findMinimumCuts(testCase, slices, d);
        }
    }

    private static void findMinimumCuts(int testCase, double[] slices, int d) {
        int minCuts = Integer.MAX_VALUE;

        for (int tries = 1; tries < 10; tries++) {
            if (tries == 4) continue;

            for (double slice : slices) {
                int cuts = calculateCuts(slices, slice / tries, d);
                if (cuts != -1 && cuts < minCuts) {
                    minCuts = cuts;
                }
            }
        }

        if (minCuts != Integer.MAX_VALUE) {
            System.out.println("Case #" + testCase + ": " + minCuts);
        }
    }

    private static int calculateCuts(double[] slices, double size, int d) {
        int n = slices.length;
        long[][] cuts = new long[n][3];
        double[] efficiency = new double[n];

        for (int i = 0; i < n; i++) {
            cuts[i][0] = (long) slices[i];
            cuts[i][1] = 0;
            cuts[i][2] = 0;

            if (slices[i] >= size) {
                cuts[i][1] = (long) (slices[i] / size);
                cuts[i][2] = (slices[i] % size <= 1e-15) ? cuts[i][1] - 1 : cuts[i][1];
            }

            efficiency[i] = (cuts[i][1] == 0) ? -1 : (double) cuts[i][2] / cuts[i][1];
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