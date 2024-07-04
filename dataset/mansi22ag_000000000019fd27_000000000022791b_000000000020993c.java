import java.util.*;
class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();int t1[]=new int[t];
        int r[]=new int[t];int c[]=new int[t];
        for(int z=0;z<t;z++)
        {
            int n=sc.nextInt(),s=0;
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                a[i][j]=sc.nextInt();
                if(i==j)
                s+=a[i][j];
                }
            }
            t1[z]=s;s=0;int f=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    for(int k=j+1;k<n;k++)
                    {
                        if(a[i][j]==a[i][k])
                        {
                            s++;f=1;
                            break;
                        }
                    }
                    if(f==1)
                    break;
                }
                f=0;
            }
            r[z]=s;s=0;f=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    for(int k=j+1;k<n;k++)
                    {
                        if(a[j][i]==a[k][i])
                        {
                            s++;f=1;
                        }
                    }
                    if(f==1)
                    break;
                }
                f=0;
            }
            c[z]=s;
        }
        for(int i=0;i<t;i++)
        {
            System.out.println("Case #"+(i+1)+": "+t1[i]+" "+r[i]+" "+c[i]);
        }
    }
}