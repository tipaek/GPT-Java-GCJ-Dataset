import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();

            for (int t = 1; t <= testCases; t++) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                int[][] matrix = new int[n][n];
                boolean isPossible = true;

                if (!fillMatrix(matrix, n, k)) {
                    isPossible = false;
                }

                System.out.println("Case #" + t + ": " + (isPossible ? "POSSIBLE" : "IMPOSSIBLE"));
                if (isPossible) {
                    for (int[] row : matrix) {
                        for (int element : row) {
                            System.out.print(element + " ");
                        }
                        System.out.println();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean fillMatrix(int[][] matrix, int n, int k) {
        int trace = 0;
        int x = 0, y = 0;

        while (x < n) {
            matrix[x][y] += 1;
            if (x == y) {
                trace = calculateTrace(matrix, n);
            }

            if (matrix[x][y] > n || !isValid(matrix, x, y, n) || !(x != y || (x != n - 1 && trace < k) || (x == n - 1 && trace == k))) {
                if (matrix[x][y] >= n) {
                    matrix[x][y] = 0;
                    y -= 2;
                    if (y < -1) {
                        if (x == 0 && y == -1) {
                            return false;
                        }
                        y = n - 2;
                        x--;
                    }
                }
                y--;
            } else {
                y++;
                if (y == n) {
                    y = 0;
                    x++;
                }
            }
        }
        return true;
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static boolean isValid(int[][] matrix, int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            if ((matrix[row][i] == matrix[row][col] && i != col) || (matrix[i][col] == matrix[row][col] && i != row)) {
                return false;
            }
        }
        return true;
    }
}