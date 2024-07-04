import java.io.*;
import java.util.*;


class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testCases = in.nextInt();
    for(int t=1;t<=testCases;t++) {
      StringBuilder result = new StringBuilder();
      int openBraces = 0;
      String str = in.next();
      for(int i=0;i<str.length();i++) {
        int num = Integer.parseInt(""+str.charAt(i));
        if(openBraces < num) {
          for(int j=openBraces; j<num;j++) {
            openBraces++;
            result.append("(");
          }
        }else {
          for(int j=openBraces; j>num;j--) {
            openBraces--;
            result.append(")");
          }
        }
        result.append(num);
      }
      for(int i=0;i<openBraces;i++) {
        result.append(")");
      }
      System.out.println("Case #" + t +": "+result.toString());
    }
  }
}
