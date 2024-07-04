import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int i, j;
		for(i=1;i<=t;i++)
		{
		    int n = Integer.parseInt(br.readLine());
		    String ar[] = new String[n];
		    int len[] = new int [n];
		    int min = (int)Math.pow(10,4);
		    int pos=0, pos1=0, f = 0, flag = 0, max = 0;
		    for(j=0;j<n;j++)
		    {
		        ar[j] = br.readLine();
		        
		        len[j] = ar[j].length();
		        char d = ar[j].charAt(0);
		        if(len[j] < min)
		        {
		            min = len[j];
		            pos = j;
		        }
		        if(len[j] > max)
		        {
		            max = len[j];
		            pos1 = j;
		        } 
		        if(d == '*')
		            f++;
		    }
		    if (f == n)
		    {
		        String mat = ar[pos];
		        int k;
		        char g = mat.charAt(min-1);
	       
		            for(k=1;k<max;k++)
		            {
		                for(j=0;j<n;j++)
		                {
		                    String h = ar[j];
		                    int l = h.length();
		                    if (l >= k)
		                    {
		                        if ((h.charAt(l-k) != g) && (h.charAt(l-k) != '*'))
		                            flag = 1;
		                    }
		                }
		             }
		            if (flag == 0)
		                System.out.println("Case #"+i+": "+ar[pos1].substring(1));
		       }  
		}
	}
}