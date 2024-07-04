import java.util.*;
import java.io.*;
public class Solution {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix.length; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            int tr = findT(matrix);
            int r = findR(matrix);
            int c = findC(matrix);
            System.out.println("Case #" + i + ": " + (tr) + " " + (r) + " " + (c));
        }
        
        
        
    }
    
    public static int findT(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
    
    public static int findR(int[][] matrix) {
        int dup = 0;
        for (int i = 0; i < matrix.length; i++) {
            int j = 0;
            int prev = dup;
            while (j < matrix.length && prev == dup) {
                int k = matrix[i][j];
                matrix[i][j] = -1;
                int l = 0;
                while (l < matrix.length && prev == dup) {
                    if (matrix[i][l] == -1) {
                        l++;
                    } else {
                        if (matrix[i][l] == k) dup++;       
                        l++;
                    }
                }
                matrix[i][j] = k;
                j++;
            }
        }
        return dup;
    }
    
    public static int findC(int[][] matrix) {
        int dup = 0;
        for (int i = 0; i < matrix.length; i++) {
            int j = 0;
            int prev = dup;
            while (j < matrix.length && prev == dup) {
                int k = matrix[j][i];
                matrix[j][i] = -1;
                int l = 0;
                while (l < matrix.length && prev == dup) {
                    if (matrix[l][i] == -1) {
                        l++;
                    } else {
                        if (matrix[l][i] == k) dup++;       
                        l++;
                    }
                }
                matrix[j][i] = k;
                j++;
            }
        }
        return dup;
    }
}