import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int test=1;test<=T;test++)
        {

            int n=sc.nextInt();
            int arr[][]=new int[n][n];

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=sc.nextInt();
                }
            }

            int k=trace(arr,n);

            int r=checkRow(arr,n);

            int c=checkCol(arr,n);

            System.out.println("Case #" +test+ ":"+" " +k+ " " +r+ " " +c); //Case #1: 4 0 0


        }
    }

    public static int trace(int arr[][],int n)
    {
        int sum=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)
                    sum=sum+arr[i][j];
            }
        }
        return sum;
    }
    public static int checkRow(int arr[][],int n)
    {
        Hashtable<Integer,Integer> map=new Hashtable<>();
        int count=0;
        for(int i=0;i<n;i++)
        {
            int row[]=arr[i];
            for(int j=0;j<row.length;j++)
            {
                if(map.containsKey(row[j]))
                {
                    count++;
                    break;
                }
                else
                {
                    map.put(row[j],1);
                }
            }
            map.clear();
        }
        return count;
    }

    public static int checkCol(int arr[][],int n)
    {
        Hashtable<Integer,Integer> map=new Hashtable<>();
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int ele=arr[j][i];
                if(map.containsKey(ele))
                {
                    count++;
                    break;
                }
                else
                {
                    map.put(ele,1);
                }
            }
            map.clear();
        }
        return count;

    }
}