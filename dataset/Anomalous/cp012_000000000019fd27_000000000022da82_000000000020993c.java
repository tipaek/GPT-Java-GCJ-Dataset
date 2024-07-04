import java.util.Scanner;
import java.util.HashSet;

class Matrix {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowHasDuplicate && !rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                        rowRepeats++;
                    }
                }
            }

            // Check for column duplicates
            for (int j = 0; j < N; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}