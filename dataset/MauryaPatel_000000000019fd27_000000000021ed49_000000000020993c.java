import java.util.Scanner;
class latinsquare
{
  public static void main(String args[])
  {
    Scanner in = new Scanner(System.in);
    int n,N,i,m,j,k=0,r=0,c=0,flag=0;
    n=in.nextInt();
    while(n>0)
    {
      N=in.nextInt();
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
            for(m=j;m<N;m++)
            {
              if((mat[i][j]==mat[i][m])&&(flag==0)&&(j!=m))
              {
                r++;
                flag=1;
              }
            }
          }
          flag=0;
      }
      for(j=0;j<N;j++)
      {
          for(i=0;i<N;i++)
          {
            for(m=i;m<N;m++)
            {
              if((mat[i][j]==mat[m][j])&&(flag==0)&&(i!=m))
              {
                c++;
                flag=1;
              }
            }
          }
          flag=0;
      }
      System.out.println("Case#"+n+": "+k+" "+r+" "+c);
      n=n-1;
    }
  }
}
