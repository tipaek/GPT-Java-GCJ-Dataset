import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix, size);
            int repeatedRows = countRepeatedRows(matrix, size);
            int repeatedColumns = countRepeatedColumns(matrix, size);
            
            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, repeatedRows, repeatedColumns);
        }
        
        scanner.close();
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix, int size) {
        int repeatedRows = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> elements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                elements.add(matrix[i][j]);
            }
            if (elements.size() != size) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }

    private static int countRepeatedColumns(int[][] matrix, int size) {
        int repeatedColumns = 0;
        for (int j = 0; j < size; j++) {
            Set<Integer> elements = new HashSet<>();
            for (int i = 0; i < size; i++) {
                elements.add(matrix[i][j]);
            }
            if (elements.size() != size) {
                repeatedColumns++;
            }
        }
        return repeatedColumns;
    }
}