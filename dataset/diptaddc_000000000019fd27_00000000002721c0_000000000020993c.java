import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    for(int testCase = 1; testCase <= t; testCase++)
	    {
	        int k = 0;
	        int r = 0;
	        int c = 0;
	        
	        int n = Integer.parseInt(br.readLine());
	        
	        int [][] arr = new int [n][n];
	        for(int i =0; i<n; i++)
	        {
	            String [] line = br.readLine().split(" ");
	            HashSet<Integer> set = new HashSet<Integer>();
	            for(int j=0 ;j<n ;j++)
	            {
	                int x = Integer.parseInt(line[j]);
	                if(set.contains(x))
	                    r++;
	                else
	                    set.add(x);
	                arr[i][j] = x;
	            }
	        }
	        for(int i =0; i<n; i++)
	        {
	            HashSet<Integer> set = new HashSet<Integer>();
	            for(int j=0 ;j<n ;j++)
	            {
	                if(i == j)
	                    k += arr[j][i];
	                
	                if(set.contains(arr[j][i]))
	                    c++;
	                else
	                    set.add(arr[j][i]);
	            }
	        }
	        
	        System.out.println("Case #" + testCase + ": " + k + " " + r + " " + c);
	    }
	}
}