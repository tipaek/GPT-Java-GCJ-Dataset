import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];

            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextInt();
                y[i] = scanner.nextInt();
            }

            double[][] slopes = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int run = x[j] - x[i];
                    int rise = y[j] - y[i];
                    slopes[i][j] = (run == 0) ? Double.MAX_VALUE : (double) rise / run;
                }
            }

            Map<Double, Integer> slopeCount = new HashMap<>();
            int maxCount = 0;
            Set<Double> maxSlopes = new HashSet<>();

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    double slope = slopes[i][j];
                    int count = slopeCount.getOrDefault(slope, 0) + 1;
                    slopeCount.put(slope, count);

                    if (count > maxCount) {
                        maxCount = count;
                        maxSlopes.clear();
                        maxSlopes.add(slope);
                    } else if (count == maxCount) {
                        maxSlopes.add(slope);
                    }
                }
            }

            Set<Integer> maxPoints = new HashSet<>();
            for (double maxSlope : maxSlopes) {
                Set<Integer> points = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (slopes[i][j] == maxSlope) {
                            points.add(i);
                            points.add(j);
                        }
                    }
                }
                if (points.size() > maxPoints.size()) {
                    maxPoints = points;
                }
            }

            int result = maxPoints.size() + 2;
            if (result % 2 == 1) {
                result--;
            }
            if (result > n) {
                result = n;
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}