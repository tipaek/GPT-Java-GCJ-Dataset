import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();

        for (int t = 0; t < testCases; t++) {
            int matrixSize = input.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }

            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];

                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();

                for (int j = 0; j < matrixSize; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }

                if (rowSet.size() < matrixSize) {
                    rowDuplicates++;
                }
                if (colSet.size() < matrixSize) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}