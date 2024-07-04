import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int cases = Integer.parseInt(bf.readLine());
            for (int i = 0; i < cases; i++) {
                int sum = 0;
                int repeatedRows = 0;
                int repeatedColumns = 0;
                int n = Integer.parseInt(bf.readLine());
                int[][] matrix = new int[n][n];
                
                for (int j = 0; j < n; j++) {
                    String[] line = bf.readLine().split(" ");
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
                    for (int z = 0; z < n; z++) {
                        for (int m = z + 1; m < n; m++) {
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
                        repeatedColumns++;
                    }
                }

                System.out.println("Case #" + (i + 1) + ": " + sum + " " + repeatedRows + " " + repeatedColumns);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}