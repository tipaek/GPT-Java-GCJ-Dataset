import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;
import java.util.Locale;

public class Solution {

  static final String[] exception = {"2, 4, 3, 1", "1, 3, 4, 2", "3, 1, 2, 4", "4, 2, 1, 3"};

  // Indicium
  public static void main(String[] args) throws Exception {
    final InputReader in = new InputReader(System.in);
    final OutputWriter out = new OutputWriter(System.out);
    Locale.setDefault(Locale.US);
    int T = in.readInt();
    for (int t = 1; t <= T; t++) {
      // read
      int N = in.readInt();
      int K = in.readInt();

      // calc sol
      boolean possible = (K == N || (K >= N + 3 && K <= (N * N) - 3) || K == N * N);

      // print
      out.printLine(nthcase(t) + " " + (possible ? "POSSIBLE" : "IMPOSSIBLE"));
      if (possible) {
        if (K % N == 0) {
          int multiple = K / N;
          for (int r = 0; r < N; r++) {
            out.print(multiple);
            for (int c = 1; c < N; c++) {
              out.print(" " + (((multiple - 1 + c) % N) + 1));
            }
            out.printLine();
            multiple = multiple == 1 ? N : multiple - 1;
          }
        } else if (N == 4 && K == 10) {
          for (int r = 0; r < N; r++) {
            out.printLine(exception[r]);
          }
        } else {
          // lookup
          int[][] sol = new int[N][N];
          for (int r = 0; r < N; r++) {
            int actualRow = r + 1;
            if (actualRow == N) {
              actualRow--;
            } else if (actualRow == N - 1) {
              actualRow++;
            }
            for (int c = 0; c < N; c++) {
              sol[r][c] = (((actualRow - 1 - c + N) % N) + 1);
            }
          }
          int[] res = find(N, K);
          // swap1
          swap(sol, res[0], sol[0][0]);
          swap(sol, res[1], sol[N - 1][N - 1]);
          swap(sol, res[2], sol[N - 2][N - 2]);
          for (int r = 0; r < N; r++) {
            out.print(sol[r][0]);
            for (int c = 1; c < N; c++) {
              out.print(" " + sol[r][c]);
            }
            out.printLine();
          }
        }
      }
    }
    out.close();
  }

  static String nthcase(int t) {
    return "Case #" + t + ":";
  }

  static void swap(int[][] sol, int a, int b) {
    if (a == b) {
      return;
    }
    for (int r = 0; r < sol.length; r++) {
      for (int c = 0; c < sol.length; c++) {
        if (sol[r][c] == a) {
          sol[r][c] = b;
        } else if (sol[r][c] == b) {
          sol[r][c] = a;
        }
      }
    }
  }

  static int[] find(int N, int K) {
    for (int a = 1; a <= N; a++) {
      for (int b = 1; b <= N; b++) {
        if (b == a) {
          continue;
        }
        for (int c = b + 1; c <= N; c++) {
          if (c == a) {
            continue;
          }
          if (K == a * (N - 2) + b + c) {
            return new int[] {a, b, c};
          }
        }
      }
    }
    return null;
  }

  static void test() {
    // test
    for (int i = 4; i <= 50; i++) {
      System.err.println("processing " + i);
      boolean[] mustReach = new boolean[i * i];
      for (int a = 1; a <= i; a++) {
        for (int b = 1; b <= i; b++) {
          if (b == a) {
            continue;
          }
          for (int c = b + 1; c <= i; c++) {
            if (c == a) {
              continue;
            }
            mustReach[a * (i - 2) + b + c] = true;
          }
        }
      }
      for (int t = i + 3; t < (i * i) - 3; t++) {
        if (!mustReach[t]) {
          System.err.println("failed to reach " + t);
        }
      }
    }

  }

  static class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
      this.stream = stream;
    }

    public int read() {
      if (numChars == -1)
        throw new InputMismatchException();
      if (curChar >= numChars) {
        curChar = 0;
        try {
          numChars = stream.read(buf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (numChars <= 0)
          return -1;
      }
      return buf[curChar++];
    }

    public char readChar() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      return (char) c;
    }

    public String readLine() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      StringBuilder res = new StringBuilder();
      do {
        res.appendCodePoint(c);
        c = read();
      } while (!isEndOfLine(c));
      return res.toString();
    }

    public String readString() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      StringBuilder res = new StringBuilder();
      do {
        res.appendCodePoint(c);
        c = read();
      } while (!isSpaceChar(c));
      return res.toString();
    }

    public long readLong() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = read();
      }
      long res = 0;
      do {
        if (c < '0' || c > '9')
          throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
    }

    public int readInt() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = read();
      }
      int res = 0;
      do {
        if (c < '0' || c > '9')
          throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
    }

    public boolean isSpaceChar(int c) {
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public boolean isEndOfLine(int c) {
      return c == '\n' || c == '\r' || c == -1;
    }
  }

  static class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
      writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
      this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
      for (int i = 0; i < objects.length; i++) {
        if (i != 0)
          writer.print(' ');
        writer.print(objects[i]);
      }
    }

    public void printLine(Object... objects) {
      print(objects);
      writer.println();
    }

    public void flush() {
      writer.flush();
    }

    public void close() {
      writer.close();
    }
  }
}
