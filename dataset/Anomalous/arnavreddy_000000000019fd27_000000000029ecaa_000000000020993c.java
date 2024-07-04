import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            System.out.print("Case #" + i + ": ");
            System.out.print(calculateTrace(matrix) + " ");
            System.out.print(countDuplicateRows(matrix) + " ");
            System.out.print(countDuplicateColumns(matrix));
            System.out.println();
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicates = 0;
        for (int[] row : matrix) {
            Set<Integer> seen = new HashSet<>();
            for (int value : row) {
                if (!seen.add(value)) {
                    duplicates++;
                    break;
                }
            }
        }
        return duplicates;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicates = 0;
        int n = matrix.length;
        
        for (int col = 0; col < n; col++) {
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < n; row++) {
                if (!seen.add(matrix[row][col])) {
                    duplicates++;
                    break;
                }
            }
        }
        return duplicates;
    }
}