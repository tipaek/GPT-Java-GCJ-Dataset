import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int row = 0; row < n; row++) {
                for (int column = 0; column < n; column++) {
                    matrix[row][column] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;

            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
                if (hasDuplicates(getColumn(matrix, i))) {
                    columnDuplicates++;
                }
            }

            System.out.println("Case #" + (testCase + 1) + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}