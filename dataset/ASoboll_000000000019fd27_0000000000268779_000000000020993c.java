import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args){
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));

    Solver solver = new Solver();
    solver.solve(in, out);
    out.close();
  }

  static class Solver {

    InputReader in;
    PrintWriter out;
    final int NMax = 100;

    public void solve(InputReader in, PrintWriter out) {
      this.in = in;
      this.out = out;

      int[][] m = new int[NMax][NMax];

      int T = in.readInt();
      for (int i = 1; i <= T; i++){ // i-th case
        int N = in.readInt();
        in.readMatrix(N, N, m);

        int tr = 0;
        int r = 0;
        int c = 0;

        for (int j = 0; j < N; j++){
          tr += m[j][j];
          if (!distinct(m, N, j, 0, 0, 1)) r++;
          if (!distinct(m, N, 0, 1, j, 0)) c++;
        }

        out.print(String.format("Case #%s: %s %s %s\n", i, tr, r, c));
      }
    }

    private boolean distinct(int[][] m, int N, int x, int xi, int y, int yi){
      boolean[] exist = new boolean[N+1];
      for (int i = 0; i < N; i++){
        int q = m[x][y];
        if (exist[q]) return false;
        exist[q] = true;
        x += xi;
        y += yi;
      }
      return true;
    }
  }


  static class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      this.reader = new BufferedReader(new InputStreamReader(stream));
    }

    public String read() {
      try {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
          tokenizer = new StringTokenizer(reader.readLine());
        }
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
      return tokenizer.nextToken();
    }

    public int readInt() {
      return Integer.parseInt(read());
    }

    public long readLong() {
      return Long.parseLong(read());
    }

    public void readMatrix(int rows, int columns, int[]... arrays) {
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
          arrays[i][j] = readInt();
        }
      }
    }
  }
}
