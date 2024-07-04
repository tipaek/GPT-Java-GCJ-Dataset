import java.util.*;
import java.io.*;

public class Solution
{
   public static void main(String[] args) throws IOException
   {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));                                         
      StringTokenizer star = new StringTokenizer(bf.readLine());
      int N = Integer.parseInt(star.nextToken());
      for(int case_num = 1; case_num <= N; case_num++) {
         star = new StringTokenizer(bf.readLine());
         String s = star.nextToken();
         int[] count = new int[s.length()];
         for(int i = 0; i < s.length(); i++) {
            count[i] = Integer.parseInt(s.substring(i, i + 1));
         }
         
         String new_string = "";
         new_string += new String(new char[count[0]]).replace("\0", "(") + count[0];
         for(int i = 1; i < count.length; i++) {
            if((count[i - 1] - count[i]) < 0) {
               new_string += new String(new char[count[i] - count[i - 1]]).replace("\0", "(") + count[i];
            } else {
               new_string += new String(new char[count[i - 1] - count[i]]).replace("\0", ")") + count[i];
            }
         }
         new_string += new String(new char[count[count.length - 1]]).replace("\0", ")");
      
         System.out.println("Case #" + case_num + ": " + new_string);
      }    
   }
   
   
   // public static boolean finished(int[] count) {
      // for(int i = 0; i < count.length; i++)
         // if(count[i] != 0)
            // return false;
      // return true;
   // }
}