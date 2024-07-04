import java.util.Scanner;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int testcases = scan.nextInt();
        int[][] result = new int[testcases][3];

        for (int t = 0; t < testcases; t++) {
            int matrixSize = scan.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowDupFound = false;

                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scan.nextInt();

                    if (!rowDupFound && rowSet.contains(matrix[i][j])) {
                        result[t][1]++;
                        rowDupFound = true;
                    }
                    rowSet.add(matrix[i][j]);

                    if (i == j) {
                        result[t][0] += matrix[i][j];
                    }
                }
            }

            for (int col = 0; col < matrixSize; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colDupFound = false;

                for (int row = 0; row < matrixSize; row++) {
                    if (!colDupFound && colSet.contains(matrix[row][col])) {
                        result[t][2]++;
                        colDupFound = true;
                    }
                    colSet.add(matrix[row][col]);
                }
            }
        }

        for (int t = 0; t < testcases; t++) {
            System.out.println("Case #" + (t + 1) + ": " + result[t][0] + " " + result[t][1] + " " + result[t][2]);
        }
        
        scan.close();
    }
}