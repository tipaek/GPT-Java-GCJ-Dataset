/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
 public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc =new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int i =0;i<t;i++){
		    	int n = sc.nextInt();
		    	int arr[][] =new int [n][n];
		    	for(int p =0;p<n;p++){
		    	    for(int q =0;q<n;q++){
		    	        arr[p][q] = sc.nextInt();
		    	    }
		    	}
		    	
		    	int sum =0;
		    	for(int p=0;p<n;p++){
		    	    sum = sum + arr[p][p];
		    	}
		    	
		    	int dup_r =0;
		    
		    
		    for(int p =0;p<n;p++){
		        HashSet<Integer> h = new HashSet<Integer>();
		    	    for(int q =0;q<n;q++){
		    	        h.add(arr[p][q]);
		    	    }
		    	    if(n!=h.size())
		    	     dup_r++;
		    	}
		    	
		    	
		    	int dup_c =0;
		    
		    
		    for(int p =0;p<n;p++){
		        HashSet<Integer> h = new HashSet<Integer>();
		    	    for(int q =0;q<n;q++){
		    	        h.add(arr[q][p]);
		    	    }
		    	    if(n!=h.size())
		    	     dup_c++;
		    	}
		    
		    System.out.println("Case #" + (i+1) + ": " +sum +" "+ dup_r+" "+dup_c);
		    
		}
	}
}
