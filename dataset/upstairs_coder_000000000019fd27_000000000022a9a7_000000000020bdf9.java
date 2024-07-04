import java.util.*;
import java.io.*;
class Interval {
  public int start;
  public int end;
  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    // Scanner sc = new Scanner(new File("input.txt"));
    int T = sc.nextInt();    
    int c = 0;
    while (T-- > 0) {
      int N = sc.nextInt();
      List<Interval> input = new ArrayList<>();
      for (int i = 0; i < N; ++i) {
        int start = sc.nextInt();
        int end = sc.nextInt();
        input.add(new Interval(start, end));
      }
      List<Interval> C = new ArrayList<>(), J = new ArrayList<>();
      StringBuffer sb = new StringBuffer();
      for (Interval interval : input) {
        boolean overlap = false;
        for (Interval cInterval : C) {
          if (cInterval.end > interval.start && cInterval.start <= interval.end) {
            overlap = true;
            break;
          }
        }
        if (!overlap) {
          sb.append("C");
          C.add(interval);
          continue;
        }
        overlap = false;
        for (Interval jInterval : J) {
          if (jInterval.end > interval.start && jInterval.start <= interval.end) {
            overlap = true;
            break;
          }
        }
        if (!overlap) {
          sb.append("J");
          J.add(interval);
          continue;
        }
        sb = new StringBuffer("IMPOSSIBLE");
        break;
      }
      System.out.printf("Case #%d: %s\n", ++c, sb.toString());
    }
  }
}