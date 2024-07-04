import java.io.*;
import java.util.Scanner;
class q
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int t,n,sum=0,r=0,c=0,l=0,s=0;
        t=sc.nextInt();
        int a[]=new int[t];
        int w[][]=new int[t][3];
        for(int i=0;i<t;i++)
        {
            a[i]=sc.nextInt();
            n=a[i];
            int m[][]=new int[n][n];
            for(int j=0;j<n;j++);
            {
                for(int k=0;k<n;k++)
                {
                    m[j][k]=sc.nextInt();
                    if(j==k)
                    sum+=m[j][j];
                }
            }
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    l=k+1;
                    while(l!=(n-1))
                    {
                        if(m[j][k]==m[j][l])
                        {
                            r+=1;
                            s=1;
                            break;
                        }
                    }
                    if(s==1)
                    break;
                }
                s=0;
                 for(int k=0;k<n;k++)
                {
                    l=k+1;
                    while(l!=(n-1))
                    {
                        if(m[k][j]==m[l][j])
                        {
                            c+=1;
                            s=1;
                            break;
                        }
                    }
                    if(s==1)
                    break;
                }
                s=0;
            }
            w[i][0]=sum;
            w[i][1]=r;
            w[i][2]=c;
            sum=0;
            r=0;
            c=0;
            
        }
        for(int i=0;i<t;i++)
        {
            System.out.println("Case #"+i+" "+w[i][0]+" "+w[i][1]+" "+w[i][2]);
        }
    }
}