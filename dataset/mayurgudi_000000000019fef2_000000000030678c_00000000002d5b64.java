import java.io.*;
import java.util.*;
class Solution 
{
  public static void main(String[] args) 
  {
    try
    {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int h = 0;
      h = Integer.parseInt(br.readLine());
      for(int t=1;t<=h;t++)
      {
        String rs[] = br.readLine().split(" ");
        int r = Integer.parseInt(rs[0]);
        int s = Integer.parseInt(rs[1]);
        int moves = (r-1)*(s-1);
        System.out.println("Case #" + t + ": " + moves);
        int counter = r*(s-1);
        for(int i=r-1;i>0;i--)
        {
          for(int j=0;j<s-1;j++)
          {
            String x = String.valueOf(counter+" "+i);
            System.out.println(x);
            counter--;
          }
        }
      }
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}