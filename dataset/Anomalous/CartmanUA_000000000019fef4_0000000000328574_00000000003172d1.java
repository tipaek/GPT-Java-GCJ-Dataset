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

            processTestCase(testCase, slices, d);
        }
    }

    private static void processTestCase(int testCase, double[] slices, int d) {
        String result = "";
        int minCuts = Integer.MAX_VALUE;

        for (int tries = 1; tries < 20; tries++) {
            for (double slice : slices) {
                int cuts = calculateCutsNeeded(slice / tries, slices, d);
                if (cuts != -1 && cuts < minCuts) {
                    minCuts = cuts;
                }
            }
        }

        if (minCuts != Integer.MAX_VALUE) {
            result = String.valueOf(minCuts);
            System.out.printf("Case #%d: %s%n", testCase, result);
        }
    }

    private static int calculateCutsNeeded(double targetSize, double[] slices, int d) {
        int totalCuts = 0;
        int totalPieces = 0;

        for (double slice : slices) {
            if (slice < targetSize) continue;

            long pieces = (long) (slice / targetSize);
            long cuts = (slice % targetSize <= 0.000000000000001) ? pieces - 1 : pieces;

            if (totalPieces + pieces <= d) {
                totalPieces += pieces;
                totalCuts += cuts;
            } else {
                totalCuts += (d - totalPieces);
                totalPieces = d;
            }

            if (totalPieces >= d) break;
        }

        return (totalPieces >= d) ? totalCuts : -1;
    }
}