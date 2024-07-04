import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  private static Scanner scanner;

  private static void process(int tid) {
    StringBuilder sb = new StringBuilder();
    String s = scanner.next();
    int cd = 0;
    for(int i=0; i<s.length(); i++) {
      int c = (s.charAt(i) - '0');
      if(c > cd) {
        int d = c - cd;
        for(int j=0; j<d; j++) {
          sb.append('(');
        }
      } else {
        int d = cd - c;
        for(int j=0; j<d; j++) {
          sb.append(')');
        }
      }
      sb.append(c);
      cd = c;
    }
    while(cd != 0) {
      sb.append(')');
      cd--;
    }

    System.out.printf("Case #%d: %s\n", tid, sb.toString());
  }

  public static void main(String[] args) {
    scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = scanner.nextInt();
    for(int i=1; i<=t; i++) {
      process(i);
    }
  }

}
