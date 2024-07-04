import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

class Jam {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int testCase = 0;

        while (t-- > 0) {
            testCase++;
            try {
                int n = sc.nextInt();
                int[][] matrix = new int[n][n];
                int trace = 0;

                // Read matrix and calculate trace
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = sc.nextInt();
                        if (i == j) {
                            trace += matrix[i][j];
                        }
                    }
                }

                int rowRepeats = 0, colRepeats = 0;

                // Check for duplicate values in rows
                for (int i = 0; i < n; i++) {
                    HashMap<Integer, Integer> rowMap = new HashMap<>();
                    for (int j = 0; j < n; j++) {
                        if (rowMap.containsKey(matrix[i][j])) {
                            rowRepeats++;
                            break;
                        } else {
                            rowMap.put(matrix[i][j], j);
                        }
                    }
                }

                // Check for duplicate values in columns
                for (int j = 0; j < n; j++) {
                    HashMap<Integer, Integer> colMap = new HashMap<>();
                    for (int i = 0; i < n; i++) {
                        if (colMap.containsKey(matrix[i][j])) {
                            colRepeats++;
                            break;
                        } else {
                            colMap.put(matrix[i][j], i);
                        }
                    }
                }

                // Print result for the current test case
                System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}