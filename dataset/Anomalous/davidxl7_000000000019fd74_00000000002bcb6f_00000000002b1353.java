import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static int[][] pascalTriangle;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        pascalTriangle = new int[501][501];
        initializePascalTriangle();
        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": ");
            solve(scanner);
        }
    }

    private static void initializePascalTriangle() {
        for (int i = 1; i < 501; i++) {
            pascalTriangle[i][1] = 1;
            pascalTriangle[i][i] = 1;
        }
    }

    private static void solve(Scanner scanner) {
        int targetSum = scanner.nextInt();
        ArrayList<Point> path = new ArrayList<>();
        int currentSum = 1;
        int row = 1;
        int col = 0;
        path.add(new Point(1, 1));

        while (true) {
            row++;
            col++;
            currentSum += getPascalValue(row, col);
            if (currentSum >= targetSum) {
                currentSum -= getPascalValue(row, col);
                break;
            }
            path.add(new Point(row, col));
        }

        row--;
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

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}