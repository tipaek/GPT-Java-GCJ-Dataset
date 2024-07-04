import java.util.Scanner;
class Vestigium
{
  public static void main(String ma[])
  {
    Scanner getInt = new Scanner(System.in);
    int t = getInt.nextInt();
    for(int i = 1; i <= t; i++)
    {
      int n = getInt.nextInt();
      int m[][] = new int[n][n];
      for(int j = 0; j < n; j++)
      {
        for(int k = 0; k < n; k++)
        {
          m[j][k] = getInt.nextInt();
        }
      }
      int sum = 0, r = 0, c = 0;
      for(int j = 0; j < n; j++)
      {
        for(int k = 0; k < n; k++)
        {
          if(j == k)
          {
            sum += m[j][k];
          }
        }
      }
      for(int j = 0; j < n-1; j++)
      {
        for(int k = 0; k < n-1; k++)
        {
          if(m[j][k] == m[j][k+1])
          {
              r++;
          }
          if(m[j][k] == m[j+1][k])
          {
              c++;
          }
        }
      }
      System.out.println("Case #" + i + ": " + sum + " " + r + " " + c);
    }
  }
}
