import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();
    for (int i = 0; i < T; i ++) {
        String bracket = depth(in.next());
        System.out.println("Case #" + (i + 1) + ": " + bracket);
    }
  }
  public static String depth(String query) {
      String number = "";
      String bracket = "";
      String prev = "";
      String temp = Character.toString(query.charAt(0));
      int i = 0, n = query.length();
      while (i < n) {
          if (n == 0) {
              bracket = generateBracket(bracket, prev, temp, temp);
              break;
          }
          else if (!temp.equals(Character.toString(query.charAt(i)))) {
              bracket = generateBracket(bracket, prev, temp, number);
              prev = temp;
              temp = Character.toString(query.charAt(i));
              number = "";
          } else {
              number += query.charAt(i);
              i ++;
              if (i == n) {
                  bracket = generateBracket(bracket, prev, temp, number);
              }
          }
      }
      n = Integer.parseInt(temp);
      bracket = addClose(n, bracket);
      return bracket;
  }
  
  public static String generateBracket(String b, String p, String t, String n) {
      int l;
      if (b.length() > 0) {
          int last = Integer.parseInt(p);
          l = Integer.parseInt(t);
          if (last > l) {
              int no = last - l;
              b = addClose(no, b);
              b += n;
          } else {
             l = Integer.parseInt(t);
              b = addOpen(l, b);
              b += n; 
          }
      } else {
          l = Integer.parseInt(t);
          b = addOpen(l, b);
          b += n;
      }
      return b;
  }
  
  public static String addOpen(int n, String b) {
      for (int i = 0; i < n; i ++) {
          b += '(';
      }
      return b;
  }
  
  public static String addClose(int n, String b) {
      for (int i = 0; i < n; i ++) {
          b += ')';
      }
      return b;
  }
}