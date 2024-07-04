import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

class Solution
{
    static Scanner sc = new Scanner (System.in);
    public static void main(String args[])
    {
        int T=sc.nextInt();
        for(int z=1;z<=T;z++)
        
        {
            int size=sc.nextInt();
            int mat[][]=new int[size][size];

            for(int i=0;i<size;i++)
            {
                for(int j=0;j<size;j++)
                {
                    mat[i][j]=sc.nextInt();
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
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        int count=0;
        for(int i=0;i<size;i++)
        {
            int row[]=arr[i];
            for(int j=0;j<row.length;j++)
            {
                if(hmap.containsKey(row[j]))
                {
                    count++;
                    break;
                }
                else
                {
                    hmap.put(row[j],1);
                }
            }
            hmap.clear();
        }
        return count;
    }
    
    public static int col_duplicate(int arr[][],int size)
    {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        int count=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                int dis=arr[j][i];
                if(hmap.containsKey(dis))
                {
                    count++;
                    break;
                }
                else
                {
                    hmap.put(dis,1);
                }
            }
            hmap.clear();
        }
        return count;

    }
}