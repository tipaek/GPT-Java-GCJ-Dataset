import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class MatrixTrace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;
            int rowRepetitions = 0;
            int colRepetitions = 0;

            // Reading the matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculating trace
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            // Calculating row repetitions
            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepetitions++;
                        break;
                    }
                }
            }

            // Calculating column repetitions
            for (int j = 0; j < N; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colRepetitions++;
                        break;
                    }
                }
            }

            // Printing the matrix (optional)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            // Printing the result
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowRepetitions + " " + colRepetitions);
        }
    }
}