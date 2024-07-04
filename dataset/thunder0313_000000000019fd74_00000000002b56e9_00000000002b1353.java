import java.util.*;
import java.io.*;

public class Solution
{
   public static void main(String[] args) throws IOException
   {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));                                         
      StringTokenizer star = new StringTokenizer(bf.readLine());
      int cases = Integer.parseInt(star.nextToken());
      for(int case_num = 1; case_num <= cases; case_num++) {
         star = new StringTokenizer(bf.readLine());
         int N = Integer.parseInt(star.nextToken());
         int limit = 500;
         System.out.println("Case #" + case_num + ":");

         if(N > limit) {
            int difference = N - limit;
            int last_row = 0;
            
            System.out.println(1 + " 1");
            System.out.println(2 + " 1");
            for(int i = 3; i <= (difference + 2); i++) {
               System.out.println(i + " 2");
               last_row = i;
            }
            for(int i = last_row; i <= (N - last_row + 1); i++) {
               System.out.println(i + " 1");
            }
         } else {
            for(int i = 1; i <= N; i++) {
               System.out.println(i + " 1");
            }
         }
      }    
   }
}