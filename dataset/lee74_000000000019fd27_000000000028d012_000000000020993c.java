import java.util.*;
import java.io.*;
public class Solution 
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int T=scan.nextInt();
        for(int z=1;z<=T;z++)
        {

            int size=scan.nextInt();
            int mat[][]=new int[size][size];

            for(int i=0;i<size;i++)
            {
                for(int j=0;j<size;j++)
                {
                    mat[i][j]=scan.nextInt();
                }
            }

            int k=trace(mat,size);

            int r=row_duplicate(mat,size);

            int c=col_duplicate(mat,size);

            System.out.println("Case #" +z+ ":"+" " +k+ " " +r+ " " +c); //Case #1: 4 0 0
        }
    }

    public static int trace(int arr[][],int size)
    {
        int sum=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(i==j)
                    sum=sum+arr[i][j];
            }
        }
        return sum;
    }
    public static int row_duplicate(int arr[][],int size)
    {
        HashMap<Integer,Integer> h=new HashMap<>();
        int count=0;
        for(int i=0;i<size;i++)
        {
            int row[]=arr[i];
            for(int j=0;j<row.length;j++)
            {
                if(h.containsKey(row[j]))
                {
                    count++;
                    break;
                }
                else
                {
                    h.put(row[j],1);
                }
            }
            h.clear();
        }
        return count;
    }

    public static int col_duplicate(int arr[][],int size)
    {
        Hashtable<Integer,Integer> h=new Hashtable<>();
        int count=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                int ele=arr[j][i];
                if(h.containsKey(ele))
                {
                    count++;
                    break;
                }
                else
                {
                    h.put(ele,1);
                }
            }
            h.clear();
        }
        return count;
    }
}
