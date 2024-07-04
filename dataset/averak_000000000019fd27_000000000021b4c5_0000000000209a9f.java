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
    System.out.println(s);
    char[] a = s.toCharArray();
    StringBuilder res = new StringBuilder();
    if (a[0] != '0') {
      int y = a[0] - '0';
      appendCount(y, true, res);
      res.append(a[0]);
      //count = a[0];
    } else {
      res.append("0");
    }
    for (int i = 1; i < a.length; i++) {
      if (a[i] == a[i - 1]) {
        res.append(a[i]);
        continue;
      }
      int a0 = a[i - 1] - '0';
      int a1 = a[i] - '0';
      if (a1 > a0) {
        res.append(a[i]);
        appendCount(a1 - a0, true, res);
      } else {
        appendCount(a0 - a1, false, res);
        //appendCount(a[i], true, res);
        res.append(a[i]);
      }
    }
    appendCount(a[a.length - 1] - '0', false, res);
    System.out.println("Case #" + num + ": " + res.toString());
  }

  private  static  void appendCount(int n, boolean isOpen, StringBuilder s) {

    for (int i = 0; i < n; i++) {
      if (isOpen) {
          s.append("(");
        } else {
          s.append(")");
        }
    }
  }
}
    