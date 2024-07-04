
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
    int n = in.nextInt();
    // if (n <= 500)
    // {
    // solveSmall(n);
    // return;
    //
    // }
    System.out.println("Case #" + task);
    System.out.println(1 + " " + 1);

    int st = (int) (-1d + (Math.sqrt(1d + 8d * (n - 1)))) / 2;
    for (int i = 0; i < st; i++)
    {
      System.out.println(i + 2 + " " + 2);
    }

    int row = st + 1;
    int rest = n - ((st * st + st) / 2 + 1);
    for (int i = 0; i < rest; i++)
    {
      System.out.println(i + row + " " + 1);
    }
  }

  private static void solveSmall(int n)
  {
    System.out.println("Case #" + task);
    for (int i = 1; i <= n; i++)
    {
      System.out.println(i + " " + 1);
    }
  }
}