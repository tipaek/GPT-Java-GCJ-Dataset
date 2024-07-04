import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int x = 1; x <= testCases; x++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            int rowRepeats = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            int columnRepeats = 0;
            for (int j = 0; j < n; j++) {
                HashSet<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!columnSet.add(matrix[i][j])) {
                        columnRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + x + ": " + trace + " " + rowRepeats + " " + columnRepeats);
        }

        scanner.close();
    }
}