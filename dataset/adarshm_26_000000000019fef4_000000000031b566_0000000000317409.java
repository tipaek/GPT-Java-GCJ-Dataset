import java.io.InputStream;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
  public static void main(String[] args) throws IOException {
    InputReader in = new InputReader(System.in);
    PrintWriter pw = new PrintWriter(System.out);

    int t, x, y, min, tx, ty, xh;
    int[] m;
    char[] path;
    t = in.nextInt();
    for (int i = 1; i <= t; i++) {
      x = in.nextInt();
      y = in.nextInt();
      path = in.next().toCharArray();
      m = new int[path.length + 1];
      min = Integer.MAX_VALUE;
      m[0] = x + y;
      tx = x;
      ty = y;
      xh = -1;
      for (int j = 0; j < path.length; j++) {
        if(path[j] == 'N') ty++;
        else if(path[j] == 'S') ty--;
        else if(path[j] == 'E') tx++;
        else tx--;
        m[j + 1] = Math.abs(tx) + Math.abs(ty);
      }
      for (int j = 0; j < m.length; j++) {
        if(m[j] < min && j >= m[j]) {
          min = m[j];
          xh = j;
          break;
        }
      }
      if(xh == -1) pw.println("Case #" + i + ": IMPOSSIBLE");
      else pw.println("Case #" + i + ": " + xh);
    }
    pw.close();
  }

  static class InputReader {
    BufferedReader br;
    StringTokenizer st;

    public InputReader(InputStream inputStream) {
      br = new BufferedReader(new InputStreamReader(inputStream));
      st = null;
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}
