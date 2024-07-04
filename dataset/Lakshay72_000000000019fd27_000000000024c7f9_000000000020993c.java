import java.util.*;
class Solution
{
    public static void main(String[] args) 
    {
        Scanner cin=new Scanner(System.in);
        int t=cin.nextInt();
        int n,sum,row,col,flag;
        for(int x=1;x<=t;x++)
        {
            n=cin.nextInt();
            sum=0;
            int arr[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=cin.nextInt();
                    if(i==j)
                    {
                        sum+=arr[i][j];
                    }
                }
            }
            //For rows
            row=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n-1;j++)
                {
                    flag=0;
                    for(int k=j+1;k<n;k++)
                    {
                        if(arr[i][j]==arr[i][k])
                        {
                            row++;
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1)
                    {
                        break;
                    }
                }
            }
            //For columns
            col=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n-1;j++)
                {
                    flag=0;
                    for(int k=j+1;k<n;k++)
                    {
                        if(arr[j][i]==arr[k][i])
                        {
                            col++;
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1)
                    {
                        break;
                    }
                }
            }
            //Printing
            System.out.println("Case #"+x+": "+sum+" "+row+" "+col);
        }
    }
}