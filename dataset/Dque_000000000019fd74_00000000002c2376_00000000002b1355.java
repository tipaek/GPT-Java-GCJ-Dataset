//make sure to make new file!
import java.io.*;
import java.util.*;

public class Solution{
   
   public static void main(String[] args)throws IOException{
      BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(System.out);
      
      int t = Integer.parseInt(f.readLine());
      
      for(int q = 1; q <= t; q++){
      
         StringTokenizer st = new StringTokenizer(f.readLine());
      
         int n = Integer.parseInt(st.nextToken());
         int m = Integer.parseInt(st.nextToken());
      
         long[][] matrix = new long[n][m];
         
         //long answer = 0L;
         for(int k = 0; k < n; k++){
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < m; j++){
               matrix[k][j] = Long.parseLong(st.nextToken());
               //answer += matrix[k][j];
            }
         }
         
         
         long[][] left = new long[n][m];
         long[][] up = new long[n][m];
         long[][] down = new long[n][m];
         long[][] right = new long[n][m];
         
         for(int k = 0; k < n; k++){
            for(int j = 0; j < m; j++){
               if(k > 0){
                  left[k][j] = matrix[k-1][j];
               } else {
                  left[k][j] = -1;
               }
               if(k < n-1){
                  right[k][j] = matrix[k+1][j];
               } else {
                  right[k][j] = -1;
               }
               if(j > 0){
                  up[k][j] = matrix[k][j-1];
               } else {
                  up[k][j] = -1;
               }
               if(j < m-1){
                  down[k][j] = matrix[k][j+1];
               } else {
                  down[k][j] = -1;
               }
            }
         }
         
         boolean stop = false;
         
         long answer = 0L;
         while(!stop){
            stop = true;
            
            boolean[][] remove = new boolean[n][m];
            //sum
            for(int k = 0; k < n; k++){
               for(int j = 0; j < m; j++){
                  if(matrix[k][j] == 0) continue;
                  answer += matrix[k][j];
                  
                  long sum = 0L;
                  long i = 0L;
                  if(left[k][j] != -1){
                     sum+=left[k][j];
                     i++;
                  }
                  if(right[k][j] != -1){
                     sum+=right[k][j];
                     i++;
                  }
                  if(up[k][j] != -1){
                     sum+=up[k][j];
                     i++;
                  }
                  if(down[k][j] != -1){
                     sum+=down[k][j];
                     i++;
                  }
                  
                  if(i > 0 && matrix[k][j]*i < sum){
                     remove[k][j] = true;
                     matrix[k][j] = 0;
                     stop = false;
                  }
                  
               }
            }
            
            for(int k = 0; k < n; k++){
               for(int j = 0; j < m; j++){
                  if(remove[k][j]){
                     if(k < n-1){
                        left[k+1][j] = left[k][j];
                     }
                     if(j < m-1){
                        up[k][j+1] = up[k][j];
                     }
                  }
               }
            }
                     
            for(int k = n-1; k >= 0; k--){
               for(int j = m-1; j >= 0; j--){
                  if(remove[k][j]){
                     if(k > 0){
                        right[k-1][j] = right[k][j];
                     }
                     if(j > 0){
                        down[k][j-1] = down[k][j];
                     }
                  }
               }
            }
            
         }
            
            
          out.println("Case #" + q + ": " + answer);  
            
                     

      }
      
      
      
      
      out.close();
   }
   
   public static class Point{
      int x;
      int y;
      public Point(int a, int b){
         x = a;
         y = b;
      }
   }
      
      
}