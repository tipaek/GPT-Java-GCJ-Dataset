import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = scan.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    matrix[j][l] = scan.nextInt();
                }
            }
            
            int rowDuplicates = countRowDuplicates(matrix, n);
            int colDuplicates = countColDuplicates(matrix, n);
            int diagonalSum = calculateDiagonalSum(matrix, n);
            
            System.out.println("Case #" + i + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
        }
    }
    
    private static int countRowDuplicates(int[][] matrix, int n) {
        int duplicateCount = 0;
        
        for (int row = 0; row < n; row++) {
            Set<Integer> seen = new HashSet<>();
            for (int col = 0; col < n; col++) {
                if (!seen.add(matrix[row][col])) {
                    duplicateCount++;
                    break;
                }
            }
        }
        
        return duplicateCount;
    }
    
    private static int countColDuplicates(int[][] matrix, int n) {
        int duplicateCount = 0;
        
        for (int col = 0; col < n; col++) {
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < n; row++) {
                if (!seen.add(matrix[row][col])) {
                    duplicateCount++;
                    break;
                }
            }
        }
        
        return duplicateCount;
    }
    
    private static int calculateDiagonalSum(int[][] matrix, int n) {
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        
        return sum;
    }
}