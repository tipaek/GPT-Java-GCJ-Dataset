import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args)
    {
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            eachCase(i);
        }
    }
    static void eachCase(int testCaseNumber)
    {
        int n=sc.nextInt();
        int[][] mat1=new int[n][n],mat2= new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                mat1[i][j]=sc.nextInt();
                mat2[j][i]=mat1[i][j];
            }
        }
        int k=0;
        for(int i=0;i<n;i++)
        {
            k+=mat1[i][i];
        }
        int r=0;
        for(int i=0;i<n;i++)
        {
            if(check(mat1[i]))
                r++;
        }
        int c=0;
        for(int i=0;i<n;i++)
        {
            if(check(mat2[i]))
                c++;
        }
        System.out.println("Case #"+(testCaseNumber)+": "+k+" "+r+" "+c);
    }

    static boolean check(int a[])
    {
        int[] freq=new int[a.length];
        for(int i=0;i<a.length;i++)
        {
            freq[a[i]-1]++;
        }
        for(int i=0;i<freq.length;i++)
        {
            if(freq[i]>1)
                return true;
        }
        return false;
    }
}
