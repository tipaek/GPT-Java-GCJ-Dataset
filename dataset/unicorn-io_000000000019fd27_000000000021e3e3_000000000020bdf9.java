
import java.util.*;

public class Solution {

  private static Scanner scn = new Scanner(System.in);

  public static void main(String[] args) {
    int tcases = scn.nextInt();
    int tcpy = tcases;
    while (tcases-- > 0) {
      int tasks = scn.nextInt();
      TreeMap<Integer, Integer> map = new TreeMap<>();
      int cend = 0;
      int jend = 0;
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < tasks; i++) {
        map.put(scn.nextInt(), scn.nextInt());
      }
      int old = 0;
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
          if (cend > entry.getKey()) {
            if (jend > entry.getKey()) {
              System.out.printf("Case #%d: IMPOSSIBLE\n", tcpy-tcases);
              old = 1;
              break;
            }
          }

          if (cend <= entry.getKey()) {
            stringBuilder.append("C");
            cend = entry.getValue();
          } else if (jend <= entry.getKey()) {
            stringBuilder.append('J');
            jend = entry.getValue();
          }
      }
      if (old == 0) System.out.printf("Case #%d: %s\n",tcpy-tcases, stringBuilder.toString());
    }
  }
}