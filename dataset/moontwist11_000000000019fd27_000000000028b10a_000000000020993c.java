import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstLine = input.nextLine();
        int numTest = Integer.parseInt(firstLine);
        for(int i = 0; i < numTest; i++) {
            String nLine = input.nextLine();
            int n = Integer.parseInt(nLine);
            
            //Reading the matrix
            int[][] matrix = new int[n][n];
            for(int j = 0; j < n; j++) {
                String[] tmp = input.nextLine().split(" ");
                matrix[j] = new int[n];
                for(int k = 0; k < n; k++) {
                    matrix[j][k] = Integer.parseInt(tmp[k]);
                }
            }
            
            int k = getTrace(matrix, n);
            int r = getNumRepeatInRows(matrix, n);
            int c = getNumRepeatInCols(matrix, n);
            
            System.out.print("Case #" + (i+1) + ": ");
            System.out.print(k + " " + r + " " + c);
            System.out.println();
        }
    }
    
    public static int getTrace(int[][] mat, int n) {
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += mat[i][i];
        }
        return sum;
    }
    
    public static int getNumRepeatInRows(int[][] mat, int n) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n];
            for(int j = 0; j < n; j++) {
                int ind = mat[i][j] - 1;
                if(!seen[ind]) {
                    seen[ind] = true;
                } else {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    
    public static int getNumRepeatInCols(int[][] mat, int n) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n];
            for(int j = 0; j < n; j++) {
                int ind = mat[j][i] - 1;
                if(!seen[ind]) {
                    seen[ind] = true;
                } else {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}