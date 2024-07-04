import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;
            
            for (int row = 0; row < size; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() < size) {
                    duplicateRows++;
                }
            }
            
            for (int col = 0; col < size; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int row = 0; row < size; row++) {
                    if (colSet.contains(matrix[row][col])) {
                        duplicateColumns++;
                        break;
                    }
                    colSet.add(matrix[row][col]);
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", testCase, diagonalSum, duplicateRows, duplicateColumns);
        }
        
        scanner.close();
    }
}