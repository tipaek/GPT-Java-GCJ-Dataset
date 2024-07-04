import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private int solve(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];
        int[][] elimination = new int[rows][cols];

        // Initialize matrix and elimination arrays
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
                elimination[i][j] = 1;
            }
        }

        int result = 0;
        boolean shouldStop = false;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!shouldStop) {
            shouldStop = true;
            int interimResult = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    interimResult += matrix[i][j];
                    if (matrix[i][j] == 0) continue;

                    double sum = 0;
                    int count = 0;

                    for (int[] direction : directions) {
                        int y = i, x = j;
                        while (y >= 0 && y < rows && x >= 0 && x < cols) {
                            if ((x != j || y != i) && matrix[y][x] > 0) {
                                count++;
                                sum += matrix[y][x];
                                break;
                            }
                            y += direction[0];
                            x += direction[1];
                        }
                    }

                    if (count > 0) {
                        sum /= count;
                        if (sum > matrix[i][j]) {
                            elimination[i][j] = 0;
                            shouldStop = false;
                        }
                    }
                }
            }

            result += interimResult;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] *= elimination[i][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        Solution solution = new Solution();

        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ": " + solution.solve(scanner));
        }
    }
}