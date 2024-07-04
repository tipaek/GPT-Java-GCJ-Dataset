
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int _t = 0; _t < t; _t++) {

      int n = sc.nextInt();
      Map<Integer, Integer> map = new TreeMap<>();
      for (int _n=0; _n<n; _n++) {
        map.put(sc.nextInt(), sc.nextInt());
      }
      System.out.printf("Case #%d: ", _t + 1);
      doit(map);
      System.out.printf("%n");
    }
  }

  static void doit(Map<Integer, Integer> jobs) {

    Optional<Map.Entry<Integer, Integer>> p1 = Optional.empty(), p2 = Optional.empty();

    StringBuilder workers = new StringBuilder();

    Iterator<Map.Entry<Integer, Integer>> it = jobs.entrySet().iterator();
    while (it.hasNext()) {
      final Map.Entry<Integer, Integer> next = it.next();
      if (!p1.isPresent()) {
        p1 = Optional.of(next);
        workers.append("C");
      } else if (!p2.isPresent()) {
        p2 = Optional.of(next);
        workers.append("J");
      } else {
        int start = next.getKey();
        if (p1.get().getValue() <= start) {
          p1 = Optional.of(next);
          workers.append("C");
        } else if (p2.get().getValue() <= start) {
          p2 = Optional.of(next);
          workers.append("J");
        } else {
          System.out.print("IMPOSSIBLE");
          return;
        }
      }
    }
    System.out.printf("%s", workers);

  }
}
