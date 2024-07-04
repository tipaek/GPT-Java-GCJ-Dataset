import java.util.*;
import java.io.*;
public class Solution{
   public static void main(String[] main) throws Exception{
      Scanner s = new Scanner(System.in);
      int t = s.nextInt();
      for(int trial = 1; trial <= t; trial++){
         String st = s.next();
         for(int i = 0; i < st.length(); i++)
            if(st.charAt(i) == '1'){
               if(i == 0 || st.charAt(i-1) == '0')
                  st = st.substring(0,i) + '(' + st.substring(i);
               if(i == st.length() - 1 || st.charAt(i+1) == '0')
                  st = st.substring(0,i+1) + ')' + st.substring(i+1);
            }
         System.out.println("Case #" + trial + ": " + st);
      }
   }
}