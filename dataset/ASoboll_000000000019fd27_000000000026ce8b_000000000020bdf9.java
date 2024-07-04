import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
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

    final int NMax = 1000;
    int[] s = new int[NMax];
    int[] f = new int[NMax];
    char[] assign = new char[NMax];
    Integer[] order = new Integer[NMax];

    public void solve(InputReader in, PrintWriter out) {
      this.in = in;
      this.out = out;


      int T = in.readInt();
      for (int caseI = 1; caseI <= T; caseI++){
        int N = in.readInt();

        for (int i = 0; i < N; i++){
          s[i] = in.readInt();
          f[i] = in.readInt();
          assign[i] = 'U';
          order[i] = i;
        }

        Arrays.sort(order, 0, N, Comparator.comparingInt(z -> s[z]));
        int c = 0;
        int j = 0;
        boolean impossible = false;

        for (int i = 0; i < N; i++){
          int q = order[i];
          if (c <= s[q]) {
            assign[q] = 'C';
            c = f[q];
          }
          else if (j <= s[q]) {
            assign[q] = 'J';
            j = f[q];
          }
          else {
            impossible = true;
            break;
          }
        }

        if (impossible) {
          out.print(String.format("Case #%s: %s\n", caseI, "IMPOSSIBLE"));
        } else {
          StringBuilder r = new StringBuilder();
          for (int i = 0; i < N; i++){
            r.append(assign[i]);
          }
          out.print(String.format("Case #%s: %s\n", caseI, r.toString()));
        }
      }
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

    public void readIntArrays(int[]... arrays) {
      for (int i = 0; i < arrays[0].length; i++) {
        for (int j = 0; j < arrays.length; j++) {
          arrays[j][i] = readInt();
        }
      }
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
