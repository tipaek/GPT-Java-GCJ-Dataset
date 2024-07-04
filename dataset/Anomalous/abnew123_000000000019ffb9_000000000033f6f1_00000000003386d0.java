import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numberOfPoints = scanner.nextInt();
            int[] xCoordinates = new int[numberOfPoints];
            int[] yCoordinates = new int[numberOfPoints];

            for (int i = 0; i < numberOfPoints; i++) {
                xCoordinates[i] = scanner.nextInt();
                yCoordinates[i] = scanner.nextInt();
            }

            int result = calculateResult(numberOfPoints, xCoordinates, yCoordinates);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static int calculateResult(int n, int[] xs, int[] ys) {
        if (n <= 4) {
            return n;
        }

        if (n == 5 || n == 6) {
            return calculateForFiveOrSixPoints(n, xs, ys);
        }

        return calculateForMoreThanSixPoints(n, xs, ys);
    }

    private static int calculateForFiveOrSixPoints(int n, int[] xs, int[] ys) {
        int result = 4;
        for (int i = 0; i < xs.length - 1; i++) {
            for (int j = i + 1; j < xs.length; j++) {
                int xDelta = xs[i] - xs[j];
                int yDelta = ys[i] - ys[j];
                for (int k = 0; k < xs.length; k++) {
                    if (k != i && k != j) {
                        if (isCollinear(xs, ys, i, j, k, xDelta, yDelta)) {
                            return n;
                        }
                    }
                }
            }
        }
        return result;
    }

    private static int calculateForMoreThanSixPoints(int n, int[] xs, int[] ys) {
        int result = 4;
        List<List<Integer>> collinearPoints = new ArrayList<>();

        for (int i = 0; i < xs.length - 1; i++) {
            for (int j = i + 1; j < xs.length; j++) {
                int xDelta = xs[i] - xs[j];
                int yDelta = ys[i] - ys[j];
                for (int k = 0; k < xs.length; k++) {
                    if (k != i && k != j) {
                        if (isCollinear(xs, ys, i, j, k, xDelta, yDelta)) {
                            collinearPoints.add(Arrays.asList(i, j, k));
                        }
                    }
                }
            }
        }

        if (!collinearPoints.isEmpty()) {
            result = 6;
        }

        for (int i = 0; i < collinearPoints.size() - 1; i++) {
            for (int j = i + 1; j < collinearPoints.size(); j++) {
                List<Integer> line1 = collinearPoints.get(i);
                List<Integer> line2 = collinearPoints.get(j);
                if (Collections.disjoint(line1, line2)) {
                    return n;
                }
            }
        }

        return result;
    }

    private static boolean isCollinear(int[] xs, int[] ys, int i, int j, int k, int xDelta, int yDelta) {
        int x1 = xs[i];
        int x2 = xs[j];
        int x3 = xs[k] + xDelta;
        int y1 = ys[i];
        int y2 = ys[j];
        int y3 = ys[k] + yDelta;
        int x4 = xs[k] - xDelta;
        int y4 = ys[k] - yDelta;

        return ((x3 - x1) * (y3 - y2) - (x3 - x2) * (y3 - y1)) == 0 ||
               ((x4 - x1) * (y4 - y2) - (x4 - x2) * (y4 - y1)) == 0;
    }
}