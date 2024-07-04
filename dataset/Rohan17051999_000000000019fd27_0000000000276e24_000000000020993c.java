import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        for(int k=1;k<=a;k++)
        {
            int b=sc.nextInt();
            int arr[][]=new int[b][b];
            int arr2[][]=new int[b][b];
            for(int i=0;i<b;i++)
            {
                for(int j=0;j<b;j++)
                {
                    arr[i][j]=sc.nextInt();
                }
            }
            for(int i=0;i<b;i++)
            {
                for(int j=0;j<b;j++)
                {
                    arr2[i][j]=arr[j][i];
                }
            }
            int sum=0;
            for(int i=0;i<b;i++)
            {
            sum=sum+arr[i][i];
            Arrays.sort(arr[i]);
            }
            int count1=0;
             for(int i=0;i<b;i++)
            {
                for(int j=0;j<b-1;j++)
                {
                    if(arr[i][j]==arr[i][j+1])
                    {
                        count1++;
                        break;
                    }
                }
            }
             
            for(int i=0;i<b;i++)
            {
            Arrays.sort(arr2[i]);
            }
            int count2=0;
            for(int i=0;i<b;i++)
            {
                for(int j=0;j<b-1;j++)
                {
                    
                   if(arr2[i][j]==arr2[i][j+1])
                    {
                        count2++;
                        break;
                    }
                }
                
            }
            System.out.print("Case #"+k+": "+sum+" "+count1+" "+count2+"\n");
        
        }
        }
    }