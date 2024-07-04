import java.util.*;
class Solution
{
    public static void main(String arg[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int p=1;p<=t;p++)
        {
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            int trace=0;
            int flagr=0;
            int flagc=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                }
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(i==j)
                    trace+=a[i][j];
                }
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(a[i][j]==a[i][j+1])
                    flagr++;
                    if(a[i][j]==a[i+1][j])
                    flagc++;
                }
            }
            System.out.println("Case #"+1+":"+trace+" "+flagr+" "+flagc);
        }
    }
}