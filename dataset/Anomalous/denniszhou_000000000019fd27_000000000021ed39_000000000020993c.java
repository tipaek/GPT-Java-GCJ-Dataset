import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(rowValues[col]);
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                if (rowSet.size() < matrixSize) duplicateRows++;
                if (colSet.size() < matrixSize) duplicateCols++;
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}