import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    for(int i = 0; i < t; ++i) {
      String ipStr = sc.nextLine();
      StringBuilder sb = new StringBuilder();
      int strLen = ipStr.length();
      int startingFrom = 0;
      int startIndex = 0, endIndex;
      while (startIndex < strLen) {
        endIndex = ipStr.indexOf('0', startingFrom);
        if(endIndex == -1) {
          break;
        }
        if(startIndex == endIndex) {
          sb.append('0');
        } else {
          sb.append("(").append(ipStr, startIndex, endIndex).append(")").append('0');
        }
        startIndex = endIndex + 1;
        startingFrom = endIndex + 1;
      }
      if(startIndex < strLen) {
        sb.append("(").append(ipStr, startIndex, strLen).append(")");
      }
      System.out.println("Case #" + (i + 1) + " " + sb.toString());
    }
  }
}