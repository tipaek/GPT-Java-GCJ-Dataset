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
         
         String new_string = s;
         int char_offset = 0;
         while(!finished(count)) {
            for(int i = 0; i < count.length; i++) {
               if(count[i] == 0)
                  continue;
               else {
                  int start_index = i;
                  int end_index = start_index;
                  new_string = new_string.substring(0, start_index + char_offset) + "(" + new_string.substring(start_index + char_offset, new_string.length());
                  char_offset++;
                  for(int j = start_index; j < count.length; j++) {
                     if(count[j] > 0) {
                        count[j] -= 1;
                        end_index ++;
                     } else
                        break;
                  }
                  new_string = new_string.substring(0, end_index + char_offset) + ")" + new_string.substring(end_index + char_offset, new_string.length());
                  char_offset++;
               }
            }
         }
                  
         System.out.println("Case #" + case_num + ": " + new_string);
      }    
   }
   
   
   public static boolean finished(int[] count) {
      for(int i = 0; i < count.length; i++)
         if(count[i] != 0)
            return false;
      return true;
   }
}