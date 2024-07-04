import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static String calculateVestigium(int[][] matrix) {
        int trace = 0;
        int size = matrix.length;
        int rowCount = 0, colCount = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowCount++;
                    break;
                }
            }
            for (int j = 0; j < size; j++) {
                if (!colSet.add(matrix[j][i])) {
                    colCount++;
                    break;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        return trace + " " + rowCount + " " + colCount;
    }

    public static void main(String[] args) {
        int[][][] testCases = readInput();
        for (int i = 0; i < testCases.length; i++) {
            String result = calculateVestigium(testCases[i]);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static int[][][] readInput() {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        int[][][] testCases = new int[testCaseCount][][];

        for (int t = 0; t < testCaseCount; t++) {
            int size = scanner.nextInt();
            testCases[t] = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    testCases[t][i][j] = scanner.nextInt();
                }
            }
        }
        scanner.close();
        return testCases;
    }
}