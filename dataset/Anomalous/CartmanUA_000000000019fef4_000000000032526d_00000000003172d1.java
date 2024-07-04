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
                slices[i] = scanner.nextLong();
            }

            processTestCase(test, slices, d);
        }
    }

    private static void processTestCase(int test, double[] slices, int d) {
        String result = "";
        int minimumCuts = Integer.MAX_VALUE;

        for (double slice : slices) {
            int cuts = calculateCuts(slices, slice, d);
            if (cuts != -1 && cuts < minimumCuts) {
                minimumCuts = cuts;
            }
            if (minimumCuts == 0) break;
        }

        if (minimumCuts != Integer.MAX_VALUE) {
            result = String.valueOf(minimumCuts);
            System.out.println("Case #" + test + ": " + result);
            return;
        }

        for (int tries = 2; ; tries++) {
            for (double slice : slices) {
                int cuts = calculateCuts(slices, slice / tries, d);
                if (cuts != -1 && cuts < minimumCuts) {
                    minimumCuts = cuts;
                }
                if (minimumCuts == 0) break;
            }
            if (minimumCuts != Integer.MAX_VALUE) {
                result = String.valueOf(minimumCuts);
                System.out.println("Case #" + test + ": " + result);
                return;
            }
        }
    }

    private static int calculateCuts(double[] slices, double size, int d) {
        int n = slices.length;
        long[][] cuts = new long[n][3];
        double[] efficiency = new double[n];

        for (int i = 0; i < n; i++) {
            cuts[i][0] = (long) slices[i];
            if (slices[i] < size) continue;

            cuts[i][1] = (long) (slices[i] / size);
            cuts[i][2] = (slices[i] % size <= 0.000001) ? cuts[i][1] - 1 : cuts[i][1];
        }

        for (int i = 0; i < n; i++) {
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