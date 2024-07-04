


import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class Solution {
	
	
	
	
	 public static void solve(int[] startarr,int[] endarr,int t,int n) {
	     ArrayList<Integer> person1 = new ArrayList<Integer>();
	     ArrayList<Integer> person2 = new ArrayList<Integer>();
	     
	     ArrayList<Integer> arrstsort = new ArrayList<Integer>();
	     ArrayList<Integer> arrendsort = new ArrayList<Integer>();
	     
	     String result = "";
	     
	     for (int i = 0 ;i<n;i++) {
	    	 if (i==0) {
	    		 arrstsort.add(startarr[0]);
	    		 arrendsort.add(endarr[0]);
	    	 }
	    	 else {
	    		 int sizen = arrstsort.size();
		    	 
		    	 int val1 = startarr[i];
		    	 int condition = 0;
		    	 for (int j=0;j<sizen;j++) {
		    		 int val2 = arrstsort.get(j);
		    		 if (val1<=val2) {  
		    			 arrstsort.add(j,startarr[i]);
			    		 arrendsort.add(j,endarr[i]);
			    		 condition=1;
			    	     break; 
		    		 }
		    	 }
		    	 if (condition==0) {
		    		 arrstsort.add(startarr[i]);
		    		 arrendsort.add(endarr[i]); 
		    	 }
	    	 }
	    	 
	     }
	     
	     
	     for (int i = 0;i<n;i++)
	     {
	    	 if (i==0) {
	    		 person1.add(0);
	    	 }
	    	 
	    	 else {
	    		 int p1size = person1.size();
	    		 int p2size = person2.size();
	    		 
	    		 //person1
	    		 int valp1 = person1.get(p1size-1);
	    		 int e2 = arrendsort.get(valp1);
	    		 int s1 = arrstsort.get(i);
	    		 if (s1>=e2) {
	    			 person1.add(i);
	    		 }
	    		 else {
	    			 if (p2size==0) {
	    				 person2.add(i);
	    			 }
	    			 else {
	    				 int valp2 = person2.get(p2size-1);
	    				 int e3 = arrendsort.get(valp2);
	    				 
	    				 if (s1>=e3) {
	    					 person2.add(i);
	    				 }
	    				 else {
	    					 result = "IMPOSSIBLE";
	    					 break;
	    				 }
	    			 }
	    		 }
	    		
	    		 
	    	 }
	     }
	    
	     if (result.equals("IMPOSSIBLE")) {
			   System.out.println("Case #" + t + ": " + result);
		   }
		   
		   else {
			   String str = new String(new char[n]).replace("\0", "o");
			    
			    StringBuilder string = new StringBuilder(str);  
			    
			    for (int i=0;i<person1.size();i++) {
			    	int vv1 = person1.get(i);
			    	
			    	int ss1 = arrstsort.get(vv1);
			    	int ee1 = arrendsort.get(vv1);
			    	
			    	
			    
			    	int ind1 = 0;
			    	for (int k =0 ; k<n;k++) {
						 if (ss1==startarr[k]) {
							 if (ee1==endarr[k]) {
								 startarr[k]=0;
								 endarr[k]=0;
								 ind1=k;
								 break;
							 }
						 }
					 }
			    	
			    	
			    	string.setCharAt(ind1, 'C');
			    }
			    
			    for (int i=0;i<person2.size();i++) {
			    	int vv1 = person2.get(i);
			    	
			    	int ss1 = arrstsort.get(vv1);
			    	int ee1 = arrendsort.get(vv1);
			    	
			    	int ind1 = 0;
			    	for (int k =0 ; k<n;k++) {
						 if (ss1==startarr[k]) {
							 if (ee1==endarr[k]) {
								 startarr[k]=0;
								 endarr[k]=0;
								 ind1=k;
								 break;
							 }
						 }
					 }
			    	
			    	string.setCharAt(ind1, 'J');
			    }
			     
			    result = string.toString();
			     
			    
				
				 System.out.println("Case #" + t + ": " + result); 
		   }
	    
	    
	 }
	         
	     
	  
    
    
    
     public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        
        for (int k = 1; k <= t; ++k) {
            int n = in.nextInt();
            
            int[] startarr = new int[n];
            int[] endarr = new int[n];
            
            for (int i=0;i<n;i++){
            	 int s2 = in.nextInt();
                 int e2 = in.nextInt();
                 
                 startarr[i]=s2;
                 endarr[i]=e2;           
            }
            
            
            
                
            solve(startarr,endarr,k,n);	
        }
            
         in.close();  
          
    }
}
      
      
   
        



