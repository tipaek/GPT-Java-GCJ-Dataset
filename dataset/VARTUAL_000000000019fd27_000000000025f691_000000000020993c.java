import java.util.Scanner;
class Main

{
    public static void main(String[] args)
    {
        Scannner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int z = 1; z <= t; ++z)
        {
            int n = s.nextInt();
            int[][] ar = new int[n][n];
          for(int i = 0; i < n; ++i)
          {
              for(int j = 0; j < n; ++j)
              {
                ar[i][j] = s.nextInt();
              }
          }
          int row_cnt = 0;
          int col_cnt = 0;
          for(int i = 0; i < n; ++i)
          {
              int k;
              for(int j = 0; j < n - 1; ++j)
              {
                  for(k = j + 1; k < n; ++k)
                  {
                     if(ar[i][j] == ar[i][k])
                     {
                         row_cnt++;
                         break;
                     }
                  }
                  if(k < n)
                   {
                     break;
                   }
              }
          }
          for(int i = 0; i < n; ++i)
          {
              
              for(int j = 0; j < n - 1; ++j)
              {
                  int k;
                  for(k = j + 1; k < n; ++k)
                  {
                     if(ar[j][i] == ar[j][i])
                     {
                         col_cnt++;
                        
                         break;
                     }
                  }
                  if(k < n)
                   {
                     break;
                   }
              }
          }
          int diag_sum = 0;
           for(int i = 0; i < n; ++i)
          {
              diag_sum += ar[i][i];
          }
           System.out.println("case #" + z + ": " + diag_sum + " " + row_cnt + " " + col_cnt);
      }
      
    }
}