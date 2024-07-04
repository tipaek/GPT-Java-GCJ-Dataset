//make sure to make new file!
import java.io.*;
import java.util.*;
//Vestigium
public class Solution{
   
   public static void main(String[] args)throws IOException{
      BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(System.out);
      
      int t = Integer.parseInt(f.readLine());
      
      for(int q = 1; q <= t; q++){
      
         int n = Integer.parseInt(f.readLine());
         
         int[][] matrix = new int[n][n];
         
         for(int k = 0; k < n; k++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0; j < n; j++){
               matrix[k][j] = Integer.parseInt(st.nextToken());
            }
         }
         
         int sum = 0;
         int r = 0;
         int c = 0;
         for(int k = 0; k < n; k++){
            sum += matrix[k][k];
            if(!checkr(matrix,k)) r++;
            if(!checkc(matrix,k)) c++;
            
         }
         
         
         out.println("Case :" + t + ": " + sum + " " + r + " " + c);
      
      }
      
      
      
      
      out.close();
   }
   
   public static boolean checkr(int[][] matrix, int i){
      
      HashSet<Integer> hset = new HashSet<Integer>();
      for(int k = 0; k < matrix.length; k++){
         if(hset.contains(matrix[i][k])) return false;
         hset.add(matrix[i][k]);
      }
      
      return true;
   }
   public static boolean checkc(int[][] matrix, int i){
      
      HashSet<Integer> hset = new HashSet<Integer>();
      for(int k = 0; k < matrix.length; k++){
         if(hset.contains(matrix[k][i])) return false;
         hset.add(matrix[k][i]);
      }
      
      return true;
   }
   
      
}