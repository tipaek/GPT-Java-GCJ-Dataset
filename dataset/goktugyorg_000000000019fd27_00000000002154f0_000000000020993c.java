import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        
        for (int i = 1; i <= t; ++i) 
        {	
        	int n = in.nextInt();
        	int[][] m = new int[n][n];
        	
        	int trace = 0;
        	int r = 0;
        	int c = 0;
        	HashSet<Integer> hs = new HashSet<Integer>();

        	for (int j = 0; j < n; j++) 
        	{
				for (int k = 0; k < n; k++) 
				{
					m[j][k] = in.nextInt();
					
					hs.add(m[j][k]);
					trace += j==k ? m[j][k] : 0;
				
				}
				r += n == hs.size() ? 0 : 1;
				hs = new HashSet<Integer>();
        	}
        	
        	for (int j = 0; j < n; j++) 
        	{
        		for (int k = 0; k < n; k++) 
        		{
        			hs.add(m[k][j]);
				}
        		c += n == hs.size() ? 0 : 1;
        		hs = new HashSet<Integer>();
			}
        	System.out.println("Case #" + i +": " + trace + " " + r + " " + c);
        }
        in.close();
    }
}