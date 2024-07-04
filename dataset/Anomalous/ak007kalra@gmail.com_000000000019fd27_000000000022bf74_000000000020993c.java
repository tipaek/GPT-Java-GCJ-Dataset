import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = input.nextInt();
            int[][] matrix = new int[n][n];
            
            // Reading the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = input.nextInt();
                }
            }
            
            int diagonalSum = 0;
            for (int idx = 0; idx < n; idx++) {
                diagonalSum += matrix[idx][idx];
            }
            
            int rowDuplicates = 0;
            for (int row = 0; row < n; row++) {
                HashMap<Integer, Integer> rowMap = new HashMap<>();
                for (int col = 0; col < n; col++) {
                    if (rowMap.containsKey(matrix[row][col])) {
                        rowDuplicates++;
                        break;
                    } else {
                        rowMap.put(matrix[row][col], 1);
                    }
                }
            }
            
            int colDuplicates = 0;
            for (int col = 0; col < n; col++) {
                HashMap<Integer, Integer> colMap = new HashMap<>();
                for (int row = 0; row < n; row++) {
                    if (colMap.containsKey(matrix[row][col])) {
                        colDuplicates++;
                        break;
                    } else {
                        colMap.put(matrix[row][col], 1);
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
        }
        
        input.close();
    }
}