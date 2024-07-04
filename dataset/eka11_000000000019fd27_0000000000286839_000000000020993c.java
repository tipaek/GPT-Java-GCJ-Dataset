import java.util.*;
import java.io.*;
import java.util.HashSet;

public class Solution
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    
		int T = input.nextInt();
		
		for(int t=0;t<T;t++)
		{
		    int n, i, j, k=0, c=0, r=0;
		    n = input.nextInt();
		    int mat[][] = new int[n][n];
		    
		    for(i=0;i<n;i++)
		    {
		        HashSet<Integer> h = new HashSet<Integer>();
		        for(j=0;j<n;j++)
		        {
		            mat[i][j] = input.nextInt();
		            h.add(mat[i][j]);
		            if(i==j)
		                k += mat[i][j];
		        }
		        if(h.size()!=n)
		        {
		            r++;
		        }
		        
		    }
		            
		    
		    for(i=0;i<n;i++)
		    {
		        HashSet<Integer> h = new HashSet<Integer>();
		        for(j=0;j<n;j++)
		        {
		            h.add(mat[j][i]);
		        }
		        if(h.size()!=n)
		        {
		            c++;
		        }
		    }
		    
		    System.out.println("Case #" + (t+1) + ": " + k + " " + r + " " + c);
		    
		}
		
	}
}
