import java.util.*;

class Solution
{
    public static void main (String [] args) {
        Scanner s = new Scanner (System.in);
        
        int t = s.nextInt();
        
        for (int k = 0; k < t; k++) {
            int n = s.nextInt();
            int [][] mat = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = s.nextInt();        
                }   
            }
            
            solve (k + 1, mat, n);
        }
    }
    
    private static void solve (int caseNum, int[][] mat, int  n) {
        int row = 0;
        for (int i = 0; i < n; i++) {
            int[] count = new int[n];
            for (int j = 0; j < n; j++) {
                int x = mat[i][j];
                count[x - 1]++;
                if (count[x-1] == 2) {
                    row++;
                    break;
                }
            }   
        }
        
        int col = 0;
        for (int i = 0; i < n; i++) {
            int[] count = new int[n];
            for (int j = 0; j < n; j++) {
                int x = mat[j][i];
                count[x - 1]++;
                if (count[x-1] == 2) {
                    col++;
                    break;
                }
            }   
        }
        
        int diag = 0;
        for (int i = 0; i < n; i++) {
            diag += mat[i][i];
        }
        
        System.out.println ("Case #"+caseNum+": "+diag+" "+row+" "+col);
    }
}