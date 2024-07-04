import java.util.Scanner;
import java.io.IOException;

class Test2 {
    public static void main(String[] args) throws IOException {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();

            for (int i = 0; i < t; i++) {
                int n = sc.nextInt();
                int[][] matrix = new int[n][n];
                int trace = 0, rowRepeats = 0, colRepeats = 0;

                // Read the matrix and calculate the trace
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        matrix[j][k] = sc.nextInt();
                        if (j == k) {
                            trace += matrix[j][k];
                        }
                    }
                }

                // Check for repeated elements in rows
                for (int j = 0; j < n; j++) {
                    Set<Integer> rowSet = new HashSet<>();
                    for (int k = 0; k < n; k++) {
                        if (rowSet.contains(matrix[j][k])) {
                            rowRepeats++;
                            break;
                        }
                        rowSet.add(matrix[j][k]);
                    }
                }

                // Check for repeated elements in columns
                for (int j = 0; j < n; j++) {
                    Set<Integer> colSet = new HashSet<>();
                    for (int k = 0; k < n; k++) {
                        if (colSet.contains(matrix[k][j])) {
                            colRepeats++;
                            break;
                        }
                        colSet.add(matrix[k][j]);
                    }
                }

                System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
            }
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }
}