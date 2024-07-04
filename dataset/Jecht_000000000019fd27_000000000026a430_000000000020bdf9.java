import java.util.*;
import java.io.*;
public class Solution {
  static class Act {
      int start;
      int end;
      Act(int start, int end) {
          this.start = start;
          this.end = end;
      }
      
      boolean overlaps(Act act) {
          return (act.start < end && act.start >= start)
          || (act.end > start && act.start < start);
      }
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
        int n = in.nextInt();
        Act[] acts = new Act[n];
        for(int j = 0; j < n; j++) {
            acts[j] = new Act(in.nextInt(), in.nextInt());
        }
        process(i, acts, n);
    }
  }
  
  private static void process(int kase, Act[] acts, int n) {
      StringBuilder sb = new StringBuilder();
      List<Act> cActs = new ArrayList<>();
      List<Act> jActs = new ArrayList<>();
      for(Act act : acts) {
          if(!overlaps(cActs, act)) {
              cActs.add(act);
              sb.append('C');
          } else if(!overlaps(jActs,act)) {
              jActs.add(act);
              sb.append('J');
          } else {
              sb = new StringBuilder("IMPOSSIBLE");
              break;
          }
      }
      System.out.printf("Case #%d: %s\n", kase, sb.toString());
  }
  private static boolean overlaps(List<Act> acts, Act target) {
      return acts
        .stream()
        .parallel()
        .anyMatch(act -> act.overlaps(target));
  }
}