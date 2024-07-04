import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  private static Scanner scanner;

    private static String merge(String s1, String s2) {
      if(s1 == null) return null;
      int s1c = s1.indexOf('*');
      int s2c = s2.indexOf('*');
      if(s1c == -1 && s2c == -1) {
        if(s1.equals(s2)) return s1;
        else return null;
      } else if(s1c == -1) {
        String s2l = s2.substring(0, s2c);
        String s2r = s2.substring(s2c+1);
        if(s1.startsWith(s2l) && s1.startsWith(s2r) && s1.length() >= s2l.length() + s2r.length()) {
          return s1;
        } else return null;
      } else if(s2c == -1) {
        String s1l = s1.substring(0, s1c);
        String s1r = s1.substring(s1c+1);
        if(s2.startsWith(s1l) && s2.startsWith(s1r) && s2.length() >= s1l.length() + s1r.length()) {
          return s2;
        } else return null;
      } else {
        String s2l = s2.substring(0, s2c);
        String s2r = s2.substring(s2c+1);
        String s1l = s1.substring(0, s1c);
        String s1r = s1.substring(s1c+1);
//        System.out.println(s1 + " : " + s2 + " : " + s1l + " : " + s1r + " : " + s2l + " : " + s2r);
        String l = null;
        if(s1l.length() > s2l.length()) {
          if(s1l.startsWith(s2l)) l = s1l;
        } else {
          if(s2l.startsWith(s1l)) l = s2l;
        }
        if(l == null) return null;
//        System.out.println(l);
        l += '*';
        if(s1r.length() > s2r.length()) {
          if(s1r.endsWith(s2r)) l += s1r;
          else l = null;
        } else {
          if(s2r.endsWith(s1r)) l += s2r;
          else l = null;
        }
        return l;
      }
    }

//  private static String merge(String s1, String s2) {
//    String[][] mem = new String[s1.length()][s2.length()];
//    for(int i=s1.length()-1; i>=0; i--) {
//      for(int j=s2.length()-1; j>=0; j--) {
//        boolean b = s1.charAt(i) == s2.charAt(j);
//        boolean bs = s1.charAt(i) == '*' && s2.charAt(j) == '*';
//        if(i == s1.length()-1 && j == s2.length()-1) {
//          if(bs) {
//            mem[i][j] = "*";
//          } else if(s1.charAt(i) == '*') {
//            mem[i][j] = "*" + s2.charAt(j);
//          } else if(s2.charAt(j) == '*') {
//            mem[i][j] = "*" + s1.charAt(i);
//          } else {
//            if(b) mem[i][j] = "" + s1.charAt(i);
//            else mem[i][j] = null;
//          }
//        } else if(i == s1.length()-1) {
//          String cs = s2.substring(j);
//          if(s1.charAt(i) == '*') mem[i][j] = cs;
//          else {
//            String ns = cs.replace("*", "");
//            if(ns.length() == 0 || (ns.length() == 1 && ns.charAt(0) == s1.charAt(i))) {
//              mem[i][j] = "" + s1.charAt(i);
//            } else {
//              mem[i][j] = null;
//            }
//          }
//        } else if(j == s2.length()-1) {
//          String cs = s1.substring(i);
//          if(s2.charAt(j) == '*') mem[i][j] = cs;
//          else {
//            String ns = cs.replace("*", "");
//            if(ns.length() == 0 || (ns.length() == 1 && ns.charAt(0) == s2.charAt(j))) {
//              mem[i][j] = "" + s2.charAt(j);
//            } else {
//              mem[i][j] = null;
//            }
//          }
//        } else {
//          if(s1.charAt(i) != '*' && s2.charAt(j) != '*') {
//            if(mem[i+1][j+1] != null && b) {
//              mem[i][j] = "" + s1.charAt(i) + mem[i+1][j+1];
//            } else {
//              mem[i][j] = null;
//            }
//          } else if(bs) {
//
//          } else if(s1.charAt(i) == '*') {
//            String res = null;
//            for(int k=j; k<s2.length(); k++) {
//              if(mem[])
//            }
//          } else {
//
//          }
//        }
//      }
//    }
//    return mem[0][0];
//  }

  private static void process(int tid) {
    int n = Integer.parseInt(scanner.nextLine());
    String[] ps = new String[n];
    String res = "*";
    for (int i = 0; i < n; i++) {
      ps[i] = scanner.nextLine();
    }

    for(int i=0; i<n; i++) {
      res = merge(res, ps[i]);
//      System.out.println(res);
    }
    if(res == null) {
      System.out.printf("Case #%d: %s\n", tid, "*");
    } else {
      StringBuilder r = new StringBuilder();
      for(char c : res.toCharArray()) {
        if(c != '*') r.append(c);
      }
      System.out.printf("Case #%d: %s\n", tid, r.toString());
    }
  }

  public static void main(String[] args) {
    scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(scanner.nextLine());
    for(int i=1; i<=t; i++) {
      process(i);
    }
  }

}
