import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int countTest = Integer.parseInt(in.nextLine());
    for (int i = 1; i <= countTest; i++) {
      String line = in.nextLine();
      calculate(line, i);
    }
  }

  public static void calculate(String s, int num) {
    char[] a = s.toCharArray();
    StringBuilder res = new StringBuilder();
    int count = 0;
    if (a[0] == '1') {
      res.append("(1");
      count++;
    } else {
      res.append("0");
    }
    for (int i = 1; i < a.length; i++) {
      if (a[i] == '1') {
        if (count == 0){
          res.append("(");
          count++;
        }
        res.append("1");
      } else {
        if (count == 1){
          res.append(")");
          count--;
        }
        res.append("0");
      }
    }
    if (a[a.length - 1] == '1') {
      res.append(")");
    }
    System.out.println("Case #" + num + ": " + res.toString());
  }
}
    