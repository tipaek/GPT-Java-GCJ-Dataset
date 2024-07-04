import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());
        long[][] binomialCoefficients = new long[41][41];
        calculateBinomialCoefficients(binomialCoefficients);
        long[][] minRequirements = calculateMinRequirements(binomialCoefficients);

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            System.out.print("Case #" + testCase + ":");
            long targetSum = Long.parseLong(reader.readLine());
            LinkedList<Point> path = findPath(binomialCoefficients, minRequirements, targetSum);
            printPath(path);
        }
    }

    private static void calculateBinomialCoefficients(long[][] binomialCoefficients) {
        for (int line = 0; line < binomialCoefficients.length; line++) {
            for (int i = 0; i <= line; i++) {
                if (line == i || i == 0) {
                    binomialCoefficients[line][i] = 1;
                } else {
                    binomialCoefficients[line][i] = binomialCoefficients[line - 1][i - 1] + binomialCoefficients[line - 1][i];
                }
            }
        }
    }

    private static long[][] calculateMinRequirements(long[][] binomialCoefficients) {
        long[][] minRequirements = new long[41][41];
        for (int a = 0; a < minRequirements.length; a++) {
            minRequirements[a][0] = a + 1;
        }
        for (int a = 1; a < minRequirements.length; a++) {
            for (int b = 1; b < minRequirements[a].length; b++) {
                minRequirements[a][b] = minRequirements[a - 1][b - 1] + binomialCoefficients[a][b];
            }
        }
        return minRequirements;
    }

    private static LinkedList<Point> findPath(long[][] binomialCoefficients, long[][] minRequirements, long targetSum) {
        LinkedList<Point> path = new LinkedList<>();
        int currentRow = 40;
        int currentColumn = 20;
        while (minRequirements[currentRow][currentColumn] > targetSum) {
            currentRow--;
            currentColumn = currentRow / 2;
        }
        long sum = 0;
        boolean isRight = false;
        while (currentColumn >= 0 && currentRow >= 0) {
            sum += binomialCoefficients[currentRow][currentColumn];
            if (currentRow == currentColumn && currentRow != 0) {
                isRight = true;
            }
            if (currentRow == currentColumn || sum + minRequirements[currentRow - 1][currentColumn] > targetSum) {
                path.addFirst(new Point(currentRow, currentColumn));
                currentColumn--;
                currentRow--;
            } else {
                path.addFirst(new Point(currentRow, currentColumn));
                currentRow--;
            }
        }
        if (targetSum != sum) {
            path.add((int) (targetSum - sum), isRight ? new Point((int) (targetSum - sum), (int) (targetSum - sum - 1)) : new Point((int) (targetSum - sum), 1));
        }
        return path;
    }

    private static void printPath(LinkedList<Point> path) {
        while (!path.isEmpty()) {
            Point point = path.poll();
            System.out.println((point.row + 1) + " " + (point.column + 1));
        }
    }

    static class Point {
        int row, column;

        Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}