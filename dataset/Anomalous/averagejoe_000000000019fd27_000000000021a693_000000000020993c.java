import java.util.*;

class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nCases = sc.nextInt();

        for (int i = 0; i < nCases; i++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Read the matrix and calculate the trace
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    matrix[r][c] = sc.nextInt();
                    if (r == c) {
                        trace += matrix[r][c];
                    }
                }
            }

            // Check for duplicates in each row
            for (int r = 0; r < N; r++) {
                Set<Integer> seen = new HashSet<>();
                for (int c = 0; c < N; c++) {
                    if (!seen.add(matrix[r][c])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Check for duplicates in each column
            for (int c = 0; c < N; c++) {
                Set<Integer> seen = new HashSet<>();
                for (int r = 0; r < N; r++) {
                    if (!seen.add(matrix[r][c])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, rowDuplicates, colDuplicates);
        }
    }
}