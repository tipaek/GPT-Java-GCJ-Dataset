package coding_challenge;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queryCount = scanner.nextInt();

        for (int i = 0; i < queryCount; i++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;
            int duplicateRows = 0;

            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() != matrixSize) {
                    duplicateRows++;
                }
            }

            int duplicateCols = countColumnDuplicates(matrix, matrixSize);

            answer.append(String.format("Case #%d: %d %d %d%n", i + 1, trace, duplicateRows, duplicateCols));
        }

        System.out.print(answer);
        scanner.close();
    }

    private static int countColumnDuplicates(int[][] matrix, int size) {
        int duplicateCols = 0;

        for (int col = 0; col < size; col++) {
            Set<Integer> colSet = new HashSet<>();
            for (int row = 0; row < size; row++) {
                colSet.add(matrix[row][col]);
            }
            if (colSet.size() != size) {
                duplicateCols++;
            }
        }

        return duplicateCols;
    }
}