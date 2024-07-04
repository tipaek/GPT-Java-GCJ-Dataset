import java.util.*;
import java.io.*;

public class latin
{
    public static void main(String args[])
    {
        Scanner s =new Scanner(System.in);
        int t= s.nextInt();
        for(int i=0;i<t;i++)
        {
        int n = s.nextInt();
        int[][] arr = new int[n][n];
        int countr=0,countc=0;
        for(int j=0;j<n;j++)
        {
            for(int k=0;k<n;k++)
            {
                arr[j][k]=s.nextInt();
            }
        }
        int trace=0;
        for(int l=0;l<n;l++)
        {
            trace+=arr[l][l];
        }
        for(int j=0;j<n;j++)
        {
            Set<Integer> se = new HashSet<Integer>();
            Set<Integer> sec = new HashSet<Integer>();
            for(int k=0;k<n;k++)
            {
                Integer a = new Integer(arr[j][k]);
                Integer b = new Integer(arr[k][j]);
                se.add(a);
                sec.add(b);
            }
            if(se.size()<n)
            {
                countr++;
            }
            if(sec.size()<n)
            {
                countc++;
            }
        }
        System.out.println("Case #" + (i+1) +": "+trace+" "+countr+" "+countc);
        }
    }
}