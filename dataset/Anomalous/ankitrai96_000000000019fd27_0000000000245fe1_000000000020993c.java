import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            // Reading the matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Calculating the trace
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            // Checking for row duplicates
            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() < N) {
                    rowRepeats++;
                }
            }

            // Checking for column duplicates
            for (int i = 0; i < N; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    colSet.add(matrix[j][i]);
                }
                if (colSet.size() < N) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}