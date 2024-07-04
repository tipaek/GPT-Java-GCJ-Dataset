import java.lang.*;
class Solution{
    public static void main(String [] args)
    {
        Scanner k=new Scanner(System.in);
        int t=k.nextInt();
        for(int tt=0;tt<t;tt++)
        {
            int n=k.nextInt();
            int[][] m=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    m[i][j]=k.nextInt();
                }
            }
            int d=0;
            int r=0;
            int c=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    int k=j;
                    if(i==j)
                    {
                        d=m[i][j];
                    }
                    while(k<j)
                    {
                        if(m[i][k]!=m[i][k+1])
                        {
                            k++;
                        }
                        else
                        {
                            r++;
                            break;
                        }
                    }
                    // int p=i
                    while(k<j)
                    {
                        if(m[k][i]!=m[k+1][i])
                        {
                            k++;
                        }
                        else
                        {
                            c++;
                            break;
                        }
                    }
                }
                System.out.fflush();
                System.out.println("Case #"+tt+": " +d+" "+ r+" "+ c);
            }
        }
    }
}
            