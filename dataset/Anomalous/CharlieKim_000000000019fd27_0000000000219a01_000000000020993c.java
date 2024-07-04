import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numOfCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = readMatrix(scanner, matrixSize);

            System.out.println("Case #" + caseIndex + ": " + analyzeMatrix(matrix, matrixSize));
        }
    }

    private static int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static String analyzeMatrix(int[][] matrix, int size) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];

            if (!isUnique(matrix[i])) {
                duplicateRows++;
            }

            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
            }
            if (!isUnique(column)) {
                duplicateCols++;
            }
        }

        return trace + " " + duplicateRows + " " + duplicateCols;
    }

    private static boolean isUnique(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int value : array) {
            if (!uniqueElements.add(value)) {
                return false;
            }
        }
        return true;
    }
}