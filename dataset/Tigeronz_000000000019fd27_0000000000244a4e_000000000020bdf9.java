import java.util.*;
import java.io.*;
public class Solution
{
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(in.readLine());
    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(in.readLine());
      boolean impossible = false;
      int[][] activities = new int[N][2];
      int[][] time = new int[1440][2];
      String[] overlaps = new String[N];
      for (int j = 0; j < N; j++)
      {
        String[] s = in.readLine().split(" ");
        activities[j][0] = Integer.parseInt(s[0]);
        activities[j][1] = Integer.parseInt(s[1]);
        boolean didOverlap = false;
        int actA = -1;
        int actB = -1;
        for (int k = activities[j][0]; k < activities[j][1]; k++)
        {
          if (time[k][0] ==0)
          {
            time[k][0]++;
            time[k][1] = j;
          }
          else if (time[k][0] == 1)
          {
            time[k][0]++;
            didOverlap = true;
            actA = time[k][1];
            actB = j;
          }
          else if (time[k][0] >=2)
          {
            impossible = true;
            break;
          }
        }
        if (didOverlap)
        {
          overlaps[actA] += " " + actB;
          overlaps[actB] += " " + actA;
        }
      }
      if (impossible)
      {
        System.out.println ("Case #" + (i+1) + ": IMPOSSIBLE");
      }
      else
      {
        char[] ans = new char[N];
        for (int k = 0; k < N; k++)
        {
          if (ans[k] != 'C' && ans[k] != 'J')
          {
            ans[k] = 'C';
            if (overlaps[k] != null)
            {
              String[] temp = overlaps[k].split(" ");
              for (int x = 1; x < temp.length; x++)
              {
                ans[Integer.parseInt(temp[x])] = 'J';
              }
            }
          }
        }
        System.out.print ("Case #" + (i+1) + ": ");
        for (int x = 0; x < ans.length; x++)
        {
          System.out.print(ans[x]);
        }
        System.out.println();
      }
      
      
      
    }
  }
}