import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=0,n=0,s=0,r=0,c=0,fr=0,fc=0;
        int a[][];
        t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            s=0;r=0;c=0;
           n=sc.nextInt();
           a=new int[n][n];
           for(int j=0;j<n;j++)
           {
               for(int k=0;k<n;k++)
               {
                   a[j][k]=sc.nextInt();
                   if(j==k)s=s+a[j][k];
                }
            }
                
               for(int j=0;j<n;j++)
               {
                   fr=0;
                   for(int k=0;k<n-1;k++)
                   {
                      for(int l=k+1;l<n;l++)
                      {
                          if(a[j][k]==a[j][l]){fr=1;break;}                          
                        }
                    }
                   if(fr==1)r++;
               }
               for(int j=0;j<n;j++)
               {
                   fc=0;
                   for(int k=0;k<n-1;k++)
                   {
                      for(int l=k+1;l<n;l++)
                      {
                          if(a[k][j]==a[l][j]){fc=1;break;}                          
                        }
                   }
                   if(fc==1)c++;
               }
               System.out.println("Case #"+i+": "+s+" "+r+" "+c);
                
            }
        }
    }
