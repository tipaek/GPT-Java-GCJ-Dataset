import java.util.*;
import java.io.*;

class Solution{
  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      char[] input;
      StringBuilder sb ;
      int i , j;
      char last;
      for( i = 1 ; i <= test ; i++){
        input = br.readLine().toCharArray();
        sb = new StringBuilder("");

        if(input[0] == '1')
         sb.append("(1");
        else
         sb.append('0');

         for(j = 1 ; j < input.length ; j++){
           if(input[j] == '1' && input[j - 1] == '1')
             sb.append('1');
           else if(input[j] == '1' && input[j - 1] == '0')
             sb.append("(1");
          else if(input[j] == '0' && input[j - 1] == '1')
             sb.append(")0");
           else
             sb.append("0");
         }
         if(input[j - 1] == '1')
           sb.append(")");
           System.out.println("Case #" + i + ": " + sb);
           //Case #1:
      }
  }
}
