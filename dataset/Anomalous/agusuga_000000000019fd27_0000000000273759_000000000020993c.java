import java.util.Scanner;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int i = 1; i <= cases; i++) {
            int size = in.nextInt();
            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;

            int[][] matrix = new int[size][size];
            boolean[] colDup = new boolean[size];

            // Read matrix and calculate trace
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = in.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            // Check for repeated rows
            for (int j = 0; j < size; j++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowDup = false;
                for (int k = 0; k < size; k++) {
                    if (!rowSet.add(matrix[j][k]) && !rowDup) {
                        repeatedRows++;
                        rowDup = true;
                    }
                }
            }

            // Check for repeated columns
            for (int k = 0; k < size; k++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colDupFlag = false;
                for (int j = 0; j < size; j++) {
                    if (!colSet.add(matrix[j][k]) && !colDupFlag) {
                        repeatedColumns++;
                        colDupFlag = true;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}