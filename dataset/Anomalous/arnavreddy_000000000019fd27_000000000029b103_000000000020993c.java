import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            System.out.println("Case #" + testCase + ": " + calculateTrace(matrix, size) + " " + countDuplicateRows(matrix, size) + " " + countDuplicateColumns(matrix, size));
        }
    }

    private static long calculateTrace(int[][] matrix, int size) {
        long trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRowCount = 0;
        
        for (int row = 0; row < size; row++) {
            Set<Integer> seen = new HashSet<>();
            for (int col = 0; col < size; col++) {
                if (!seen.add(matrix[row][col])) {
                    duplicateRowCount++;
                    break;
                }
            }
        }
        
        return duplicateRowCount;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumnCount = 0;
        
        for (int col = 0; col < size; col++) {
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!seen.add(matrix[row][col])) {
                    duplicateColumnCount++;
                    break;
                }
            }
        }
        
        return duplicateColumnCount;
    }
}