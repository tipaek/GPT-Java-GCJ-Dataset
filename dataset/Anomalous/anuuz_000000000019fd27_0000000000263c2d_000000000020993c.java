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
        
        for (int k = 0; k < t; k++) {
            int trace = 0;
            System.out.print("Case #" + (k + 1) + ":");
            
            for (int i = 0; i < mat[k].length; i++) {
                trace += mat[k][i][i];
            }
            System.out.print(" " + trace);
            
            int rowDuplicates = countDuplicates(mat[k]);
            System.out.print(" " + rowDuplicates);
            
            int[][] transposedMat = transpose(mat[k]);
            int colDuplicates = countDuplicates(transposedMat);
            System.out.print(" " + colDuplicates);
            
            System.out.println();
        }
    }
    
    public static int countDuplicates(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            Arrays.sort(row);
            for (int j = 0; j < row.length - 1; j++) {
                if (row[j] == row[j + 1]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    
    public static int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int[][] transposed = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
}