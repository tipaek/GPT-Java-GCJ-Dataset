import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    LOOP:
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      Pair[] activities = new Pair[n];
      for(int j=0;j<n;j++)
      {
          activities[j] = new Pair(in.nextInt(),in.nextInt(),j);
      }
      Arrays.sort(activities, new Comparator<Pair>() {
   @Override
   public int compare(Pair p1, Pair p2) {
       return p1.s-p2.s;
   }
});
        int cfree =0;
        int jfree =0;
        char[] out = new char[n];
        for(int j=0;j<n;j++)
        {
            int s = activities[j].s;
            int e = activities[j].e;
            int pos = activities[j].pos;
            if(s>=cfree)
            {
                out[pos] = 'C';
                cfree = e;
                continue;
            }
            if(s>=jfree)
            {
                out[pos] = 'J';
                jfree = e;
                continue;
            }
            System.out.println("Case #" + i + ": IMPOSSIBLE");
            continue LOOP;
        }
      System.out.println("Case #" + i + ": " + new String(out));
    }
  }
  static class Pair
    {
        public Pair(int a,int b,int c)
        {
            s=a;e=b;pos = c;
        }
    private int s;
    private int e;
    private int pos;
    }
}