import java.util.*;
import java.io.*;
public class Solution
{
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(in.readLine());
    for (int i = 0; i <= T; i++) {
      int N = Integer.parseInt(in.readLine());
      int[][] matrix = new int[N][N];
      for (int j = 0; j < N; j++)
      {
        String[] s = in.readLine().split(" ");
        for (int k = 0; k < N; k++)
        {
          matrix[j][k] = Integer.parseInt(s[k]);
        }
      }
      
      int trace = 0;
      for (int j = 0; j < N; j++)
      {
        trace += matrix[j][j];
      }
      
      int rows = 0;
      for (int j = 0; j < N; j++)
      {
        boolean[] nums = new boolean[N];
        for (int k = 0; k < N; k++)
        {
          if (nums[matrix[j][k]-1])
          {
            //repeated
            rows++;
            break;
          }
          else
          {
            nums[matrix[j][k]-1] = true;
          }
        }
      }
      
      
      int cols = 0;
      for (int j = 0; j < N; j++)
      {
        boolean[] nums = new boolean[N];
        for (int k = 0; k < N; k++)
        {
          if (nums[matrix[k][j]-1])
          {
            //repeated
            cols++;
            break;
          }
          else
          {
            nums[matrix[k][j]-1] = true;
          }
        }
      }
      
      System.out.println ("Case #" + i + ": " + trace + " " + rows + " " + cols);
    }
  }
}