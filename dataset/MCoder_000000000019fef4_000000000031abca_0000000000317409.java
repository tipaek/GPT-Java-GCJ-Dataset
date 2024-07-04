import java.io.*;
import java.util.*;

public class Solution
{
  private static int t;
  private static int task;
  private static Scanner in;

  public static void main(String[] args) throws Exception
  {
    in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    t = in.nextInt();
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
    String m = in.next();
    char[] mc = m.toCharArray();
    // build p pos array

    Pos[] ppos = new Pos[mc.length + 1];
    ppos[0] = new Pos(0, x, y);
    for (int i = 1; i <= mc.length; i++)
    {
      if (mc[i - 1] == 'N')
        ppos[i] = new Pos(i, ppos[i - 1].x, ppos[i - 1].y + 1);
      else if (mc[i - 1] == 'E')
        ppos[i] = new Pos(i, ppos[i - 1].x + 1, ppos[i - 1].y);
      else if (mc[i - 1] == 'S')
        ppos[i] = new Pos(i, ppos[i - 1].x, ppos[i - 1].y - 1);
      else if (mc[i - 1] == 'W')
        ppos[i] = new Pos(i, ppos[i - 1].x - 1, ppos[i - 1].y);
    }
    int t = Integer.MAX_VALUE;
    for (int i = 0; i < ppos.length; i++)
    {

      if (ppos[i].getDiff() <= ppos[i].time)
        t = Math.min(t, ppos[i].time);
    }

    if (t < Integer.MAX_VALUE)
      System.out.println("Case #" + task + ": " + t);
    else
      System.out.println("Case #" + task + ": IMPOSSIBLE");
  }
}

class Pos
{

  public Pos(int time, int x, int y)
  {
    super();
    this.time = time;
    this.x = x;
    this.y = y;
  }

  int time;
  int x;
  int y;

  int getDiff()
  {
    return Math.abs(x) + Math.abs(y);
  }
}