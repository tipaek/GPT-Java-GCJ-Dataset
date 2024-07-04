import java.util.*;
public class Solution
{
    static int n;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
             n=sc.nextInt();
            int c =0,j=0;
            int I[][]=new int[2][n];
            int C[][]=new int[2][n];
            int J[][]=new int[2][n];String s="",str="";int f=0;
            int d[][]=new int[2][n];
            for(int l=0;l<n;l++)
            {
                d[0][l]=I[0][l]=sc.nextInt();
                d[1][l]=I[1][l]=sc.nextInt();
            }
            sort(I);
            outer:
            {
            for(int l=0;l<n;l++)
            {
                int k=I[0][l];int p=0,q=0;
                int v=I[1][l];
                if(c==0)
                {
                    C[0][c]=k;
                    C[1][c]=v;
                    s=s+"J";
                    c++;
                }
                else
                {
                    for(int u=c-1;u>=0;u--)
                      {      if((k>=C[0][u]&&k<C[1][u])||(v<=C[1][u]&&v>C[0][u]))
                            {
                                p=1;break;
                                
                            }
                      }
                      if(p==0)
                      {
                          C[0][c]=k;
                                C[1][c]=v;s=s+"J";c++;
                      }
                     else 
                        {
                                if(j==0)
                                {
                                J[0][j]=k;
                                J[1][j]=v;s=s+"C";  j++;
                                }
                                else 
                                {
                                    for(int y=j-1;y>=0;y--)
                                    {
                                        if((k>=J[0][y]&&k<J[1][y])||(v<=J[1][y]&&v>J[0][y]))
                                        {
                                            q=1;break;
                                        }
                                    }
                                    if(q==0)
                                    {
                                        J[0][j]=k;
                                            J[1][j]=v;s=s+"C";j++;
                                    }
                                     else
                                     {
                                         f=1;
                                         System.out.println("Case #"+i+": "+ "IMPOSSIBLE");
                                         break outer;
                                      }
                                }
                               
                                
                         } 
                                
                }
                
                
                
            }
            for(int l=0;l<n;l++)
            {
                for(int k=0;k<n;k++)
                {
               if( d[0][l]==I[0][k]&&d[1][l]==I[1][k])
                str=str+""+s.charAt(k);
                }
            }
            
            }
            if(f==0)
            System.out.println("Case #"+i+": "+str);
        }
    }
    static void sort(int a[][])
    {
        for(int i=0;i<n;i++ )
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(a[0][j]>a[0][j+1])
                {
                    int t=a[0][j],v=a[1][j];
                    a[0][j]=a[0][j+1];a[1][j]=a[1][j+1];
                    a[0][j+1]=t;a[1][j+1]=v;
                }
            }
        }
    }
}