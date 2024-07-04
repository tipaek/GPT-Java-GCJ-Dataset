import java.util.*;
class Solution
{
   public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int T=scan.nextInt();
      int m=1;
       while(m<=T)
        {
            int n=scan.nextInt();
           //defining 2D array to hold matrix data
           int[][] matrix = new int[n][n];
           int [] row=new int[n];
           int [] col=new int[n];
           // Enter Matrix Data
             int trace=0;
             for (int i = 0; i < n; i++)
             {
              for (int j = 0; j < n; j++)
              {
                  matrix[i][j] = scan.nextInt();
              }
             }
            int dupr=0,dupc=0,maxr=0,maxc=0;
            for (int i = 0; i < n; i++)
            {
              for (int j = 0; j < n; j++)
              {
                row[j]=matrix[i][j];
                col[j]=matrix[j][i];
                 if(i==j)
                  trace+=matrix[i][j];
              }
              Arrays.sort(row);
              Arrays.sort(col);
              dupr= func(row,n);
              dupc=func(col,n);
              if(maxr<dupr)
               maxr=dupr;
              if(maxc<dupc)
               maxc=dupc;
            }
           System.out.println("Case #"+m+": "+trace+" "+maxr+" "+maxc);
           m++;
        }
}
public static int func(int[] a,int n){ 
     int dup=0,f=0;
        for (int i = 0; i < n-1; i++)
        {
            if(a[i]==a[i+1])
            {dup++;
                if(f==0)
                dup++;
                f=1;
            }
            else 
             f=0;
        }
        return dup;
  }
}