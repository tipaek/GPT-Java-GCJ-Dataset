import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class MatrixAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;
            int rowRep = 0;
            int colRep = 0;

            // Read matrix values
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate trace
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            // Check for row repetitions
            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRep++;
                        break;
                    }
                }
            }

            // Check for column repetitions
            for (int j = 0; j < N; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colRep++;
                        break;
                    }
                }
            }

            // Print the matrix (optional)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            // Print the result for the current test case
            System.out.println("Case #" + t + ": " + trace + " " + rowRep + " " + colRep);
        }
    }
}