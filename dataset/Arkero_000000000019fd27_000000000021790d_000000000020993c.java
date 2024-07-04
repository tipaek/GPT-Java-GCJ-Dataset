import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        StringBuilder result = new StringBuilder();

        for (int test = 1; test <= T; ++test) {
            int matrixSize = in.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = in.nextInt();
                }
            }
            result.append("Case #" + test + ": " + processMatrix(matrixSize, matrix) + "\n");
        }
        System.out.println(result);

    }



    static String processMatrix(int N, int [][] matrix) {

        int repeatedValueRows = 0;
        int repeatedValueColumns = 0;
        int matrixTrace = 0;

        for (int i=0; i<N; i++) {
            Set<Integer> rowValues = new HashSet<>();
            Set<Integer> columnValues = new HashSet<>();
            boolean nonRepeatedRowValue = true;
            boolean nonRepeatedColumnValue = true;


            for (int j=0; j<N; j++) {

                if (nonRepeatedRowValue) {
                    nonRepeatedRowValue = rowValues.add(matrix[i][j]);
                }

                if (nonRepeatedColumnValue) {
                    nonRepeatedColumnValue = columnValues.add(matrix[j][i]);
                }

                if (i == j) {
                    matrixTrace += matrix[i][j];
                }
            }

            if (rowValues.size() < N) {
                repeatedValueRows++;
            }

            if (columnValues.size() < N) {
                repeatedValueColumns++;
            }
        }

        return matrixTrace + " " + repeatedValueRows + " " + repeatedValueColumns;
    }

}
