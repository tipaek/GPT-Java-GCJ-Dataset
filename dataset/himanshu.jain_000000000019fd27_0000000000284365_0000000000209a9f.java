import java.util.*;
import java.io.*;
public class Solution {

      
 public static void main(String[] args) {
     
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for (int m = 1; m <= t; ++m) {
       String S = in.nextLine();
       int len = S.length();
       char[] sc = S.toCharArray();
       StringBuilder sb = new StringBuilder();
       int i = 0;
       while(i < len) {
           int cur = (int)(sc[i]-48);
           int next = i+1 < len ? (int)(sc[i+1]-48) : -1;
           int prev = i > 0 ? (int)(sc[i-1]-48) : -1;
           
           int open = prev == -1 ? cur : Math.abs(prev-cur);
           while(open > 0) {
               sb.append("(");
               open--;
           }
           
           sb.append(cur);
           i = i+1;
           while(i < len && cur >= next && next != -1) {
               if(cur > next) {
                   int diff = cur - next;
                   while(diff > 0) {
                       sb.append(")");
                       diff--;
                   }
               }
               sb.append(next);
               cur = next;
               i = i + 1;
               next = i < len ? (int)(sc[i]-48) : -1;
           }
           
           if(i == len-1 || next == -1) {
               int close = cur;
               while(close > 0) {
                   sb.append(")");
                   close--;
               }
           }
       }
       
       System.out.println("Case #"+m+": "+sb.toString());
    }
  }
  
}