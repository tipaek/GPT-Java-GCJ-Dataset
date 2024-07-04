import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();

            for (int i = 1; i <= t; ++i) {
                int n = in.nextInt();
                int k = in.nextInt();

                int[][] matrix = new int[n][n];
                int trace = 0;

                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n; y++) {
                        matrix[x][y]++;

                        if (x == y) {
                            trace = calculateTrace(matrix, n);
                        }

                        if (matrix[x][y] > n || !isPlacementValid(matrix, x, y, n) || !(x != y || (x != n - 1 && trace < k) || (x == n - 1 && trace == k))) {
                            if (matrix[x][y] >= n) {
                                matrix[x][y] = 0;
                                if (y - 2 < -1) {
                                    y = n - 2;
                                    x--;
                                } else {
                                    y -= 2;
                                }
                            } else {
                                y--;
                            }
                        }
                    }
                }

                for (int x = 0; x < n; x++) {
                    StringBuilder row = new StringBuilder();
                    for (int y = 0; y < n; y++) {
                        row.append(matrix[x][y]).append(" ");
                    }
                    System.out.println(row.toString().trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static boolean isPlacementValid(int[][] matrix, int row, int col, int length) {
        for (int i = 0; i < length; i++) {
            if ((matrix[row][i] == matrix[row][col] && i != col) || (matrix[i][col] == matrix[row][col] && i != row)) {
                return false;
            }
        }
        return true;
    }
}