
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    int t1 = t;
    while(t-- > 0) {
      int u = scanner.nextInt();
      HashSet<Character> set = new HashSet<>();
      HashSet<Character> nonZero = new HashSet<>();
      for (int i = 0; i < 10000; i++) {
        int qi = scanner.nextInt();
        String r = scanner.next();
        for (int j = 0; j < r.length(); j++) {
          if (j == 0) {
            nonZero.add(r.charAt(j));
          }
          set.add(r.charAt(j));
        }
      }
      Iterator<Character> val = set.iterator();
      StringBuilder ans = new StringBuilder();
      while(val.hasNext()) {
        char c = val.next();
        if (nonZero.contains(c)) {
          ans.append(c);
          set.remove(c);
          break;
        }
      }
      val = set.iterator();
      while(val.hasNext()) {
        ans.append(val.next());
      }
      System.out.println("Case #"+ (t1-t) + ": " + ans.toString());
    }
  }
}
