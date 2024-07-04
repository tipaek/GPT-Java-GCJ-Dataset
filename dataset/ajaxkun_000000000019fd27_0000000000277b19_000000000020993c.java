import java.io.*;
import java.util.*;
class Vestigium
{
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for(int x=1;x<=t;x++)
        {
            int trace=0;
            int n=scan.nextInt();
            int[][] arr=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=scan.nextInt();
                    if(i==j)
                        trace=trace+arr[i][i];
                }
            }
            int cr=0;
            int cc=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n-1;j++)
                {   int flag=0;
                    for(int k=j+1;k<n;k++)
                    {
                        if(arr[i][j]==arr[i][k])
                            {
                                cr++;
                                flag=1;

                                break;
                            }
                            
                    }
                    if (flag==1)
                                break;
                }
            }
             for(int i=0;i<n;i++)
            {
                for(int j=0;j<n-1;j++)
                {
                    int flag=0;
                    for(int k=j+1;k<n;k++)
                    {
                        if(arr[j][i]==arr[k][i])
                        {
                            cc++;
                            flag=1;
                            
                            break;
                        }
                        
                    }
                    if(flag==1)
                            break;
                }
            }
            System.out.println("Case #"+t+": "+trace+" "+cr+" "+cc);
            
           
        }
        scan.close();
    }
}