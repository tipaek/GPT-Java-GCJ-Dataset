import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        
        for (int t = 1; t <= T; t++){
            int n = scanner.nextInt();
            int[][] mat = new int[n][n];
            
            
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    mat[i][j] = scanner.nextInt();
                }
            }
            
            int trace = 0;
            
            for(int i = 0; i < n; i++){
                
                trace += mat[i][i];
                
            }
            
            int sum = n*(n+1)/2;
            int totalRow = 0;
            int totalColumn = 0;
            
            for(int i = 0; i < n; i++){
                int row = 0;
                int column = 0;
                for(int j = 0; j < n; j++){
                    row += mat[i][j];
                    column += mat[j][i];
                }
                if (row != sum)
                    totalRow++;
                if(column != sum)
                    totalColumn++;
                
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + totalRow + " " + totalColumn);
            
            
        }
      }
    }