import java.util.*;
class Main{
public static void main(String[] args)
{
    Scanner ip=new Scanner(System.in);
    int testCases=ip.nextInt();
    for(int i=0;i<testCases;i++)
    {
        int k,j;int sum=0;
        int N=ip.nextInt();
        int [][] mat=new int[N][N];
        for(k=0;k<N;k++)
          for( j=0;j<N;j++)
          {
            mat[k][j]=ip.nextInt();
            if(k==j) sum=sum+mat[k][j];
          }
        int row=0,col=0;
        for(k=0;k<N;k++)
        {
            for(j=0;j<N;j++)
            {
                if(mat[k][Math.abs(mat[k][j])-1]>=0)
                  {mat[k][Math.abs(mat[k][j])-1]=-mat[k][Math.abs(mat[k][j])-1];
                   row=row+1;
                   break;
                  }
            }}
            for(k=0;k<N;k++)
        {
            for(j=0;j<N;j++)
            {
                if(mat[j][Math.abs(mat[j][k])-1]>=0)
                  {mat[j][Math.abs(mat[j][k])-1]=-mat[j][Math.abs(mat[j][k])-1];
                   col=col+1;
                   break;
                  }
            }}
            
             System.out.println("Case #"+(i+1)+":"+" "+sum+" "+row+" "+col);
        }
       
    }
    
}

