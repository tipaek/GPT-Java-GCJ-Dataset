import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        
        for (int n = 1; n <= cases; n++) {
            int len = sc.nextInt();
            int[][] matrix = new int[len][len];
            HashSet<Integer> set = new HashSet<>(len);
            
            // Read the matrix
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            int diagonalSum = 0, duplicateRows = 0, duplicateColumns = 0;
            
            for (int i = 0; i < len; i++) {
                diagonalSum += matrix[i][i];
                
                // Check for duplicate values in the row
                set.clear();
                for (int j = 0; j < len; j++) {
                    if (!set.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
                
                // Check for duplicate values in the column
                set.clear();
                for (int j = 0; j < len; j++) {
                    if (!set.add(matrix[j][i])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + n + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
        
        sc.close();
    }
}