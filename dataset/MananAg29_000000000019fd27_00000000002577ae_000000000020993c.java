import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        try
        {
            Scanner d= new Scanner(System.in);
            int t,i,j,k,n,s,l,c,z,r;
            t=d.nextInt();
            for(i=1;i<=t;i++)
            {
                s=c=r=0;
                n=d.nextInt();
                int a[][]=new int[n][n];
                for(j=0;j<n;j++)
                {
                    for(k=0;k<n;k++)
                    a[j][k]=d.nextInt();
                }
                for(j=0;j<n;j++)
                s=s+a[j][j];
                for(j=0;j<n;j++)
                {
                    z=0;
                    for(k=0;k<n-1;k++)
                    {
                        for(l=k+1;l<n;l++)
                        {
                            if(a[j][k]==a[j][l])
                            {
                                c++;
                                z=1;
                                break;
                            }
                        }
                        if(z==1)
                        break;
                    }
                }
                for(j=0;j<n;j++)
                {
                    z=0;
                    for(k=0;k<n-1;k++)
                    {
                        for(l=k+1;l<n;l++)
                        {
                            if(a[k][j]==a[l][j])
                            {
                                r++;
                                z=1;
                                break;
                            }
                        }
                        if(z==1)
                        break;
                    }
                }
                System.out.println("Case #"+i+": "+ s+" "+c+" "+r);
            }
        }
        catch(Exception e)
        {
            System.out.println(0);
        }
    }	
} 