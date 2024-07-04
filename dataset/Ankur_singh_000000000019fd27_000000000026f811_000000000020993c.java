import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++)
        {
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            int arr2[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=sc.nextInt();
                }
            }
            for(int i=0;i<n;i++)
            {
            Arrays.sort(arr[i]);
            }
            int sum=0,count1=0,count2=0;
             for(int i=0;i<n;i++)
            {
                for(int j=0;j<n-1;j++)
                {
                    arr2[i][j]=arr[j][i];
                    sum=sum+arr[i][i];
                    count1++;
                    if(arr[i][j]==arr[i][j+1])
                    {
                        break;
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n-1;j++)
                {
                    count2++;
                   if(arr2[i][j]==arr2[i][j+1])
                    {
                        break;
                    }
                }
                
            }
            System.out.print("Case#"+k+": "+sum+" "+count1+" "+count2);
        }
        }
    }