import java.util.*;
import java.io.*;

public class Solution {
  public static void main(final String[] args) throws Exception {
    final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    final int rr = in.nextInt();
    for (int t = 1; t <= rr; t++) {
      final int n = in.nextInt();
      final int d = in.nextInt();
      final HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
      for (int i = 0; i < n; i++) {
        final long temp = in.nextLong();
        if (!hm.containsKey(temp)) {
          hm.put(temp, 1);
        } else {
          hm.put(temp, hm.get(temp) + 1);
        }
      }

      int best = d - 1;
      a: for (final long key : hm.keySet()) {
        int count = hm.get(key);
        int kin = 0;
        if (count >= d) {
          best = Math.min(best, kin);
          continue;
        }
        final TreeSet<Long> ones = new TreeSet<Long>();
        final TreeSet<Long> twos = new TreeSet<Long>();
        for (final long temp : hm.keySet()) {
          if (temp > key && temp % key == 0)
            ones.add(temp);
          else if (temp > key)
            twos.add(temp);
        }
        for (final long temp : ones) {
          long j = temp;
          while (j > key) {
            if (j == key * 2)
              count += 2;
            else
              count++;
            kin++;
            j -= key;
            if (count >= d) {
              best = Math.min(best, kin);
              continue a;
            }
          }
        }
        for (final long temp : twos) {
          long j = temp;
          while (j > key) {
            count++;
            kin++;
            j -= key;
            if (count >= d) {
              best = Math.min(best, kin);
              continue a;
            }
          }
        }
      }
      System.out.println("Case #" + t + ": " + best);
    }
  }
}
