import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for(int itest=0;itest<test;itest++)
        {
            int flag=0;
            int n=sc.nextInt();
            int k=sc.nextInt();
            if(n==0)
            {
                System.out.println("Case #"+(itest+1)+":"+" IMPOSSIBLE");
            }
            else
            {
            int a[]=new int[n+1];
            for(int i=0;i<n;i++)
            {
                a[i]=n*(i+1);
            }
            if(n%2==1)
            {
            a[n]=(n*(n+1))/2;
            }
            else
            {
                a[n]=0;
            }
            for(int i=0;i<=n;i++)
            {
                if(k==a[i])
                {
                    System.out.println("Case #"+(itest+1)+":"+" POSSIBLE");
                    flag=1;
                    if(i==n)
                    {
                        for(int i1=0;i1<n;i1++)
                        {
                            for(int j=0;j<n;j++)
                            {
                                int k1=(i1+j+1)%n;
                                if(k1==0)
                                {
                                    k1=n;
                                }
                                if(j==(n-1))
                                    System.out.print(k1);
                                else
                                    System.out.print(k1+" ");
                            }
                            System.out.println("");
                        }
                    }
                    else
                    {
                       int a1[][]=new int[n][n];
                       for(int i2=0;i2<n;i2++)
                       {
                           for(int j1=0;j1<n;j1++)
                           {
                               if(i2==j1)
                                    a1[i2][j1]=(i+1);
                           }
                       }
                       for(int i2=0;i2<n;i2++)
                       {
                           int fil1=0;
                           int fil=(i+2);
                           for(int k2=i2+1;k2<n;k2++)
                           {
                               fil1=(fil++)%n;
                               if(fil1==0)
                               {
                                   fil1=n;
                               }
                               a1[k2][i2]=fil1;
                           }
                           for(int j3=0;j3<i2;j3++)
                           {
                               fil1=(fil++)%n;
                               if(fil1==0)
                               {
                                   fil1=n;
                               }
                               a1[j3][i2]=fil1;
                           }
                       }
                       for(int i1=0;i1<n;i1++)
                        {
                            for(int j=0;j<n;j++)
                            {
                                if(j==(n-1))
                                    System.out.print(a1[i1][j]);
                                else
                                    System.out.print(a1[i1][j]+" ");
                            }
                            System.out.println("");
                        }
                    }
                    break;
                }
            }
            if(flag==0)
            {
                System.out.println("Case #"+(itest+1)+":"+" IMPOSSIBLE");
            }
        }
        }
    }
}