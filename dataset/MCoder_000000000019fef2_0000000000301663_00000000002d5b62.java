
import java.io.*;
import java.util.*;

public class Solution
{
  private static int t;
  private static int task;
  private static Scanner in;
  private static String[][] ps;

  public static void main(String[] args) throws Exception
  {
    in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    t = in.nextInt();
    init();
    for (int i = 1; i <= t; ++i)
    {
      task = i;
      solve();
    }
  }

  private static void solve()
  {
    int x = in.nextInt();
    int y = in.nextInt();
    String path = ps[Math.abs(x)][Math.abs(y)];
    if (path == null)
    {
      System.out.println("Case #" + task + ": IMPOSSIBLE");
      return;
    }
    if (x < 0)
    {
      path = path.replace('W', 'T');
      path = path.replace('E', 'W');
      path = path.replace('T', 'E');
    }
    if (y < 0)
    {
      path = path.replace('S', 'T');
      path = path.replace('N', 'S');
      path = path.replace('T', 'N');
    }
    System.out.println("Case #" + task + ": " + path);
  }

  private static void init()
  {
    long[][] f = new long[101][101];
    ps = new String[101][101];
    nextStep(f, ps, 0, 0, 0, "");
  }

  static void nextStep(long[][] f, String[][] p, int depth, long posx, long posy, String path)
  {
    if (depth > 16)
      return;
    if (depth > 0 && posx >= 0 && posx <= 100 && posy >= 0 && posy <= 100)
    {
      if (f[(int) posx][(int) posy] == 0 || f[(int) posx][(int) posy] > depth)
      {
        f[(int) posx][(int) posy] = depth;
        ps[(int) posx][(int) posy] = path;
      }
    }

    for (int i = 0; i < 3; i++)
    {
      int step = (int) Math.pow(2, depth);
      // 0N, 1E, 2S, 3W
      if (i == 0)
      {
        // posy += step;
        // path += "N";
        nextStep(f, p, depth + 1, posx, posy + step, path + "N");
      }
      if (i == 1)
      {
        // posx += step;
        // path += "E";
        nextStep(f, p, depth + 1, posx + step, posy, path + "E");
      }
      if (i == 2)
      {
        // posy -= step;
        // path += "S";
        nextStep(f, p, depth + 1, posx, posy - step, path + "S");
      }
      if (i == 3)
      {
        // posx -= step;
        // path += "W";
        nextStep(f, p, depth + 1, posx - step, posy, path + "W");
      }

    }
  }

  private static void checkMax(int[][] f, int depth, int posx, int posy, String path)
  {
    if (posx >= 0 && posx <= 100 && posy >= 0 && posy <= 100)
    {
      if (f[posx][posy] == 0 || f[posx][posy] > depth)
      {
        f[posx][posy] = depth + 1;
        ps[posx][posy] = path;
      }
    }
  }
}