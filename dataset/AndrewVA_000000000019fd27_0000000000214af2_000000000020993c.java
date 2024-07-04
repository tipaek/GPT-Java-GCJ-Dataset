import java.io.*;
import java.util.*;

public class Solution
{
   public static void main(String[] args) throws IOException
   {
      Scanner sc = new Scanner(System.in);
      int t = Integer.parseInt(sc.nextLine());
      for(int i = 1;i <= t; i++){
         int n = sc.nextInt();
         int[][] data = new int[n][n];
         int sum = 0;
         int rcount = 0;
         for(int j = 0; j < n; j++){
            ArrayList<Integer> row = new ArrayList(n);
            boolean repeat = false;
            for(int k = 0; k < n; k++){
                data[j][k] = sc.nextInt();
                if(row.contains(data[j][k])){
                    repeat = true;
                }
                else{
                    row.add(data[j][k]);
                }
                if(j == k){
                    sum += data[j][k];
                }
            }
            if(repeat){
               rcount++;
            }
         }
         int ccount = 0;
         for(int j = 0; j < n; j++){
            ArrayList<Integer> col = new ArrayList(n);
            boolean repeat = false;
            for(int k = 0; k < n; k++){
                if(col.contains(data[k][j])){
                    repeat = true;
                }
                else{
                    col.add(data[k][j]);
                }
            }
            if(repeat){
               ccount++;
            }
         }
         System.out.println("Case #" + i + ": " + sum + " " + rcount + " " + ccount);
      }
   }
}