//package Q2020.nestingdepth;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 1; i <= t; i++) {
      String s = sc.next();
      StringBuffer ans = new StringBuffer();
      for(char c : s.toCharArray()) {
        if( c == '0')
          ans.append(c);
        else {
          int repeat = c - '0';
          ans.append(repeatChar("(", repeat)).append(c).append(repeatChar(")", repeat));
        }
      }
      boolean flag = true;
      String ansS = ans.toString();
      while(flag) {
        int oldlen = ansS.length();
        ansS = ansS.replaceAll("\\)\\(", "" );
        flag = ansS.length() != oldlen;
      }
      System.out.println(String.format("Case #%d: %s",i, ansS));
    }
    sc.close();
  }

  private static String repeatChar(String s, int repeat) {
    String ss = "";
    for(int i=0;i<repeat;i++)
      ss += s;
    return ss;
  }

}