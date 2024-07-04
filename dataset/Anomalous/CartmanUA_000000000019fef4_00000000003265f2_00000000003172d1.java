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
                slices[i] = scanner.nextLong();
            }

            printResult(test, slices, d);
        }
    }

    private static void printResult(int test, double[] slices, int d) {
        String result = "";
        int minCuts = Integer.MAX_VALUE;

        for (int i = 0; i < slices.length; i++) {
            int cuts = calculateCuts(slices, slices[i], d);
            if (cuts != -1 && cuts < minCuts) {
                minCuts = cuts;
            }
        }

        if (minCuts != Integer.MAX_VALUE) {
            result = String.valueOf(minCuts);
            System.out.println("Case #" + test + ": " + result);
            return;
        }

        for (int tries = 2; tries < 40; tries++) {
            for (int i = 0; i < slices.length; i++) {
                int cuts = calculateCuts(slices, slices[i] / tries, d);
                if (cuts != -1 && cuts < minCuts) {
                    minCuts = cuts;
                }
            }
        }

        if (minCuts != Integer.MAX_VALUE) {
            result = String.valueOf(minCuts);
            System.out.println("Case #" + test + ": " + result);
        }
    }

    private static int calculateCuts(double[] slices, double size, int d) {
        long[][] cuts = new long[slices.length][3];
        double[] efficiency = new double[slices.length];

        for (int i = 0; i < slices.length; i++) {
            cuts[i][0] = (long) slices[i];
            cuts[i][1] = 0;
            cuts[i][2] = 0;

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

            if (minIndex == -1) return -1;

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