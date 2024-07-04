import java.util.*;
import java.io.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();

        for(int x=0;x<t;x++)
        {
            int n = sc.nextInt();
            int arr[][] = new int [n][n];

            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    arr[i][j] = sc.nextInt();

            int sum=0;
            int countrow = 0, countcol = 0 ;
            for(int i =0;i<n;i++)
                for(int j=0;j<n;j++)
                    if(i == j)
                        sum += arr[i][j];

            int flag = 0;
            for(int i=0;i<n;i++)        
            {
                for(int j=0;j<n;j++) 
                {
                    for(int k=j+1;k<n;k++)
                    {
                        if(arr[i][j] == arr[i][k]){
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1)
                    {
                        countrow++;
                        break;
                    }
                }
                flag=0;
            }

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    for(int k=j;k<n;k++)
                    {
                        if(arr[j][i] == arr[k][i])
                        {
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1)
                    {
                        countcol++;
                        break;
                    }
                }
                flag=0;
            }

            System.out.println("Case #" +(x+1)+": "+sum+" " +countrow+ " " +countcol);
        }
    }
}