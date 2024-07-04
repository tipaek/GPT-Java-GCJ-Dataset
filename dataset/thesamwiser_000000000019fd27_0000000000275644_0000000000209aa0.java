
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

  // Indicium (sorry for the approach)
  public static void main(String[] args) throws Exception {
    final InputReader in = new InputReader(System.in);
    final OutputWriter out = new OutputWriter(System.out);
    Locale.setDefault(Locale.US);
    int T = in.readInt();
    for (int t = 1; t <= T; t++) {
      // read
      final int N = in.readInt();
      final int K = in.readInt();
      final int N2 = N * N;

      // calc sol
      boolean possible =
          (K == N || K == N2 || (N == 3 && K == 6) || (N > 3 && K >= N + 2 && K <= N2 - 2));

      // print
      out.printLine(nthcase(t) + " " + (possible ? "POSSIBLE" : "IMPOSSIBLE"));
      if (possible) {
        if (K % N == 0) {
          int[][] sol = new int[N][N];
          int multiple = K / N;
          for (int r = 0; r < N; r++) {
            sol[r][0] = multiple;
            for (int c = 1; c < N; c++) {
              sol[r][c] = (((multiple - 1 + c) % N) + 1);
            }
            multiple = multiple == 1 ? N : multiple - 1;
          }
          printSol(out, N, K, sol);
        } else if (N == 4 && K == 10) {
          printSol(out, N, K, generate(N, 2, 3, 3));
        } else if (N + 2 == K) {
          printSol(out, N, K, generate(N, 1, 2, 2));
        } else if (K == N2 - 2) {
          printSol(out, N, K, generate(N, N, N - 1, N - 1));
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
          printSol(out, N, K, sol);
        }
      }
    }
    out.close();
  }

  static void printSol(OutputWriter out, int N, int K, int[][] sol) {
    boolean[][] rowSet = new boolean[N][N];
    boolean[][] colSet = new boolean[N][N];
    int sum = sol[0][0];
    for (int r = 0; r < N; r++) {
      out.print(sol[r][0]);
      for (int c = 1; c < N; c++) {
        out.print(" " + sol[r][c]);
        if (rowSet[r][sol[r][c] - 1]) {
          throw new RuntimeException("duplicate row");
        }
        if (colSet[c][sol[r][c] - 1]) {
          throw new RuntimeException("duplicate col");
        }
        if (r == c) {
          sum += sol[r][c];
        }
        rowSet[r][sol[r][c] - 1] = colSet[c][sol[r][c] - 1] = true;
      }
      out.printLine();
    }
    if (sum != K) {
      out.flush();
      throw new RuntimeException("k not correct, got " + sum + " expected " + K);
    }
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


  // generate latin square.
  // make sure that K == (ax * N-2) + bx + cx
  static int[][] generate(int N, int ax, int bx, int cx) {
    int[][] mat = new int[N][N];
    int todo = N * (N - 1);
    long[] rowMask = new long[N];
    long[] colMask = new long[N];
    // set b
    mat[0][0] = bx;
    rowMask[0] = colMask[0] = (1L << (bx - 1));
    // set c
    mat[1][1] = cx;
    rowMask[1] = colMask[1] = (1L << (cx - 1));
    // set a
    for (int i = 2; i < N; i++) {
      mat[i][i] = ax;
      rowMask[i] |= (1L << (ax - 1));
      colMask[i] |= (1L << (ax - 1));
    }
    int[] usageCount = new int[N];
    while (todo-- > 0) {
      int bestR = 0, bestC = 0;
      int leastPos = N + 1;
      int firstPos = -1;
      for (int r = 0; r < N; r++) {
        for (int c = 0; c < N; c++) {
          if (mat[r][c] > 0) {
            continue;
          }
          long mask = rowMask[r] | colMask[c];
          int posLeft = 0;
          int curFpos = -1;
          for (int l = 0; l < N; l++) {
            if ((mask & (1L << l)) == 0) {
              if (curFpos < 0 || usageCount[l] > usageCount[curFpos]) {
                curFpos = l;
              }
              if (++posLeft == leastPos) {
                break;
              }
            }
          }
          if (posLeft == 0) {
            throw new RuntimeException("failed to generate matrix, todo: " + todo + " for " + N
                + " (" + ax + ", " + bx + ", " + cx + ")");
          }
          if (posLeft < leastPos) {
            leastPos = posLeft;
            bestR = r;
            bestC = c;
            firstPos = curFpos;
          }
        }
      }
      mat[bestR][bestC] = firstPos + 1;
      rowMask[bestR] |= (1L << firstPos);
      colMask[bestC] |= (1L << firstPos);
      usageCount[firstPos]++;
    }
    return mat;
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
