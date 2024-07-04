import java.util.*;

class Solution{
    public static void main(String[] args)
    {
        int T=1;
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        boolean rflag=false,cflag=false;
        while(T<=t)
        {
            int N;
            int[][] matrix;
            N=sc.nextInt();
            matrix=new int[N][N];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                    matrix[i][j]=sc.nextInt();
            }
            int trace=0;
            int nrows=0,ncols=0;
            for(int i=0;i<N;i++)
            trace=trace+matrix[i][i];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    for(int k=j+1;k<N;k++)
                    {
                        if(matrix[i][j]==matrix[i][k])
                        {
                            rflag=true;
                            break;
                        }
                    }
                    for(int l=i+1;l<N;l++)
                    {
                        if(matrix[i][j]==matrix[k][j])
                        {
                            cflag=true;
                            break;
                        }
                    }
                }
                if(rflag)
                {
                    nrows+=1;
                    rflag=false;
                }
                
            }
            for(int j=0;j<N;j++)
            {
                for(int i=0;i<N;i++)
                {
                    for(int l=i+1;l<N;l++)
                    {
                        if(matrix[i][j]==matrix[l][j])
                        {
                            cflag=true;
                            break;
                        }
                    }
                }
                if(cflag)
                {
                    ncols+=1;
                    cflag=false;
                }
            }
            System.out.println("Case #"+T+": "+trace+" "+nrows+" "+ncols);
            T--;
        }
    }
}