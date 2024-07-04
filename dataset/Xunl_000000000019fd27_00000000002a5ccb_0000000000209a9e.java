import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    int b = in.nextInt();
    for (int i = 1; i <= t; ++i) {
        Set<String> stringSet = solveten(in);
        for (String s : stringSet) {
            System.out.println(s);
            System.out.flush();
            String ch = in.next();
            if (ch.compareTo("Y") == 0) {
                break;
            } else {
                for (int i = 0; i< 10; ++i){
                    System.out.println();
                    System.out.flush();
                }
            }
        }
    }
  }
  
  private static Set<String> solveten(Scanner in) {
      Set<String> testSet = new HashSet();
      String s1 = readTen(in);
      testSet.add(s1);
      String s2 = readTen(in);
      while(s2.compareTo(s1) == 0){
          s2 = readTen(in);
      }
      testSet.add(s2);
      if (s1.compareTo(getMirror(s2)) == 0) {
          testSet.add(getComp(s1));
          testSet.add(getComp(s2));
      } else if (s1.compareTo(getComp(s2)) == 0) {
          testSet.add(getMirror(s1));
          testSet.add(getMirror(s2));
      } else {
          testSet.add(getComp(s1));
          testSet.add(getMirror(s1));
      }
      return testSet;
  }
  
  private static String readTen(Scanner in) {
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i <= 10; ++i) {
          System.out.println(i);
          System.out.flush();
          sb.append(in.nextInt());
      }
      return sb.toString();
  }
  
  private static String getMirror(String s) {
      StringBuilder sb = new StringBuilder(s);
      return sb.reverse().toString();
  }
  
  private static String getComp(String s) {
      StringBuilder sb = new StringBuilder();
      for (char c : s.toCharArray()) {
          if (c == '1') {
              sb.append('0');
          } else {
              sb.append('1');
          }
      }
      return s.toString();
  }
}