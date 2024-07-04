import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author Hieu Le
 */
public class Solution {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    SquareDance solver = new SquareDance();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++) solver.solve(i, in, out);
    out.close();
  }

  static class SquareDance {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int R = in.nextInt();
      int C = in.nextInt();

      int[][] skills = new int[R][C];
      for (int r = 0; r < R; ++r) {
        for (int c = 0; c < C; ++c) {
          skills[r][c] = in.nextInt();
        }
      }

      long interest = 0;
      boolean battled = true;
      while (battled) {
        interest += sum(skills);

        int[][] next = new int[R][C];

        battled = false;
        for (int r = 0; r < R; ++r) {
          for (int c = 0; c < C; ++c) {
            next[r][c] = skills[r][c];
            if (!survive(skills, r, c)) {
              battled = true;
              next[r][c] = 0;
            }
          }
        }

        skills = next;
      }

      out.printf("Case #%d: %d\n", testNumber, interest);
    }

    private boolean survive(int[][] skills, int r, int c) {
      if (skills[r][c] == 0) {
        return true;
      }

      int a0 = find(skills, r, c, 0, 1);
      int a1 = find(skills, r, c, 1, 0);
      int a2 = find(skills, r, c, -1, 0);
      int a3 = find(skills, r, c, 0, -1);

      int count = 0;
      if (a0 > 0) ++count;
      if (a1 > 0) ++count;
      if (a2 > 0) ++count;
      if (a3 > 0) ++count;

      if (count == 0) return true;

      return count * skills[r][c] >= (a0 + a1 + a2 + a3);
    }

    private int find(int[][] skills, int row, int col, int dr, int dc) {
      int R = skills.length, C = skills[0].length;
      int r = row + dr, c = col + dc;

      while (r >= 0 && r < R && c >= 0 && c < C) {
        if (skills[r][c] > 0) return skills[r][c];
        r += dr;
        c += dc;
      }

      return 0;
    }

    private long sum(int[][] skills) {
      long result = 0;
      for (int r = 0; r < skills.length; ++r) {
        for (int c = 0; c < skills[r].length; ++c) {
          result += skills[r][c];
        }
      }

      return result;
    }
  }

  static class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private static final int BUFFER_SIZE = 32768;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), BUFFER_SIZE);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }
  }
}
