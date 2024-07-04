import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        int t=ob.nextInt();
        StringBuilder sb=new StringBuilder();
        int cases=1;
        while(t-->0)
        {
            int n=ob.nextInt();
            int k=ob.nextInt();
            if(k%n != 0)
            sb.append("Case #"+cases+": "+"IMPOSSIBLE\n");
            else
            {
                //generate matrix
                int a[][]=new int[n][n];
                int st=k/n;
                for(int i=0;i<n;i++)
                a[i][i]=st;
                for(int i=0;i<n;i++)
                {
                    for(int j=i+1;j<n;j++)
                    {
                        int val = a[i][j-1] + 1;
                        if(val>n)
                        val=1;
                        a[i][j] = val;
                    }
                }
                
                for(int i=0;i<n;i++)
                {
                    for(int j=i-1;j>=0;j--)
                    {
                        int val = a[i][j+1] - 1;
                        if(val<1)
                        val=n;
                        a[i][j] = val;
                    }
                }
                sb.append("Case #"+cases+": "+"POSSIBLE\n");
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    sb.append(a[i][j]+" ");
                    sb.append("\n");
                }
            }
            cases++;
        }
        System.out.println(sb);
    }
}