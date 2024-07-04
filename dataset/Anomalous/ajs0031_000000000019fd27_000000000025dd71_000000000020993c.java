package driver;

import java.util.HashSet;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scanner.nextInt();
        
        for (int curCase = 1; curCase <= numCases; curCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix);
            int repeatedRows = countRepeatedRows(matrix);
            int repeatedCols = countRepeatedColumns(matrix);
            
            System.out.println("Case #" + curCase + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix) {
        int repeatedRowsCount = 0;
        
        for (int[] row : matrix) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    repeatedRowsCount++;
                    break;
                }
            }
        }
        
        return repeatedRowsCount;
    }

    private static int countRepeatedColumns(int[][] matrix) {
        int repeatedColsCount = 0;
        
        for (int col = 0; col < matrix.length; col++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    repeatedColsCount++;
                    break;
                }
            }
        }
        
        return repeatedColsCount;
    }
}