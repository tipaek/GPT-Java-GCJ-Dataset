import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
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
                    for (int k = 0; k < n; k++) {
                        matrix[j][k] = Integer.parseInt(line[k]);
                        if (j == k) {
                            sum += matrix[j][k];
                        }
                    }
                }

                for (int row = 0; row < n; row++) {
                    boolean rowHasDuplicates = false;
                    boolean colHasDuplicates = false;
                    for (int col = 0; col < n; col++) {
                        for (int k = col + 1; k < n; k++) {
                            if (matrix[row][col] == matrix[row][k]) {
                                rowHasDuplicates = true;
                            }
                            if (matrix[col][row] == matrix[k][row]) {
                                colHasDuplicates = true;
                            }
                        }
                    }
                    if (rowHasDuplicates) {
                        repeatedRows++;
                    }
                    if (colHasDuplicates) {
                        repeatedCols++;
                    }
                }

                System.out.println("Case #" + (i + 1) + ": " + sum + " " + repeatedRows + " " + repeatedCols);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}