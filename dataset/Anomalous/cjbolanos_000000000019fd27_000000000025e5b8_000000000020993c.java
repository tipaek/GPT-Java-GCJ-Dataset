import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int i = 1; i <= cases; i++) {
            processCase(i, scanner);
        }
        scanner.close();
    }

    static void processCase(int caseNumber, Scanner scanner) {
        int N = scanner.nextInt();
        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int trace = calculateTrace(matrix, N);
        int duplicateRows = countDuplicateRows(matrix, N);
        int duplicateCols = countDuplicateCols(matrix, N);

        System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, duplicateRows, duplicateCols);
    }

    static int calculateTrace(int[][] matrix, int N) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    static int countDuplicateRows(int[][] matrix, int N) {
        int duplicateRows = 0;
        for (int i = 0; i < N; i++) {
            boolean[] seen = new boolean[N + 1];
            for (int j = 0; j < N; j++) {
                if (seen[matrix[i][j]]) {
                    duplicateRows++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        return duplicateRows;
    }

    static int countDuplicateCols(int[][] matrix, int N) {
        int duplicateCols = 0;
        for (int i = 0; i < N; i++) {
            boolean[] seen = new boolean[N + 1];
            for (int j = 0; j < N; j++) {
                if (seen[matrix[j][i]]) {
                    duplicateCols++;
                    break;
                }
                seen[matrix[j][i]] = true;
            }
        }
        return duplicateCols;
    }
}