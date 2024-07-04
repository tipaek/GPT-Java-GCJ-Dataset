import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine(); // consume the newline character

        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();

            if (line.isEmpty()) {
                i--;
                continue;
            }

            String[] lineParts = line.split(" ");
            int n = Integer.parseInt(lineParts[0]);
            int k = Integer.parseInt(lineParts[1]);

            if (n * n < k) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            int[] valuesAtLine = new int[n];
            Arrays.fill(valuesAtLine, n);
            int workingOn = n - 1;
            boolean possible = adjustValues(valuesAtLine, workingOn, k);

            if (!possible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            int[][] matrix = constructMatrix(n, valuesAtLine);
            if (fillMatrix(matrix, n)) {
                printMatrix(i, matrix, n);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean adjustValues(int[] valuesAtLine, int workingOn, int targetSum) {
        while (calculateSum(valuesAtLine) != targetSum) {
            if (valuesAtLine[workingOn] == 1) {
                workingOn--;
            }
            if (workingOn == 1 && valuesAtLine[workingOn] == 1) {
                return false;
            }
            valuesAtLine[workingOn]--;
        }
        return true;
    }

    private static int[][] constructMatrix(int n, int[] valuesAtLine) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i][i] = valuesAtLine[i];
        }
        return matrix;
    }

    private static boolean fillMatrix(int[][] matrix, int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int value = random.nextInt(n) + 1;
                int attempts = 0;

                while (checkRows(value, matrix, i, n) || checkColumns(value, matrix, j, n)) {
                    value = random.nextInt(n) + 1;
                    attempts++;
                    if (attempts > n * n) return false;
                }
                matrix[i][j] = value;
            }
        }
        return true;
    }

    private static boolean checkColumns(int value, int[][] matrix, int col, int n) {
        for (int row = 0; row < n; row++) {
            if (matrix[row][col] == value) return true;
        }
        return false;
    }

    private static boolean checkRows(int value, int[][] matrix, int row, int n) {
        for (int col = 0; col < n; col++) {
            if (matrix[row][col] == value) return true;
        }
        return false;
    }

    private static int calculateSum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    private static void printMatrix(int caseNumber, int[][] matrix, int n) {
        System.out.println("Case #" + caseNumber + ":");
        for (int[] row : matrix) {
            for (int j = 0; j < n; j++) {
                System.out.print(row[j]);
                if (j < n - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}