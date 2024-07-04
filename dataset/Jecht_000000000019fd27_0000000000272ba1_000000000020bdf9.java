import java.util.*;
import java.io.*;
public class Solution {
  static class Act implements Comparable<Act> {
      int start;
      int end;
      Act(int start, int end) {
          this.start = start;
          this.end = end;
      }
      
    //   boolean overlaps(Act act) {
    //       return (act.start < end && act.start >= start)
    //       || (act.end > start && act.start < start);
    //   }
      
      public int compareTo(Act target) {
          return start - target.start;
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
      List<Act> actList = new ArrayList<>();
      for(Act act : acts) actList.add(act);
      Collections.sort(actList);
      int cNext = 0, jNext = 0;
      Set<Act> cActs = new HashSet<>();
      Set<Act> jActs = new HashSet<>();
      boolean complete = true;
      for(Act act : actList) {
          if(cNext <= act.start) {
              cActs.add(act);
              cNext = act.end;
          } else if(jNext <= act.start) {
              jActs.add(act);
              jNext = act.end;
          } else {
              complete = false;
              break;
          }
      }
      StringBuilder sb = new StringBuilder();
      if(complete) {
          for(Act act : acts) {
              if(cActs.contains(act)) {
                  sb.append('C');
              } else {
                  sb.append('J');
              }
          }
      } else {
          sb.append("IMPOSSIBLE");
      }
      
      
      System.out.printf("Case #%d: %s\n", kase, sb.toString());
  }
}