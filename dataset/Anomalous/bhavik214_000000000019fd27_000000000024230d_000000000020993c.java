import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void solve(Scanner scanner, int caseNumber) {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        
        // Read matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        int rowDuplicates = countRowDuplicates(matrix, n);
        int columnDuplicates = countColumnDuplicates(matrix, n);
        int trace = calculateTrace(matrix, n);

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        System.out.flush();
    }

    private static int countRowDuplicates(int[][] matrix, int n) {
        int rowDuplicates = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[matrix[i][j]]) {
                    rowDuplicates++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        return rowDuplicates;
    }

    private static int countColumnDuplicates(int[][] matrix, int n) {
        int columnDuplicates = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[matrix[j][i]]) {
                    columnDuplicates++;
                    break;
                }
                seen[matrix[j][i]] = true;
            }
        }
        return columnDuplicates;
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
            int t = scanner.nextInt();
            for (int i = 1; i <= t; i++) {
                solve(scanner, i);
            }
        }
    }
}