import java.util.*; 

public class Solution {
  static int UNKNOWN = 0, CAMERON = 1, JAMIE = 2;
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in); 

    int numT = in.nextInt(); 
    for(int t=0; t<numT; t++) {
      int n = in.nextInt();

      // greedily assign to the first person
      Range[] ranges = new Range[n];
      for(int i=0; i<n; i++) {
        int s = in.nextInt();
        int e = in.nextInt(); 
        ranges[i] = new Range(s, e, i);
      }

      Arrays.sort(ranges);
      int cameronEnd = 0;
      int jamieEnd = 0;
      boolean impossible = false;
      int[] ans = new int[n];
      for(int i=0; i<n; i++) {
        // Greedy. Try Cameron first. If not, then Jamie
        if(ranges[i].s >= cameronEnd) {
          ranges[i].who = CAMERON;
          ans[ranges[i].id] = CAMERON;
          cameronEnd = ranges[i].e;
        } else {
          // Try Jamie.
          // If impossible, then it's impossible.
          if(ranges[i].s < jamieEnd) {
            impossible = true;
            break;
          }
          ranges[i].who = JAMIE;
          ans[ranges[i].id] = JAMIE;
          jamieEnd = ranges[i].e;
        }
      }

      if(impossible) {
        System.out.printf("Case #%d: IMPOSSIBLE\n", t+1);
      } else {
        System.out.printf("Case #%d: ", t+1);
        for(int i=0; i<n; i++) {
          System.out.print( (ans[i] == CAMERON) ? 'C' : 'J');
        }
        System.out.println();
      }

    }
  }
  static class Range implements Comparable<Range> {
    public int s, e, id, who;
    public Range(int S, int E, int Id) {
      s = S; e = E; id = Id; who = UNKNOWN;
    }
    public int compareTo(Range o) {
      if(s != o.s) return Integer.compare(s, o.s);
      return Integer.compare(e, o.e);
    }
  }

}

/* 

4
3
360 480
420 540
600 660
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440

Case #1: CJC
Case #2: IMPOSSIBLE
Case #3: JCCJJ
Case #4: CC


*/