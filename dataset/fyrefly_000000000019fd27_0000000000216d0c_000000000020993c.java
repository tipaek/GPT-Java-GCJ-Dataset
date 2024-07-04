import java.util.Scanner;
import java.io.*;
public class Solution {
   public static void main (String[]args) {
      Scanner scan = new Scanner(System.in);
      int t = scan.nextInt();
      for(int tn = 1; tn <= t; tn++) {
         int n = scan.nextInt();
         int k = 0, r = 0, c = 0;
         int[][] nums = new int[n][n];
         for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
               nums[i][j] = scan.nextInt();
         for(int i = 0; i < n; i++) k += nums[i][i];
         
         int temp;
         boolean mbreak = false;
         for(int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
               temp = nums[i][j];
               for (int a = j + 1; a < n; a++)
                  if(temp == nums[i][a]) {
                     r++;
                     mbreak = true;
                     break;
                  }
               if(mbreak) break;
            }
            
         for(int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
               temp = nums[j][i];
               for (int a = j + 1; a < n; a++)
                  if(temp == nums[a][i]) {
                     c++;
                     mbreak = true;
                     break;
                  }
               if(mbreak) break;
            }
         
         String output = "Case #" + tn + ": " + k + " " + r + " " + c;
         try {
            PrintWriter writer = new PrintWriter(System.out);
            writer.write(output + "\n");
            writer.flush();
         } catch (Exception e) {
            System.out.println(e);
         }
      }
   }
}