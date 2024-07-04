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
        int [][] mat=new mat[N][N];
        for(k=0;k<N;k++)
          for( j=0;j<N;j++)
          {
            mat[k][j]=ip.nextInt();
            if(k==j) sum=sum+mat[k][j];
          }
        int row=0,col=0;
        ArrayList<Integer> arr=new ArrayList<Integer>();
        for(k=0;k<n;k++)
        {
            for(j=0;j<n;j++)
            {
                if(mat[Math.abs(mat[i][j])]>=0)
                  {mat[Math.abs(mat[i][j])]=-mat[Math.abs(mat[i][j])];
                   row=row+1;
                   break;
                  }
            }}
            for(k=0;k<n;k++)
        {
            for(j=0;j<n;j++)
            {
                if(mat[Math.abs(mat[j][i])]>=0)
                  {mat[Math.abs(mat[j][i])]=-mat[Math.abs(mat[j][i])];
                   col=col+1;
                   break;
                  }
            }}
            
             System.out.println("Case #"+(t+1)+":"+" "+sum+" "+row+" "+col);
        }
       
    }
    
}

