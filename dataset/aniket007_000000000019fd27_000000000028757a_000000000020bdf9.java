import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n=sc.nextInt();
            int c =0,j=0;
            int I[][]=new int[2][n];
            int C[][]=new int[2][n];
            int J[][]=new int[2][n];String s="";int f=0;
            for(int l=0;l<n;l++)
            {
                I[0][l]=sc.nextInt();
                I[1][l]=sc.nextInt();
            }
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
                    s=s+"C";
                    c++;
                }
                else
                {
                    for(int u=c-1;u>=0;u--)
                      {      if(!(k>=C[1][u]||v<=C[0][u]))
                            {
                                p=1;break;
                                
                            }
                      }
                      if(p==0)
                      {
                          C[0][c]=k;
                                C[1][c]=v;s=s+"C";c++;
                      }
                     else 
                        {
                                if(j==0)
                                {
                                J[0][j]=k;
                                J[1][j]=v;s=s+"J";  j++;
                                }
                                else 
                                {
                                    for(int y=j-1;y>=0;y--)
                                    {
                                        if(!(k>=J[1][y]||v<=J[0][y]))
                                        {
                                            q=1;break;
                                        }
                                    }
                                    if(q==0)
                                    {
                                        J[0][j]=k;
                                            J[1][j]=v;s=s+"J";j++;
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
            }
            if(f==0)
            System.out.println("Case #"+i+": "+s);
        }
    }
}