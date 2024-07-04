import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner in = new Scanner(new BufferedReader(new FileReader("/home/dev/projects/codejam20/src/input.txt")));

        int T = in.nextInt();

        //iterate test cases
        for (int t=1; t<=T; t++){
            // size of the matrix
            int N = in.nextInt();
            int [][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                int []row = new int[N];
                for (int j = 0; j < N ; j++) {
                    row[j] = in.nextInt();
                }
                matrix [i] = row;
            }
            solveMat(t, matrix);
        }
    }

    private static void solveMat(int testCase, int[][] matrix) {
        System.out.print(" Case #" + testCase + ": ");
        System.out.print(findTrace(matrix) + " ");
        int []repeats = getRepeatedCount(matrix);
        System.out.println(repeats[0] + " " + repeats[1]);
    }

    private static int[] getRepeatedCount(int [][]mat){
        int rowCount = 0;
        int colCount = 0;

        for (int i = 0; i < mat[0].length; i ++) {
            Map<Integer, Integer> columnMap = new HashMap<>();
            Map<Integer, Integer> rowMap = new HashMap<>();

            for (int j = 0; j < mat[0].length; j++) {

                //add row
                if (rowMap.get(mat[i][j]) != null) {
                    rowMap.put(mat[i][j], rowMap.get(mat[i][j]) + 1);
                    rowCount = rowCount + 1;
                    break;
                } else {
                    rowMap.put(mat[i][j], 1);
                }
            }

            for (int j = 0; j < mat[0].length; j++) {

                //add column
                if (columnMap.get(mat[j][i]) != null) {
                    columnMap.put(mat[j][i], columnMap.get(mat[j][i]) + 1);
                    colCount = colCount + 1;
                    break;
                } else {
                    columnMap.put(mat[j][i], 1);
                }
            }

        }
        return new int[]{rowCount, colCount};
    }


    private static int findTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix[0].length; i ++) {
            trace = trace + matrix[i][i];
        }
        return trace;
    }


    private static void printMatrix(int [][]mat) {
        for (int i = 0; i < mat[0].length; i ++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }
}
