import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

  private static Scanner scanner;

  private static void process(int tid) {
    int n = scanner.nextInt();
    List<int[]> l = new ArrayList<>();
    for(int i=0; i<n; i++) {
      int s = scanner.nextInt();
      int e = scanner.nextInt();
      int[] se = new int[]{s, e, i};
      l.add(se);
    }
    l.sort((a, b) -> {
      if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
      return Integer.compare(a[0], b[0]);
    });

    char[] cs = new char[n];
    int c = -1, j = -1;
    for(int i=0; i<n; i++) {
      int[] cv = l.get(i);
      if(c <= cv[0]) {
        c = -1;
      }
      if(j <= cv[0]) {
        j = -1;
      }
      if(c == -1) {
        cs[cv[2]] = 'C';
        c = cv[1];
      } else if(j == -1) {
        cs[cv[2]] = 'J';
        j = cv[1];
      } else {
        System.out.printf("Case #%d: %s\n", tid, "IMPOSSIBLE");
        return;
      }
    }
    System.out.printf("Case #%d: %s\n", tid, new String(cs));
  }

  public static void main(String[] args) {
    scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = scanner.nextInt();
    for(int i=1; i<=t; i++) {
      process(i);
    }
  }

}
