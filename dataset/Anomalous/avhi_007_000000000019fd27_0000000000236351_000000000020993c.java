import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        try {
            int t = scanner.nextInt();
            for (int i = 1; i <= t; i++) {
                int trace = 0;
                int n = scanner.nextInt();
                int[][] matrix = new int[n][n];
                int expectedSum = 0;

                for (int num = 1; num <= n; num++) {
                    expectedSum += Math.pow(num, 3);
                }

                int rowCount = 0, colCount = 0;

                for (int row = 0; row < n; row++) {
                    int rowSum = 0;
                    for (int col = 0; col < n; col++) {
                        matrix[row][col] = scanner.nextInt();
                        rowSum += Math.pow(matrix[row][col], 3);
                        if (row == col) {
                            trace += matrix[row][col];
                        }
                    }
                    if (rowSum != expectedSum) {
                        rowCount++;
                    }
                }

                for (int col = 0; col < n; col++) {
                    int colSum = 0;
                    for (int row = 0; row < n; row++) {
                        colSum += Math.pow(matrix[row][col], 3);
                    }
                    if (colSum != expectedSum) {
                        colCount++;
                    }
                }

                System.out.println("Case #" + i + ": " + trace + " " + rowCount + " " + colCount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}