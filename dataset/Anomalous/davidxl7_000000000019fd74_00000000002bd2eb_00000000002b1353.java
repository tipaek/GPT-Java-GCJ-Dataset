import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static int[][] pascalTriangle;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        pascalTriangle = new int[501][501];

        // Initialize Pascal's Triangle
        for (int i = 1; i < 501; i++) {
            pascalTriangle[i][1] = 1;
            pascalTriangle[i][i] = 1;
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": ");
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner) {
        int targetSum = scanner.nextInt();
        ArrayList<Point> path = new ArrayList<>();
        int currentSum = 1;
        int row = 1;
        int column = 1;
        path.add(new Point(1, 1));

        while (true) {
            row++;
            column++;
            currentSum += getPascalValue(row, column);
            if (currentSum >= targetSum) {
                currentSum -= getPascalValue(row, column);
                break;
            }
            path.add(new Point(row, column));
        }

        row -= 2;
        column--;

        while (currentSum != targetSum) {
            row++;
            column++;
            currentSum++;
            path.add(new Point(row, column));
        }

        for (Point point : path) {
            System.out.println(point.row + " " + point.column);
        }
    }

    public static int getPascalValue(int row, int column) {
        if (pascalTriangle[row][column] != 0) {
            return pascalTriangle[row][column];
        }
        pascalTriangle[row][column] = getPascalValue(row - 1, column - 1) + getPascalValue(row - 1, column);
        return pascalTriangle[row][column];
    }

    static class Point {
        int row, column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}