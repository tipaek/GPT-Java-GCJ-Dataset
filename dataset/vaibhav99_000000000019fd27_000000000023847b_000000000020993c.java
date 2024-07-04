import java.io.*;
class Solution
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        while(T>0)
        {
            T--;
            int N=Integer.parseInt(br.readLine());
            int M[][]=new int[N][N];
            int sum=N*(N+1)/2;
            int trace=0;
            int rows[]=new int[N];
            int cols[]=new int[N];
            for(int i=0;i<N;i++)
            {
                String s[]=br.readLine().split(" ");
                for(int j=0;j<N;j++)
                {
                    M[i][j]=Integer.parseInt(s[j]);
                    for(int k=0;k<j;k++)
                    {
                        if(cols[j]==0 && cols[k]==0 &&M[i][j] == M[i][k])
                        {
                            cols[j]++;
                            cols[k]++;
                            break;
                        }
                    }
                    for(int k=0;k<i;k++)
                    {
                        if(rows[i]==0 && rows[k]==0 && M[i][j] == M[k][j])
                        {
                            rows[i]++;
                            rows[k]++;
                            break;
                        }
                    }
                }
            }
            int r=0;
            int c=0;
            for(int i=0;i<N;i++)
            {
                if(rows[i]!=0)
                {
                    r++;
                }
                if(cols[i]!=0)
                {
                    c++;
                }
                trace+=M[i][i];
            }
            
            
            System.out.println(trace +" "+ c +" "+ r);
        }
    }
}