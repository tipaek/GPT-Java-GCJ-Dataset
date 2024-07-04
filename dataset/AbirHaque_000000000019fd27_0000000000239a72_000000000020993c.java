import java.util.*;
import java.io.*;

public class Solution
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader

(System.in)));
    int t = in.nextInt();;
    for (int i = 0; i < t ; i++)
    {
      int n = in.nextInt();
      int[][] mat = new int[n][n];
      for (int row = 0; row < n; row++)
      {
        String str = in.next()+ in.nextLine();
        String[] arrOfStr = str.split(" "); 
        for (int column = 0; column < n; column++)
        {
          mat[row][column] = Integer.parseInt(arrOfStr[column]);
        }
      }
      int k = 0;
      int r = 0;
      int c = 0;
      for (int row = 0; row < n; row++)
      { 
        for (int column = 0; column < n; column++)
        {
          if (row == column)
          {
            k = k + mat[row][column];
            int num = mat[row][column];
            for (int otherCol = column + 1; otherCol < n; otherCol++)
            {
                if (num == mat[row][otherCol])
                {
                    r++;
                }
            }
            for (int otherRow = row + 1; otherRow < n; otherRow++)
            {
                if (num == mat[otherRow][column])
                {
                    c++;
                }
            }
          }
        }
      }
      System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
    }
	}
}