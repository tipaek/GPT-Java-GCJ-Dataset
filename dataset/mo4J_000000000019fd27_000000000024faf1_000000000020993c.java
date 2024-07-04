import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {


    private static boolean hasUniqueRowValues(int[][] matrix, int rowNumber, int n) {
        Map<Integer, Integer> existingValues = new HashMap<>();
        for(int i=0; i<n; i++) {
            if(existingValues.get(matrix[rowNumber][i]) != null) {
                return false;
            } else {
                existingValues.put(matrix[rowNumber][i], 1);
            }
        }
        return true;
    }

    private static boolean hasUniqueColumnValues(int[][] matrix, int n, int columnNumber) {
        Map<Integer, Integer> existingValues = new HashMap<>();
        for(int i=0; i<n; i++) {
            if(existingValues.get(matrix[i][columnNumber]) != null) {
                return false;
            } else {
                existingValues.put(matrix[i][columnNumber], 1);
            }
        }
        return true;
    }

    private static int countRowsWithRepeatedElements(int[][] matrix, int n) {
        int countRepeatedElementsRows = 0;
        for (int i=0; i<n; i++) {
            boolean hasUniqueRowValues =  hasUniqueRowValues(matrix, i, n);
            countRepeatedElementsRows = hasUniqueRowValues?
                    countRepeatedElementsRows:countRepeatedElementsRows + 1;
        }
        return countRepeatedElementsRows;
    }

    private static int countColumnsWithRepeatedElements(int[][] matrix, int n) {
        int countRepeatedElementsColumns = 0;
        for (int i=0; i<n; i++) {
            boolean hasUniqueColumnValues = hasUniqueColumnValues(matrix, n, i);
            countRepeatedElementsColumns = hasUniqueColumnValues?
                    countRepeatedElementsColumns:countRepeatedElementsColumns + 1;
        }
        return countRepeatedElementsColumns;
    }

    private static int countMatrixTrace(int[][] matrix, int n) {
        int trace = 0;
        for(int i=0; i<n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            int trace = countMatrixTrace(matrix, n);
            int repeatedValuesRowsCount = countRowsWithRepeatedElements(matrix, n);
            int repeatedValuesColumnsCount = countColumnsWithRepeatedElements(matrix, n);

            System.out.println("Case #" + i + ": " + trace + " " + repeatedValuesRowsCount + " " +
                    repeatedValuesColumnsCount);

        }
    }
}
