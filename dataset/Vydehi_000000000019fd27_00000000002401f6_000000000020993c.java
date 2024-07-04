import java.util.*;
import java.io.*;

class latin
{
    public static void main(String args[])
    {
        Scanner s =new Scanner(System.in);
        int t= s.nextInt();
        if(t>=1 && t<=100)
        {
        for(int i=0;i<t;i++)
        {
        int n = s.nextInt();
        if(n>=2 && n<=100)
        {
        int[][] arr = new int[n][n];
        int countr=0,countc=0,j=0,k=0,a1;
        while(j<n)
        {
            while(k<n)
            {
                a1=s.nextInt();
                if(a1>=1 && a1<=n)
                {
                  arr[j][k]=a1;
                  //System.out.println(arr[j][k]);
                  k++;
                }
            }
            k=0;
            j++;
        }
        int trace=0;
        for(int l=0;l<n;l++)
        {
            trace+=arr[l][l];
        }
        for(j=0;j<n;j++)
        {
            Set<Integer> se = new HashSet<Integer>();
            Set<Integer> sec = new HashSet<Integer>();
            for(k=0;k<n;k++)
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
    }
}