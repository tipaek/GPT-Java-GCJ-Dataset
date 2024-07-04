

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	private static Scanner sc;
	static int tn = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        sc = new Scanner(System.in);
       
       int t = sc.nextInt();
       sc.nextLine();
       
       while(t-- > 0)
       {
    	   solve();
       }
       
	}
	
	private static void solve()
	{
		
		int size = sc.nextInt();
	    int[][] mat = new int[size][size];
	    int k = 0;
	    
	    for(int i = 0; i<mat.length; i++)
	    {
	    	for(int j = 0; j<mat[i].length; j++)
	    	{
	    		mat[i][j] = sc.nextInt();
	    		if(i == j) k += mat[i][j];
	    	}
	    }
	    
	    int r = getR(mat);
	    int c = getC(mat);
	    
	    System.out.println("Case #" + (tn++) + ": " + k + " " + r + " " + c);
	}
	
	private static int getR(int[][] mat) 
	{
		int rec = 0;
		
		for(int i = 0; i<mat.length; i++) 
		{
			Set<Integer> set = new HashSet<>();
			
			for(int j = 0; j<mat[i].length; j++) 
			{
				if(set.contains(mat[i][j]))
				{
					rec ++;
					break;
				}
				set.add(mat[i][j]);
			}
		}
		
		return rec;
	}
	
	private static int getC(int[][] mat) 
	{
		int rec = 0;
		
		for(int i = 0; i<mat.length; i++)
		{
			Set<Integer> set = new HashSet<>();
			for(int j = 0; j<mat[i].length; j++)
			{
				if(set.contains(mat[j][i]))
				{
					rec ++;
					break;
				}
				set.add(mat[j][i]);
			}
		}
		
		return rec;
	}

}
