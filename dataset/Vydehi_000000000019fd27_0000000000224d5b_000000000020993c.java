import java.util.*;
import java.io.*;

class latin
{
    public static void main(String args[])
    {
        Scanner s =new Scanner(System.in);
        int t= s.nextInt();
        for(int i=0;i<t;i++)
        {
        int n = s.nextInt();
        int[][] arr = new int[n][n];
        int countr,countc;
        for(int j=0;j<n;j++)
        {
            for(int k=0;k<n;k++)
            {
                arr[j][k]=s.nextInt();
            }
        }
        int trace;
        for(int l=0;l<n;l++)
        {
            trace=arr[l][l];
        }
        for(int j=0;j<n;j++)
        {
            Set<Integer> se = new HashSet<Integer>();
            Set<Integer> sec = new HashSet<Integer>();
            for(int k=0;k<n;k++)
            {
                se.add(arr[j][k]);
                sec.add(arr[k][j]);
            }
            if(se.length<n)
            {
                countr++;
            }
            if(sec.length<n)
            {
                countc++;
            }
        }
        System.out.println("Case #" + i +": "+trace+" "+countr+" "+countc);
        }
    }
}