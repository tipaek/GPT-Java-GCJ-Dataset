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
    int[][] m = new int[n][n];
    for (int r = 0; r < n; r++)
    {

      for (int c = 0; c < n; c++)
      {
        m[r][c] = in.nextInt();
      }
    }

    // loop rows
    int rowDouble = 0;
    for (int r = 0; r < n; r++)
    {
      Set<Integer> d = new HashSet<>();
      for (int c = 0; c < n; c++)
      {
        int check = m[r][c];
        if (d.contains(check))
        {
          rowDouble++;
          break;
        }
        else
          d.add(check);
      }
    }
    // loop cols
    int colDouble = 0;
    for (int c = 0; c < n; c++)
    {
      Set<Integer> d = new HashSet<>();
      for (int r = 0; r < n; r++)
      {
        int check = m[r][c];
        if (d.contains(check))
        {
          colDouble++;
          break;
        }
        else
          d.add(check);
      }
    }
    int trace = 0;
    for (int i = 0; i < n; i++)
    {
      trace += m[i][i];
    }

    System.out.println("Case #" + task + ": " + trace + " " + rowDouble + " " + colDouble);
  }
}