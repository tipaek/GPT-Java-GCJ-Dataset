import java.util.*;
import java.io.*;
    class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          Integer[][] m = new Integer[n][n];
          Integer[][] m_inverse = new Integer[n][n];
          for (int j = 0; j < n; ++j) {
            for (int k = 0; k < n; ++k) {
              m[j][k] = in.nextInt();
              m_inverse[k][j] = m[j][k];
            }
          }

          // Calculate Diagnoal Sum
          int k = m[0][0];
          for (int j = 1; j < n; ++j) {
            k += m[j][j];
          }

          int r = 0;
          for (int j = 0; j < n; ++j) {
            ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(m[j]));
            Set<Integer> s = new HashSet<Integer>(a);
            if (s.size() < n) {
              r++;
            }
          }

          int c = 0;
          for (int j = 0; j < n; ++j) {
            ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(m_inverse[j]));
            Set<Integer> s = new HashSet<Integer>(a);
            if (s.size() < n) {
              c++;
            }
          }

          System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
      }
    }