import java.util.*;

public class HelloWorld {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int rowDuplicates = countRowDuplicates(matrix, n);
            int colDuplicates = countColumnDuplicates(matrix, n);

            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowDuplicates, colDuplicates);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicates = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[i][j])) {
                    duplicates++;
                    break;
                }
            }
        }
        return duplicates;
    }

    private static int countColumnDuplicates(int[][] matrix, int size) {
        int duplicates = 0;
        for (int j = 0; j < size; j++) {
            Set<Integer> seen = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!seen.add(matrix[i][j])) {
                    duplicates++;
                    break;
                }
            }
        }
        return duplicates;
    }
}