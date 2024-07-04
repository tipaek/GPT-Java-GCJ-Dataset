import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int z=1;z<=t;z++)
        {
            int n=in.nextInt();
            int arr[][]=new int[n][n];
            int r=0;
            int c=0;
            int k=0;
            int flag=0;
            HashSet<Integer> hs=new HashSet<Integer>();
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=in.nextInt();
                    if(i==j)
                    {
                        k+=arr[i][j];
                    }
                    if(hs.contains(arr[i][j])&&flag==0)
                    {
                        r++;
                        flag=1;
                    }
                    else
                    {
                        hs.add(arr[i][j]);
                    }
                }
                hs.clear();
                flag=0;
            }
            for(int j=0;j<n;j++)
            {
                for(int i=0;i<n;i++)
                {
                    if(hs.contains(arr[i][j])&&flag==0)
                    {
                        c++;
                        flag=1;
                    }
                    else
                    {
                        hs.add(arr[i][j]);
                    }
                }
                hs.clear();
                flag=0;
            }
            System.out.println("Case #"+z+": "+k+" "+r+" "+c);
        }
    }
}