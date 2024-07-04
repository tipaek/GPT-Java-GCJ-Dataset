import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    PascalWalk solver = new PascalWalk();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++) solver.solve(i, in, out);
    out.close();
  }

  static class PascalWalk {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt();
      List<PascalWalk.Position> walk = new ArrayList<>();

      for (int leftout = 0; leftout < 100; ++leftout) {
        int remain = n - leftout;
        if (remain % 2 == 0) {
          continue;
        }
        char[] s = (Integer.toBinaryString(remain)).toCharArray();

        int zeros = 0;
        for (char c : s) {
          if (c == '0') {
            ++zeros;
          }
        }

        if (leftout >= zeros) {
          String rep = Integer.toBinaryString(remain);
          for (int i = 0; i < leftout - zeros; ++i) {
            rep = "0" + rep;
          }
          s = rep.toCharArray();

          PascalWalk.Position current = new PascalWalk.Position(1, 1);
          for (int i = s.length - 1; i >= 0; --i) {
            walk.add(current);
            if (s[i] == '0') {
              if (current.col == 1) {
                current = new PascalWalk.Position(current.row + 1, 1);
              } else if (current.col == current.row) {
                current = new PascalWalk.Position(current.row + 1, current.col + 1);
              } else {
                throw new RuntimeException();
              }
            } else {
              if (current.col == 1) {
                for (int col = 2; col <= current.row; ++col) {
                  walk.add(new PascalWalk.Position(current.row, col));
                }
                current = new PascalWalk.Position(current.row + 1, current.row + 1);
              } else if (current.col == current.row) {
                for (int col = current.col - 1; col >= 1; --col) {
                  walk.add(new PascalWalk.Position(current.row, col));
                }
                current = new PascalWalk.Position(current.row + 1, 1);
              } else {
                throw new RuntimeException();
              }
            }
          }
          break;
        }
      }

      if (walk.isEmpty()) {
        throw new RuntimeException();
      }

      //        if (!validate(walk, n)) {
      //            throw new RuntimeException();
      //        }

      out.printf("Case #%d:\n", testNumber);
      for (PascalWalk.Position position : walk) {
        out.println(position.row + " " + position.col);
      }
    }

    static class Position {
      int row;
      int col;

      Position(int row, int col) {
        this.row = row;
        this.col = col;
      }
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
