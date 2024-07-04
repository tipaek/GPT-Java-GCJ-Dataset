import java.util.*;
import java.io.*;

public class Solution 
{
  public static void main (String [] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(in.readLine());
    for(int i=1; i <= testCases; i++)
    {
      int s = Integer.parseInt(in.readLine());
      int [][] array = new int [s][s];
      for(int r=0; r < s; r++)
      {
        String [] temp = in.readLine().split(" ");
        for(int c =0; c< s; c++)
        {
          array[r][c] = Integer.parseInt(temp[c]);
        }
      }
      int sum =0;
      int dr =0;
      int dc= 0;
      for(int r=0; r < s; r++)
      {
        boolean [] duplicates = new boolean [s+1];
        for(int c =0; c< s; c++)
        {
          if (duplicates[array[r][c]])
          {
            dr++;
            break;
          }
          else
          {
            duplicates[array[r][c]] = true;
          }
        }
      }
      for(int r=0; r < s; r++)
      {
        boolean [] duplicates = new boolean [s+1];
        for(int c =0; c< s; c++)
        {
          if (duplicates[array[c][r]])
          {
            dc++;
            break;
          }
          else
          {
            duplicates[array[c][r]] = true;
          }
        }
      }
      for(int x =0; x< s ; x++)
      {
        sum += array[x][x];
      }
      System.out.println("Case #" + i + ": " + sum + " " + dr + " " + dc);
    }
  }
  
  
}
  