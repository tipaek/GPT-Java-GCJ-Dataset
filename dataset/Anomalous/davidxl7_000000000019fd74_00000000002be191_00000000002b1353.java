import java.io.*;
import java.util.*;

public class Solution {
    private static final int MAX = 501;
    private static int[][] pascalTriangle = new int[MAX][MAX];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        initializePascalTriangle();
        
        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ":");
            solve(scanner);
        }
    }

    private static void initializePascalTriangle() {
        for (int i = 1; i < MAX; i++) {
            pascalTriangle[i][1] = 1;
            pascalTriangle[i][i] = 1;
        }
    }

    private static void solve(Scanner scanner) {
        int targetSum = scanner.nextInt();
        List<Point> path = new ArrayList<>();
        int currentSum = 1;
        int row = 1;
        int col = 1;

        path.add(new Point(row, col));

        while (true) {
            row++;
            col++;
            currentSum += getPascalValue(row, col);

            if (currentSum > targetSum) {
                currentSum -= getPascalValue(row, col);
                break;
            }

            if (currentSum == targetSum) {
                path.add(new Point(row, col));
                break;
            }

            path.add(new Point(row, col));
        }

        row -= 2;
        col--;
        
        while (currentSum != targetSum) {
            row++;
            col++;
            currentSum++;
            path.add(new Point(row, col));
        }

        for (Point point : path) {
            System.out.println(point.row + " " + point.col);
        }
    }

    private static int getPascalValue(int row, int col) {
        if (pascalTriangle[row][col] != 0) {
            return pascalTriangle[row][col];
        }
        pascalTriangle[row][col] = getPascalValue(row - 1, col - 1) + getPascalValue(row - 1, col);
        return pascalTriangle[row][col];
    }

    private static class Point {
        int row, col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}