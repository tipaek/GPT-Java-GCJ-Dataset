import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        for (int i = 0; i < input; i++) {
            int[] output = calculateOutput(sc);
            System.out.println("Case #" + i + ": " + output[0] + " " + output[1] + " " + output[2]);
        }
        sc.close();
    }

    public static int[] calculateOutput(Scanner sc) {
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int s = (n + 1) / 2 * n;
        int[] result = { countInvalidRows(matrix, s), countInvalidColumns(matrix, s), calculateDiagonalSum(matrix) };
        return result;
    }

    public static int countInvalidRows(int[][] matrix, int targetSum) {
        int count = 0;
        for (int[] row : matrix) {
            int sum = 0;
            for (int value : row) {
                sum += value;
            }
            if (sum != targetSum) {
                count++;
            }
        }
        return count;
    }

    public static int countInvalidColumns(int[][] matrix, int targetSum) {
        int count = 0;
        int n = matrix.length;
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += matrix[i][j];
            }
            if (sum != targetSum) {
                count++;
            }
        }
        return count;
    }

    public static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}