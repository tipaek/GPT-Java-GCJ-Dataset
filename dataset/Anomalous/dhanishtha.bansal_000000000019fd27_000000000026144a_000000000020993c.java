import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeJamQ1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Read the matrix and calculate trace
            for (int i = 0; i < n; i++) {
                String[] rowValues = br.readLine().trim().split(" ");
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(rowValues[j]);
                    matrix[i][j] = value;
                    if (i == j) {
                        trace += value;
                    }
                    rowSet.add(value);
                }
                if (rowSet.size() != n) {
                    rowRepeats++;
                }
            }

            // Check for column repeats
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != n) {
                    colRepeats++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowRepeats, colRepeats);
        }
    }
}