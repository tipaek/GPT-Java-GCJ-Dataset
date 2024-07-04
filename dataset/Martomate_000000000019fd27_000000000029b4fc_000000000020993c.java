import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) {
    Kattio io = new Kattio(System.in);

    int T = io.getInt();
    for (int tc = 0; tc < T; tc++) {
      int N = io.getInt();
      int[][] M = new int[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          M[i][j] = io.getInt();
        }
      }

      int[] rowI = new int[N];
      int[] colI = new int[N];
      for (int i = 0; i < N; i++) {
        rowI[i] = -1;
        colI[i] = -1;
      }
      int countR = 0;
      int countC = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          int r = M[i][j] - 1;
          if (rowI[r] != i)
            rowI[r] = i;
          else {
            countR++;
            break;
          }
        }
      }
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          int c = M[j][i] - 1;
          if (colI[c] != i) colI[c] = i;
          else {
            countC++;
            break;
          }
        }
      }
      int trace = 0;
      for (int i = 0; i < N; i++) {
        trace += M[i][i];
      }

      io.println(String.format("Case #%d: %d %d %d\n", tc+1, trace, countR, countC));
    }

    io.close();
  }
}

class Kattio extends PrintWriter {
  public Kattio(InputStream i) {
    super(new BufferedOutputStream(System.out));
    r = new BufferedReader(new InputStreamReader(i));
  }
  public Kattio(InputStream i, OutputStream o) {
    super(new BufferedOutputStream(o));
    r = new BufferedReader(new InputStreamReader(i));
  }

  public boolean hasMoreTokens() {
    return peekToken() != null;
  }

  public int getInt() {
    return Integer.parseInt(nextToken());
  }

  public double getDouble() {
    return Double.parseDouble(nextToken());
  }

  public long getLong() {
    return Long.parseLong(nextToken());
  }

  public String getWord() {
    return nextToken();
  }



  private BufferedReader r;
  private String line;
  private StringTokenizer st;
  private String token;

  private String peekToken() {
    if (token == null)
      try {
        while (st == null || !st.hasMoreTokens()) {
          line = r.readLine();
          if (line == null) return null;
          st = new StringTokenizer(line);
        }
        token = st.nextToken();
      } catch (IOException e) { }
    return token;
  }

  private String nextToken() {
    String ans = peekToken();
    token = null;
    return ans;
  }
}
