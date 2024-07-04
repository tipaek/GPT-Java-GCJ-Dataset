import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        long[][] fibonacci = new long[41][41];
        computeFibonacci(fibonacci);
        long[][] minRequirements = new long[41][41];
        computeMinRequirements(fibonacci, minRequirements);

        for (int t = 1; t <= testCases; t++) {
            System.out.println("Case #" + t + ":");
            long targetSum = Long.parseLong(reader.readLine());
            LinkedList<Point> path = findPath(fibonacci, minRequirements, targetSum);
            printPath(path);
        }
    }

    private static void computeFibonacci(long[][] fibonacci) {
        for (int line = 0; line < 41; line++) {
            for (int i = 0; i <= line; i++) {
                if (line == i || i == 0) {
                    fibonacci[line][i] = 1;
                } else {
                    fibonacci[line][i] = fibonacci[line - 1][i - 1] + fibonacci[line - 1][i];
                }
            }
        }
    }

    private static void computeMinRequirements(long[][] fibonacci, long[][] minRequirements) {
        for (int i = 0; i < 41; i++) {
            minRequirements[i][0] = i + 1;
        }
        for (int i = 1; i < 41; i++) {
            for (int j = 1; j < 41; j++) {
                minRequirements[i][j] = minRequirements[i - 1][j - 1] + fibonacci[i][j];
            }
        }
    }

    private static LinkedList<Point> findPath(long[][] fibonacci, long[][] minRequirements, long targetSum) {
        LinkedList<Point> path = new LinkedList<>();
        int currentRow = 40;
        int currentCol = 20;
        
        while (minRequirements[currentRow][currentCol] > targetSum) {
            currentRow--;
            currentCol = currentRow / 2;
        }
        
        long sum = 0;
        boolean moveRight = false;
        
        while (currentCol >= 0 && currentRow >= 0) {
            sum += fibonacci[currentRow][currentCol];
            if (currentRow == currentCol && currentRow != 0) {
                moveRight = true;
            }
            if (currentRow == currentCol || sum + minRequirements[currentRow - 1][currentCol] > targetSum) {
                path.addFirst(new Point(currentRow, currentCol));
                currentCol--;
                currentRow--;
                continue;
            }
            path.addFirst(new Point(currentRow, currentCol));
            currentRow--;
        }
        
        if (targetSum != sum) {
            path.add((int) (targetSum - sum), moveRight ? new Point((int) (targetSum - sum), (int) (targetSum - sum - 1)) : new Point((int) (targetSum - sum), 1));
        }
        
        return path;
    }

    private static void printPath(LinkedList<Point> path) {
        while (!path.isEmpty()) {
            Point point = path.poll();
            System.out.println((point.row + 1) + " " + (point.col + 1));
        }
    }

    static class Point {
        int row, col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}