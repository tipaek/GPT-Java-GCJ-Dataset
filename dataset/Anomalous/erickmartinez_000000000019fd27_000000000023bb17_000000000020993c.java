import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[][][] matrices = new int[testCases][][];

        for (int i = 0; i < testCases; i++) {
            int size = scanner.nextInt();
            matrices[i] = new int[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrices[i][row][col] = scanner.nextInt();
                }
            }
        }

        for (int i = 0; i < testCases; i++) {
            validateMatrix(matrices[i], i);
        }
    }

    public static void validateMatrix(int[][] matrix, int caseNumber) {
        int size = matrix.length;
        int duplicateRows = 0;
        int duplicateCols = 0;
        int trace = 0;

        for (int i = 0; i < size; i++) {
            HashSet<Integer> seenInRow = new HashSet<>();
            HashSet<Integer> seenInCol = new HashSet<>();
            trace += matrix[i][i];

            for (int j = 0; j < size; j++) {
                if (!seenInRow.add(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
            }

            for (int j = 0; j < size; j++) {
                if (!seenInCol.add(matrix[j][i])) {
                    duplicateCols++;
                    break;
                }
            }
        }

        System.out.println("Case #" + (caseNumber + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
    }
}