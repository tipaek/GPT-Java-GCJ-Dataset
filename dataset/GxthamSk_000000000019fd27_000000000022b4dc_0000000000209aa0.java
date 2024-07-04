import java.util.*;
    import java.io.*;
    public class Solution {
      
      

      
      public static boolean check(int[][] matrix, int k){
        boolean answer = false;
        int sum = 0;
          for(int i = 0; i < matrix.length; i++){
            sum += matrix[i][i];
          }
         if(sum == k) answer = true;



        sum = 0;
        int count = 0;
         for(int i = matrix.length-1; i>= 0; --i){
            sum += matrix[count++][i];
         }
         if(sum == k) answer = true;
         return answer;
      }
      public static boolean generate(int[][] matrix, int n, int k){
        int count = n+1;
        for(int i=1; i <= n; i++){
          int row = 0;
          int t= count;
          while(t <= n){
            matrix[i-1][row++] = t;
            t++;
          }
          for(int j=1; j<count;j++){
            matrix[i-1][row++] = j;
          }
          count--;
        }


        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
          list.add(matrix[i]);
        }

        if(check(matrix,k)) return true;
    
        else return false;
      }
      
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int m = in.nextInt();
          int[][] matrix = new int[n][n];
           //generate(matrix, n, m);
          if(!generate(matrix,n,m)){
            System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
          }else{
            System.out.println("Case #" + i + ": " + "POSSIBLE");
            for(int r=0; r < n; r++){
              for(int c = 0; c < n;c++){
                if(c < n-1)System.out.print(matrix[r][c] + " ");
                else System.out.print(matrix[r][c]);
              }
              System.out.println();
            }
          }
          
          
        }
      }
}