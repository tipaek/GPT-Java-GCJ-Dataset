import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int  i= 1; i <= t; ++i) {
      String s=in.next();
      StringBuilder sb=new StringBuilder();
      String[] open={"","(","((","(((","((((","(((((","((((((","(((((((","((((((((",
      "((((((((("};
      String[] close={"",")","))",")))","))))",")))))","))))))",")))))))","))))))))"
      ,")))))))))"};
      int c=0;
      int o=0;
      for(int j=0;j<s.length();j++){
          int m=Integer.parseInt(String.valueOf(s.charAt(j)));
          if(o < m){
              sb.append(open[m-o]);
              o+=m-o;
          }else if(o > m){
              sb.append(close[o-m]);
              o-=o-m;
          }
          sb.append(m);
      }
      sb.append(close[o]);
      System.out.println("Case #" + i + ": " + sb.toString());
    }
  }
}