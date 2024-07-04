import java.util.*;
public class Solution
{
    static Scanner sc =new Scanner(System.in);
    int n,a[][],k,r,c;
    Solution(int n)
    {
        this.n=n;
        a=new int[n][n];
        k=0;
        r=0;
        c=0;
    }
    void input()
    {
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                a[i][j]=sc.nextInt();
            } 
    void trace()
    {
        for(int i=0;i<n;i++)
            k=k+a[i][i];
        }
    void lsq()
    {
        int fl=0;
        for(int i=1;i<=9;i++)
            for(int j=0;j<n;j++)
               {
                   int c1=0,c2=0;
                   for(int h=0;h<n;h++)
                    {
                        if(i==a[j][h])
                          {
                              c1++;
                              if(c1>1 && r!=n)
                                {
                                    fl++;
                                    r++;
                                }
                            }
                        if(i==a[h][j])
                          {
                              c2++;
                              if(c2>1 && c!=n)
                                {
                                    fl++;
                                    c++;
                                }
                            }
                        if(fl==2)
                          {
                              fl=0;
                              break;
                            }
                        }
                    }
                }
    public static void main(String args[])
    {
        Scanner sc1 =new Scanner(System.in);
        int m=sc.nextInt();
        if(m>=1 && m<=100)
           {
               int i=0;
               while(i<m)
               {
                   int n1=sc.nextInt();
                   if(n1>=2 && n1<=100)
                     {
                         Solution l=new Solution(n1);
                         l.input();
                         l.trace();
                         l.lsq();
                         System.out.println("case #"+(i+1)+": "+l.k+" "+l.r+" "+l.c);
                        }
                   i++;
                    }
                }
            }
}

