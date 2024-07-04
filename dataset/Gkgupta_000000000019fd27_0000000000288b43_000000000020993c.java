import java.util.Scanner;
class Solution
{
    public static void main(String arg[])
    {
        int test,N;
        int nodes[][];
        Scanner sc= new Scanner(System.in);
        test=sc.nextInt();
        while(test>=1)
        {
            int dsum=0,rsum=0,csum=0;
            N=sc.nextInt();
            nodes=new int[N][N];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    nodes[i][j]=sc.nextInt();
                }
            }
            
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    if(i==j)
                    {
                        dsum=dsum+nodes[i][j];
                    }
                    
                }
            }
            
            for(int i=0;i<N;i++)
            {
               gk: for(int k=0;k<N-1;k++)
                {
                    for(int m=k+1;m<N;m++)
                    {
                        if(nodes[i][k]==nodes[i][m])
                        {
                            rsum++;
                            break gk;
                        }
                    }
                }
            }
            for(int i=0;i<N;i++)
            {
               gk: for(int k=0;k<N-1;k++)
                {
                    for(int m=k+1;m<N;m++)
                    {
                        if(nodes[k][i]==nodes[m][i])
                        {
                            csum++;
                            break gk;
                        }
                    }
                }
            }
            System.out.println(dsum);
            System.out.println(rsum);
            System.out.println(csum);
            test--;
          
        }
        
    }
}