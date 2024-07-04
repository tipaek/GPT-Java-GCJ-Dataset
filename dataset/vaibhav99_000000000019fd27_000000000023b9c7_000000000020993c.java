import java.io.*;
class Solution
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        int aa=1;
        while(aa<=T)
        {
            
            int N=Integer.parseInt(br.readLine());
            int M[][]=new int[N][N];
            int sum=N*(N+1)/2;
            int trace=0;
            int rows[]=new int[N];
            int cols[]=new int[N];
            int num[]=new int[N];
            for(int i=0;i<N;i++)
            {
                String s[]=br.readLine().split(" ");
                for(int j=0;j<N;j++)
                {
                    M[i][j]=Integer.parseInt(s[j]);
                }
            }
            int r=0;
            int c=0;
            for(int i=0;i<N;i++)
            {
                trace+=M[i][i];
            }
            for(int i=0;i<N;i++)
            {
                for(int k=0;k<N;k++)
                {
                    num[k]=0;
                }
                for(int j=0;j<N;j++)
                {
                    int x=M[i][j]-1;
                    num[x]++;
                    if(num[x]>1)
                    {
                        r++;
                        break;
                    }
                }
                
                
                for(int k=0;k<N;k++)
                {
                    num[k]=0;
                }
                for(int j=0;j<N;j++)
                {
                    int x=M[j][i]-1;
                    num[x]++;
                    if(num[x]>1)
                    {
                        c++;
                        break;
                    }
                }
            }
            System.out.println("Case #" +aa+ ": "+trace +" "+ r +" "+ c);
            aa++;
            
        }
    }
}