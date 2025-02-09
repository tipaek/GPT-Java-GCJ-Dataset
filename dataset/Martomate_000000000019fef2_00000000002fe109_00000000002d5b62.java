import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) {
    Kattio io = new Kattio(System.in);

    int T = io.getInt();

    for (int tc = 0; tc < T; tc++) {
      int x = io.getInt();
      int y = io.getInt();

      char xp = x > 0 ? 'E' : 'W';
      char xn = x > 0 ? 'W' : 'E';

      char yp = y > 0 ? 'N' : 'S';
      char yn = y > 0 ? 'S' : 'N';

      x = Math.abs(x);
      y = Math.abs(y);

      StringBuilder res = new StringBuilder();
      if (x % 2 == 1 && y % 2 == 1) {
        res = null;
      } else {
        while ((x | y) != 0) {
          boolean bothNext = x / 2 % 2 == y / 2 % 2;
          if (x % 2 == 1) {
            if (bothNext && y != 0) {
              x++;
              res.append(xn);
            }
            else {
              x--;
              res.append(xp);
            }
          } else if (y % 2 == 1) {
            if (bothNext && x != 0) {
              y++;
              res.append(yn);
            }
            else {
              y--;
              res.append(yp);
            }
          } else {
            res = null;
            break;
          }

          x >>= 1;
          y >>= 1;
        }
      }

      if (res == null) {
        res = new StringBuilder("IMPOSSIBLE");
      } else {
        char[] moves = res.toString().toCharArray();
        int xx = 0;
        int yy = 0;
        int mul = 1;
        for (char ch : moves) {
          switch (ch) {
            case 'W':
              xx -= mul;
              break;
            case 'E':
              xx += mul;
              break;
            case 'N':
              yy += mul;
              break;
            case 'S':
              yy -= mul;
              break;
          }
          mul *= 2;
        }
      }

      io.printf("Case #%d: %s\n", tc+1, res.toString());
    }

    io.print("\n  ");
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
