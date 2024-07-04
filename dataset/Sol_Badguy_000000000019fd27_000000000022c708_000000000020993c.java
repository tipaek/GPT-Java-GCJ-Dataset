import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        int tc=ob.nextInt();
        for(int t=1;t<=tc;t++)
        {
            int n=ob.nextInt();
            int a[][]=new int[n][n];
            int trace=0;int row=0,col=0;
            for(int i=0;i<n;i++)
            {
                int freq[]=new int[n+1];
                for(int j=0;j<n;j++)
                {
                    a[i][j]=ob.nextInt();
                    freq[a[i][j]]++;
                    
                    if(i==j)
                    trace+=a[i][j];
                }
                for(int j=1;j<=n;j++)
                {
                    if(freq[j]>1)
                    {
                        row++;
                        break;}
                }
            }
            for(int i=0;i<n;i++)
            {
                int freq[]=new int[n+1];
                for(int j=0;j<n;j++)
                {
                    freq[a[j][i]]++;
                   
                }
                for(int j=1;j<=n;j++)
                {
                    if(freq[j]>1)
                    {
                        col++;
                        break;}
                }
            }
            System.out.println("Case #"+t+": "+trace+" "+row+" "+col);
        }
    }
}
