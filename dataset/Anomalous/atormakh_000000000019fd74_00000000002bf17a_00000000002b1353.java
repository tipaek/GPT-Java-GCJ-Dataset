import java.util.*;
import java.io.*;

public class Solution {
    static long[][] pascalTriangle;
    static final int TRIANGLE_SIZE = 50;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        pascalTriangle = generatePascalTriangle(TRIANGLE_SIZE);

        for (int i = 1; i <= testCases; ++i) {
            int targetSum = scanner.nextInt();
            List<String> results = findPath(targetSum);
            System.out.println("Case #" + i + ":");
            for (String result : results) {
                System.out.println(result);
            }
        }
    }

    public static List<String> findPath(int targetSum) {
        List<String> path = new ArrayList<>();
        int currentSum = 0, row = 0, col = 0;
        boolean leftToRight = true;

        while (calculateRowSum(row) + currentSum <= targetSum) {
            if (leftToRight) {
                col = 0;
                while (pascalTriangle[row][col] != 0) {
                    path.add((row + 1) + " " + (col + 1));
                    currentSum += pascalTriangle[row][col];
                    col++;
                }
            } else {
                col = row;
                while (col >= 0 && pascalTriangle[row][col] != 0) {
                    path.add((row + 1) + " " + (col + 1));
                    currentSum += pascalTriangle[row][col];
                    col--;
                }
            }
            leftToRight = !leftToRight;
            row++;
        }

        while (currentSum < targetSum) {
            path.add((row + 1) + " " + (col + 1));
            currentSum++;
            if (col != 0) {
                col++;
            }
            row++;
        }

        return path;
    }

    static int calculateRowSum(int row) {
        int sum = 0;
        for (int col = 0; col < TRIANGLE_SIZE; col++) {
            sum += pascalTriangle[row][col];
        }
        return sum;
    }

    public static long[][] generatePascalTriangle(int size) {
        long[][] triangle = new long[size][size];
        triangle[0][0] = 1;
        triangle[1][0] = 1;
        triangle[1][1] = 1;

        for (int row = 2; row < size; row++) {
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row) {
                    triangle[row][col] = 1;
                } else {
                    triangle[row][col] = triangle[row - 1][col - 1] + triangle[row - 1][col];
                }
            }
        }

        return triangle;
    }
}