import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
{
	public static void main (String[] args)
	{
		Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++)
        {
            int j, k, l, n=s.nextInt(), sum=0, r=0, c=0;
            int[][] arr=new int[n][n];
            for(j=0;j<n;j++)
            {
                Set<Integer> sr=new HashSet<Integer>();
                for(k=0;k<n;k++)
                {
                    arr[j][k]=s.nextInt(); 
                    sr.add(arr[j][k]);
                    if(j==k)
                    {
                        sum+=arr[j][k];
                    }
                }
                if(sr.size()!=n)
                {
                    r++;
                }
            }
            
            int m=0;
            while(m!=n)
            {
                Set<Integer> sc=new HashSet<Integer>();
                for(l=0;l<n;l++)
                {
                    sc.add(arr[l][m]);
                }
                m++;
                if(sc.size()!=n)
                {
                    c++;
                }
            }
            System.out.println("Case #"+(i+1)+": "+sum+" "+r+" "+c);
        }
	}
}
