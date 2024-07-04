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
         String s = "";
         boolean impossible = false;
         for(int i = 1; i <= N; i++) {
            star = new StringTokenizer(bf.readLine());
            String line = star.nextToken();
            line = line.substring(1);
            if(s.indexOf(line) != -1) {
               continue;
            } else if(line.indexOf(s) != -1) {
               s = line;
            } else {
               impossible = true;
            }
         }
              
         if(impossible) {
            s = "*";
         }
         System.out.println("Case #" + case_num + ": " + s);
      }    
   }
}