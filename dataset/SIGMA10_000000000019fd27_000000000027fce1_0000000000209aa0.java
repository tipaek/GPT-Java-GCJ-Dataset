

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		int sum=0;
		
		Scanner s=new Scanner(System.in);
	     int t=s.nextInt();
	     int yo=0;
	     int[] n=new int[t];
	     int[] so=new int[t];
	     while(yo<t)
	     {
	    	 n[yo]=s.nextInt();
	    	 so[yo]=s.nextInt();
	         yo++;
	     }
	    int i=1;
	     while(i<=t)
	     {
	    	
	    	 int[][] arr=new int[n[i-1]][n[i-1]];
	    	
	    	 for(int j=0;j<n[i-1];j++)
	    	 {
	    		sum=j+1;
	    		 for(int k=0;k<n[i-1];k++)
	    		 {
	    			if(sum<=n[i-1])
	    			 {
	    				arr[k][j]=sum++;
	    			 }
	    			else
	    			{
	    				arr[k][j]=1;
	    				sum=2;
	    			}
	    		 }
	    	 }
	    	
	    	 int sos=0;
	    	 for(int j=0;j<n[i-1];j++)
	    	 {
	    		
	    		 for(int k=0;k<n[i-1];k++)
	    		 {
	    			if(j==k)
	    			sos=sos+arr[j][k];
	    		 }
	    		 
	    	 }
	    	 
	   	 if(sos==so[i-1]) {
	    	 
	    	 System.out.println("Case #"+i+":"+" POSSIBLE");
	   	     
	   	 
	    	  for(int j=0;j<n[i-1];j++)
	    	 {
	    		 for(int k=0;k<n[i-1];k++)
	    		 {
	    			System.out.print(arr[j][k]+" ");
	    		 }
	    	     System.out.println();
	    	 }
	    
	     }
	    	 else
	    	 {
	    		 System.out.println("Case #"+i+":"+" IMPOSSIBLE");
	    	      for(int j=0;j<n[i-1];j++)
	    	 {
	    		 for(int k=0;k<n[i-1];k++)
	    		 {
	    			System.out.print(arr[j][k]+" ");
	    		 }
	    	     System.out.println();
	    	 }
	    	     
	    	 }
	         i++;
	     
	     }
		

	}

}
