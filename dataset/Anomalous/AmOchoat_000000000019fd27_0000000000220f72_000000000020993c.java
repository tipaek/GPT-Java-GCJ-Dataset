import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = reader.readLine();
            int cases = Integer.parseInt(line.trim());
            
            for (int i = 0; i < cases; i++) {
                line = reader.readLine();
                int n = Integer.parseInt(line.trim());
                Integer[][] matrix = new Integer[n][n];

                for (int row = 0; row < n; row++) {
                    line = reader.readLine();
                    String[] values = line.split(" ");
                    for (int col = 0; col < n; col++) {
                        matrix[row][col] = Integer.parseInt(values[col]);
                    }
                }

                int trace = 0;
                for (int j = 0; j < n; j++) {
                    trace += matrix[j][j];
                }

                int duplicateRows = 0;
                for (int row = 0; row < n; row++) {
                    boolean hasDuplicate = false;
                    outerLoop:
                    for (int col1 = 0; col1 < n; col1++) {
                        for (int col2 = col1 + 1; col2 < n; col2++) {
                            if (matrix[row][col1].equals(matrix[row][col2])) {
                                duplicateRows++;
                                hasDuplicate = true;
                                break outerLoop;
                            }
                        }
                    }
                }

                int duplicateCols = 0;
                for (int col = 0; col < n; col++) {
                    boolean hasDuplicate = false;
                    outerLoop:
                    for (int row1 = 0; row1 < n; row1++) {
                        for (int row2 = row1 + 1; row2 < n; row2++) {
                            if (matrix[row1][col].equals(matrix[row2][col])) {
                                duplicateCols++;
                                hasDuplicate = true;
                                break outerLoop;
                            }
                        }
                    }
                }

                System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, duplicateRows, duplicateCols);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}