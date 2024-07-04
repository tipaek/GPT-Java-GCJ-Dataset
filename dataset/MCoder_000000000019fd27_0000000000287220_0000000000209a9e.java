import java.io.*;
import java.util.*;

public class Solution
{
  private static int t;
  private static int task;
  private static Scanner in;
  private static int b;

  public static void main(String[] args) throws Exception
  {
    // System.out.println("Hello CJ");
    in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    t = in.nextInt();
    b = in.nextInt();
    for (int i = 1; i <= t; ++i)
    {
      task = i;
      solve();
    }
  }

  private static void solve()
  {
    char[] ca = new char[b];
    for (int i = 1; i <= b; i++)
    {
      System.out.println(i);
      String s = in.next();
      if ("N".equals(s))
        System.exit(0);
      ca[i - 1] = s.charAt(0);
    }
    String res = new String(ca);

    System.out.println(res);
    String ans = in.next();
    if ("N".equals(ans))
      System.exit(0);
  }
}