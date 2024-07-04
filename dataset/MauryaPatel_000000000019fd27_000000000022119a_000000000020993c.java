import java.util.*;
class latinsquare
{
  public static void main(String args[])
  {
    Scanner in = new Scanner(System.in);
    int n,N,M,i,m,j,k,r,c,flag=0;
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
          for(j=0;j<N;j++)
          {
            for(m=j+1;m<N;m++)
            {
              if((mat[i][j]==mat[i][m])&&(j!=m))
              {
                r++;
                break;
              }
            }
          }
      }
      for(j=0;j<N;j++)
      {
          for(i=0;i<N;i++)
          {
            for(m=i+1;m<N;m++)
            {
              if((mat[i][j]==mat[m][j])&&(i!=m))
              {
                c++;
                break;
              }
            }
          }
      }
      System.out.println("Case#"+M+": "+k+" "+r+" "+c);
      M=M+1;
    }
  }
}
