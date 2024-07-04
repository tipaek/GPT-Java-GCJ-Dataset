import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();

      Point[] p = new Point[n*2];
      
      for(int j=0; j<n; j++) {
          p[j*2] = new Point(j, in.nextInt(), false);
          p[j*2+1] = new Point(j, in.nextInt(), true);
      }
      
      Arrays.sort(p);
      int actC = -1;
      int actJ = -1;
      
      StringBuilder result = new StringBuilder();
      for(int j=0; j<n; j++) result.append("C");
      
      for(int j=0; j<2*n; j++) {
          if(p[j].isEnd) {
              if(actC == p[j].index) actC = -1;
              else actJ = -1;
          }
          else {
              if(actC == -1) {
                  actC = p[j].index;
              }
              else if(actJ == -1) {
                  actJ = p[j].index;
                  result.setCharAt(p[j].index, 'J');
              }
              else {
                  result = new StringBuilder("IMPOSSIBLE ");
                  break;
              }
          }
      }
      
      System.out.println("Case #" + i + ": " + result.toString());
    }
  }

    static class Point implements Comparable<Point> {
        public int index;
        public int value;
        public boolean isEnd;

        public Point(int i, int v, boolean isEnd) {
            index = i;
            value = v;
            this.isEnd = isEnd;
        }

        @Override
        public int compareTo(Point p2) {
            if(this.value == p2.value) {
                if(this.isEnd == p2.isEnd) return 0;
                return this.isEnd ? -1 : 1;
            }

            return this.value < p2.value ? -1 : 1;
        }
    }
}