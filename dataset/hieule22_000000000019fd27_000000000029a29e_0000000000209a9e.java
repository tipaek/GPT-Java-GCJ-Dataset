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
    Database solver = new Database();
    solver.solve(1, in, out);
    out.close();
  }

  static class Database {
    private static final int MAX_QUERIES = 150;
    private static final int EPOCH_LENGTH = 10;
    private InputReader in;
    private PrintWriter out;
    private int counter = 0;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
      this.in = in;
      this.out = out;
      int numTests = in.nextInt();
      int length = in.nextInt();

      for (int t = 0; t < numTests; ++t) {
        go(length);
      }
    }

    private void go(int length) {
      counter = 0;
      int[] values = new int[length];

      boolean[] same = new boolean[(length + 1) / 2];

      int yes = -1, no = -1;
      int pointer = 0;
      for (int epoch = 0; epoch < MAX_QUERIES / EPOCH_LENGTH; ++epoch) {
        int q = EPOCH_LENGTH;
        if (yes > -1) {
          int curr = read(yes);
          --q;

          if (values[yes] != curr) {
            for (int i = 0; i < pointer; ++i) {
              if (same[i]) {
                values[i] = values[length - i - 1] = 1 - values[i];
              }
            }
          }
        }

        if (no > -1) {
          int curr = read(no);
          --q;

          if (values[no] != curr) {
            for (int i = 0; i < pointer; ++i) {
              if (!same[i]) {
                values[i] = 1 - values[i];
                values[length - i - 1] = 1 - values[length - i - 1];
              }
            }
          }
        }

        if (q % 2 == 1) {
          read(1);
          --q;
        }

        while (q > 0) {
          if (pointer == same.length) {
            break;
          }

          values[pointer] = read(pointer);
          values[length - pointer - 1] = read(length - pointer - 1);
          q -= 2;
          same[pointer] = (values[pointer] == values[length - pointer - 1]);
          if (same[pointer]) {
            yes = pointer;
          } else {
            no = pointer;
          }
          ++pointer;
        }

        if (pointer == same.length) {
          break;
        }
      }

      StringBuilder sb = new StringBuilder();
      for (int value : values) {
        sb.append(value);
      }

      out.println(sb.toString());
      out.flush();

      if (!in.next().equals("Y")) {
        throw new RuntimeException();
      }
    }

    private int read(int n) {
      ++counter;
      if (counter > MAX_QUERIES) {
        throw new RuntimeException();
      }

      out.println(n + 1);
      out.flush();
      return in.nextInt();
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
