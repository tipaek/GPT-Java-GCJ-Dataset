import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(final String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int T = Integer.valueOf(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
          final String S = in.nextLine();
          final int N = S.length();
          final StringBuilder SB = new StringBuilder(N);
          int prev = '0';
          for (int i = 0; i < N; i++) {
            int curr = S.charAt(i);
            int diff = curr - prev;
            char paran;
            if (diff < 0) {
              paran = ')';
              diff = -diff;
            } else
              paran = '(';
            for (int c = 0; c < diff; c++)
              SB.append(paran);
            SB.append(S.charAt(i));
            prev = curr;
          }
          final int diff = prev-'0';
          for(int c=0;c<diff;c++)
            SB.append(')');
          System.out.println("Case #" + t + ": " +SB.toString());
        }
      }
    }