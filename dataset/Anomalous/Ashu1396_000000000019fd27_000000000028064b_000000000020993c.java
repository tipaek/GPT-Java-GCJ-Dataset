import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int diagonalSum = 0;

            // Reading the matrix and calculating the diagonal sum
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
            }

            int repeatedRows = 0;
            int repeatedCols = 0;

            // Checking for rows with repeated elements
            for (int row = 0; row < N; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < N; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        repeatedRows++;
                        break;
                    }
                }
            }

            // Checking for columns with repeated elements
            for (int col = 0; col < N; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < N; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        repeatedCols++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
        }

        scanner.close();
    }
}