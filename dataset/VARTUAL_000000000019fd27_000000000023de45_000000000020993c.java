import java.util.Scanner;
class main
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int test_cnt = 1;
        while(t-- != 0)
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
              int check = 0;
              for(int j = 0; j < n - 1; ++j)
              {
                  for(int k = j + 1; k < n; ++k)
                  {
                     if(ar[i][j] == ar[i][k])
                     {
                         row_cnt++;
                         check = 1;
                         break;
                     }
                  }
                  if(check == 1)
                   {
                     break;
                   }
              }
          }
          for(int i = 0; i < n; ++i)
          {
              int check = 0;
              for(int j = 0; j < n - 1; ++j)
              {
                  for(int k = j + 1; k < n; ++k)
                  {
                     if(ar[j][i] == ar[j][i])
                     {
                         col_cnt++;
                         check = 1;
                         break;
                     }
                  }
                  if(check == 1)
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
           System.out.println("case #" + test_cnt + ": " + diag_sum + " " + row_cnt + " " + col_cnt);
      
            test_cnt++;
        }
      
    }
}