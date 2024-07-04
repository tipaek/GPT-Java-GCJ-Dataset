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
      int N = io.getInt();

      PriorityQueue<Period> pq = new PriorityQueue<>((p1, p2) -> {
        int res = p1.t1 - p2.t1;
        if (res == 0) res = p1.t2 - p2.t2;
        return res;
      });

      Period[] periods = new Period[N];
      for (int i = 0; i < N; i++) {
        int t1 = io.getInt();
        int t2 = io.getInt();
        pq.add(periods[i] = new Period(i, t1, t2));
      }

      int J = 0, C = 0;
      StringBuilder result = new StringBuilder();

      while (!pq.isEmpty()) {
        Period p = pq.poll();

        if (J <= p.t1) {
          p.person = 'J';
          J = p.t2;
        } else if (C <= p.t1) {
          p.person = 'C';
          C = p.t2;
        } else {
          result = null;// it's ugly, but it works
          break;
        }
      }

      if (result != null) {
        for (int i = 0; i < N; i++) {
          result.append(periods[i].person);
        }
      }

      io.printf("Case #%d: %s\n", tc+1, result != null ? result.toString() : "IMPOSSIBLE");
    }

    io.close();
  }

  static class Period {
    int i;
    int t1, t2;
    char person;

    Period(int i, int t1, int t2) {
      this.i = i;
      this.t1 = t1;
      this.t2 = t2;
    }
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
