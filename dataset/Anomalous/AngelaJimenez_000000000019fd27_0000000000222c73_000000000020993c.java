import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int cases = Integer.parseInt(reader.readLine());
            for (int i = 0; i < cases; i++) {
                int sum = 0;
                int repeatedRows = 0;
                int repeatedCols = 0;
                int n = Integer.parseInt(reader.readLine());

                int[][] matrix = new int[n][n];
                for (int j = 0; j < n; j++) {
                    String[] line = reader.readLine().split(" ");
                    for (int h = 0; h < n; h++) {
                        matrix[j][h] = Integer.parseInt(line[h]);
                        if (j == h) {
                            sum += matrix[j][h];
                        }
                    }
                }

                for (int k = 0; k < n; k++) {
                    boolean rowHasDuplicate = false;
                    boolean colHasDuplicate = false;
                    for (int z = 0; z < n && (!rowHasDuplicate || !colHasDuplicate); z++) {
                        for (int m = z + 1; m < n && (!rowHasDuplicate || !colHasDuplicate); m++) {
                            if (matrix[k][z] == matrix[k][m]) {
                                rowHasDuplicate = true;
                            }
                            if (matrix[z][k] == matrix[m][k]) {
                                colHasDuplicate = true;
                            }
                        }
                    }
                    if (rowHasDuplicate) {
                        repeatedRows++;
                    }
                    if (colHasDuplicate) {
                        repeatedCols++;
                    }
                }

                System.out.println("Case #" + (i + 1) + ": " + sum + " " + repeatedRows + " " + repeatedCols);
            }
        } catch (Exception e) {
            // Handle exception
        }
    }
}