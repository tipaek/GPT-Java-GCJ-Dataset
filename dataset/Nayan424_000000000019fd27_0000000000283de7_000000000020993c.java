import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        try
        {
            int t=sc.nextInt();
            for(int ff=1;ff<=t;ff++)
            {
                int n=sc.nextInt();
                long sum=0;
                int r=0,c=0;
                int a[][]=new int[n][n];
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        a[i][j]=sc.nextInt();
                        if(i==j)
                            sum+=a[i][j];
                    }
                }
                int f=0;
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        f=0;
                        for(int k=j+1;k<n;k++)
                        {
                            if(a[i][j]==a[i][k])
                            {
                                r++;
                                f=1;
                                break;
                            }
                        }
                        if(f==1)
                            break;
                    }
                }
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        f=0;
                        for(int k=j+1;k<n;k++)
                        {
                            if(a[j][i]==a[k][i])
                            {
                                c++;
                                f=1;
                                break;
                            }
                        }
                        if(f==1)
                            break;
                    }
                }
                System.out.println("Case #"+ff+": "+sum+" "+r+" "+c);
            }
        }
        catch(Exception e)
        {
            System.exit(0);
        }
    }
}