import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int cases = Integer.parseInt(bf.readLine());
            for (int i = 0; i < cases; i++) {
                int diagonalSum = 0;
                int repeatedRows = 0;
                int repeatedCols = 0;
                int n = Integer.parseInt(bf.readLine());
                
                int[][] matrix = new int[n][n];
                for (int j = 0; j < n; j++) {
                    String[] line = bf.readLine().split(" ");
                    for (int h = 0; h < n; h++) {
                        matrix[j][h] = Integer.parseInt(line[h]);
                        if (j == h) {
                            diagonalSum += matrix[j][h];
                        }
                    }
                }
                
                for (int k = 0; k < n; k++) {
                    boolean rowHasDuplicates = false;
                    boolean colHasDuplicates = false;
                    for (int z = 0; z < n && (!rowHasDuplicates || !colHasDuplicates); z++) {
                        for (int m = z + 1; m < n && (!rowHasDuplicates || !colHasDuplicates); m++) {
                            if (matrix[k][z] == matrix[k][m]) {
                                rowHasDuplicates = true;
                            }
                            if (matrix[z][k] == matrix[m][k]) {
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
                
                System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}