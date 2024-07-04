import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner obj = new Scanner(System.in);
        int t = obj.nextInt();
        int q;
        for(q=1;q<=t;q++)
        {
            int n = obj.nextInt();
            int a[][] = new int[n][n],i,j;
            for(i=0;i<n;i++)
                for(j=0;j<n;j++)
                    a[i][j] = obj.nextInt();
            int trace = 0,cr = 0,cc = 0,k,flag;
            for(i=0;i<n;i++)
                trace+=a[i][i];
            for(i=0;i<n;i++)
            {
                flag=0;
                for(j=0;j<n;j++)
                {
                    for(k=j+1;k<n;k++)
                    {
                        if(a[i][j]==a[i][k])
                        {
                            flag=1;
                            break;
                        }
                    }
                }
                if(flag==1)
                    cr++;
            }
            for(i=0;i<n;i++)
            {
                flag=0;
                for(j=0;j<n;j++)
                {
                    for(k=j+1;k<n;k++)
                    {
                        if(a[j][i]==a[k][i])
                        {
                            flag=1;
                            break;
                        }
                    }
                }
                
                    if(flag==1)
                        cc++;
            }
            System.out.println("Case #"+q+": "+trace+" "+cr+" "+cc);
        }
    }
}