import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            for(int q=0;q<t;q++)
            {
                int n=sc.nextInt();
                int ar[][]=new int[n][n];
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    ar[i][j]=sc.nextInt();
                }
                //int s=(n*(n+1))/2;
                boolean arr[]=new boolean[n];
                for(int m=0;m<n;m++)
                arr[m]=false;
                int k=0;
                for(int i=0;i<n;i++)
                k+=ar[i][i];
                int r=0,c=0,sum=0;
                for(int i=0;i<n;i++)
                {
                    for(int m=0;m<n;m++)
                    arr[m]=false;
                    loop:for(int j=0;j<n;j++)
                    {
                        if(arr[ar[i][j]-1]==false)
                        arr[ar[i][j]-1]=true;
                        else
                        {
                            r++;
                            break loop;
                        }
                    }
                }
               for(int i=0;i<n;i++)
                {
                    for(int m=0;m<n;m++)
                    arr[m]=false;
                    loop:for(int j=0;j<n;j++)
                    {
                        if(arr[ar[j][i]-1]==false)
                        arr[ar[j][i]-1]=true;
                        else
                        {
                            c++;
                            break loop;
                        }
                    }
                }
                System.out.println("Case #"+(q+1)+": "+k+" "+r+" "+c);
            }
        }
            catch(Exception e)
            {
                return;
            }
        }
    }