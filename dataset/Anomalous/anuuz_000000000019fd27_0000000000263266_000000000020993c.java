import java.util.Scanner;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][][] mat = new int[t][][];
        
        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            mat[k] = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[k][i][j] = sc.nextInt();
                }
            }
        }
        
        for (int i = 0; i < t; i++) {
            int trace = 0;
            int n = mat[i].length;
            
            for (int j = 0; j < n; j++) {
                trace += mat[i][j][j];
            }
            
            System.out.print("Case #" + (i + 1) + ": " + trace);
            System.out.print(" " + countDuplicateRows(mat[i]));
            
            // Transpose the matrix
            int[][] transposed = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    transposed[j][k] = mat[i][k][j];
                }
            }
            
            System.out.print(" " + countDuplicateRows(transposed));
            System.out.println();
        }
        
        sc.close();
    }
    
    public static int countDuplicateRows(int[][] matrix) {
        int count = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
            
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] == matrix[i][j + 1]) {
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }
}