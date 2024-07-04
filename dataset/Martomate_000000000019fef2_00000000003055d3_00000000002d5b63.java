import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

  static class Point {
    int x, y;
  }

  public static void main(String[] args) {
    Kattio io = new Kattio(System.in);

    int T = io.getInt();
    int A = io.getInt();
    int B = io.getInt();

    ArrayList<Point> centerPoints = new ArrayList<>();
    for (int x = -50; x <= 50; x++) {
      for (int y = -50; y <= 50; y++) {
        Point p = new Point();
        p.x = x;
        p.y = y;
        centerPoints.add(p);
      }
    }

    centerPoints.sort(Comparator.comparing(p -> Math.sqrt(p.x * p.x + p.y * p.y)));

    for (int tc = 0; tc < T; tc++) {
      boolean inCenter = false;
      int mode = 0;
      int cIdx = 0;
      int sx = -1;
      int sy = -1;
      int cx = 0;
      int cy = 0;
      while (!inCenter) {
        int xi = 0, yi = 0;
        if (mode == 2) {
          xi = centerPoints.get(cIdx).x + cx;
          yi = centerPoints.get(cIdx).y + cy;
          cIdx++;
        } else {
          if (mode == 0) {
            sx++;
            xi = sx - 1000000000;
            yi = 0;
          } else if (mode == 1) {
            sy++;
            xi = 0;
            yi = sy - 1000000000;
          }
        }
        io.println(xi + " " + yi);
        io.flush();
        switch (io.getWord()) {
          case "CENTER":
            inCenter = true;
            break;
          case "HIT":
            if (mode == 0) { // sx done
              mode = 1;
            } else if (mode == 1) { // sy done
              mode = 2;
              cx = sx - (1000000000 - A);
              cy = sy - (1000000000 - A);
            }
            break;
          case "MISS":
            break;
          case "WRONG":
            io.close();
            System.err.println("WRONG!!!!");
            return;
        }
      }
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
