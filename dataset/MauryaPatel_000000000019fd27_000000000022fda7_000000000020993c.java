import java.util.*;
class Solution
{
  public static void main(String args[])
  {
    Scanner in = new Scanner(System.in);
    int n,N,M,i,m,j,k,r,c,flagr=0,flagc=0;
    n=in.nextInt();
    M=1;
    while(n>=M)
    {
      N=in.nextInt();
      k=0;
      r=0;
      c=0;
      int mat[][]= new int[N][N];
      for(i=0;i<N;i++)
      {
          for(j=0;j<N;j++)
          {
            mat[i][j]=in.nextInt();
            if(i==j)
              k=k+mat[i][j];
          }
      }
      for(i=0;i<N;i++)
      {
        int row[]=new int[N];
        int col[]=new int[N];
          for(j=0;j<N;j++)
          {
            row[mat[i][j]-1]++;
            if(row[mat[i][j]-1]==2&&flagr==0)
            {
              r+=1;
              flagr=1;
            }
            col[mat[j][i]-1]++;
            if(col[mat[j][i]-1]==2&&flagc==0)
            {
              c+=1;
              flagc=1;
            }

          }
          flagr=0;
          flagc=0;
      }
      System.out.println("Case #"+M+": "+k+" "+r+" "+c);
      M=M+1;
    }
  }
}
