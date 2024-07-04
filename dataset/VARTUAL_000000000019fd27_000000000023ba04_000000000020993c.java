public class main
{
    public static void main(String[] args)
    {
        Scannner s = new Scanner(System.in);
        int t = s.nextInt();
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
                         check == 1;
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
                         check == 1;
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
           System.out.println("case #" + (t+1) + ": " + diag_sum + " " + row_cnt + " " + col_cnt);
      }
      
    }
}