import java.util.*;
public class Solution {
    
    public static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=1; i<=t; i++) {
            solve(i);
        }
    }
    
    public static void solve(int caseNumber) {
        int n = sc.nextInt();
        int[][] matrix = readInputs(n);
        int trace = calculateTrace(matrix) + n;
        
        int[] mask = new int[n];
        
        int nrows = 0;
        for(int i=0; i<n; i++) {
           Arrays.fill(mask, 0);
           for(int j=0; j<n; j++) {
               if(mask[matrix[i][j]] != 0) {
                   nrows++;
                   break;
               }
               mask[matrix[i][j]] = 1;
           }
        }
        
        int ncols = 0;
        for(int i=0; i<n; i++) {
           Arrays.fill(mask, 0);
           for(int j=0; j<n; j++) {
               if(mask[matrix[j][i]] != 0) {
                   ncols++;
                   break;
               }
               mask[matrix[j][i]] = 1;
           }
        }
        
        System.out.println("Case #" + caseNumber + ": " + trace + " " + nrows + " " + ncols);
    }
    
    public static int[][] readInputs(int n) {
        int matrix[][] = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = sc.nextInt()-1;
            }
        }
        return matrix;
    }
    
    public static int calculateTrace(int[][] matrix) {
        int n = matrix.length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}