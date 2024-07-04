import java.util.*;
import java.io.*;
public class q1
{
    public static int rowcheck(int a[][], int n)
    {
        int flag =0;
        for(int i=0;i<n;i++)
        {
            int arr[] = new int[n];
            for(int j=0;j<n;j++)
            arr[j] = a[i][j];
            Arrays.sort(arr);
            for(int j=0;j<n-1;j++)
            {
                if(arr[j]==arr[j+1])
                {
                    flag++;
                    break;
                }
            }
        }
        return flag;
    }
    public static int columncheck(int a[][], int n)
    {
        int flag =0;
        for(int i=0;i<n;i++)
        {
            int arr[] = new int[n];
            for(int j=0;j<n;j++)
            arr[j] = a[j][i];
            Arrays.sort(arr);
            for(int j=0;j<n-1;j++)
            {
                if(arr[j]==arr[j+1])
                {
                    flag++;
                    break;
                }
            }
        }
        return flag;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n = sc.nextInt();
            int a[][] = new int[n][n];
            int sum = 0;
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    
                    a[j][k] = sc.nextInt();
                    if(j==k)
                    sum = sum + a[k][k];
                }
            }
            int r = rowcheck(a,n);
            int c = columncheck(a,n);
            System.out.println("Case #"+(i)+": "+sum+" "+r+" "+c);
        }
    }
}
