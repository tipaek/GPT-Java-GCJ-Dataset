
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
	
	 public static boolean  isoverlap(int s1, int e1,int s2,int e2) 
	 {
		 if (s2>=e1) {
			return false;
		}
			 
		else if (e2<=s1){
			return false;
		}
		else {
			return true;
		}   
	    
	 }
	
	 public static void solve(int[] startarr,int[] endarr,int t,int n) {
	     ArrayList<Integer> person1 = new ArrayList<Integer>();
	     ArrayList<Integer> person2 = new ArrayList<Integer>();
	     
	    
	     String result = "";
	     int max1=0;
	     int max2=0;
	     
	     for (int i=0;i<n;i++) {
	    	 
	    	 int condition1 =0;
	    	 int condition2 = 0;
	    	 
	    	 int p1size = person1.size();
	    	 int p2size = person2.size();
	    	 
	    	 for (int j=0;j<p1size;j++) {
	    		 int indexarr = person1.get(j);
	    		 
	    		 int s1 = startarr[i];
	    		 int e1 = endarr[i];
	    		 
	    		 int s2 = startarr[indexarr];
	    		 int e2 = endarr[indexarr];
	    		 
	    		 if (isoverlap(s1, e1,s2,e2)) {
	    			 condition1=1;
	    			 break;
	    		 }
	    		 if (j==0) {
	    			 max1=s1-e2;
	    		 }
	    		 else {
	    			 int num = s1-e2;
	    			 if (num>max1) {
	    				 max1=num;
	    			 }
	    		 }
	    	 }
	    	 
	    	 if (condition1==0) {
	    		 //person1.add(i);
	    		 for (int j=0;j<p2size;j++) {
		    		 int indexarr = person2.get(j);
		    		 
		    		 int s1 = startarr[i];
		    		 int e1 = endarr[i];
		    		 
		    		 int s2 = startarr[indexarr];
		    		 int e2 = endarr[indexarr];
		    		  
		    		 if (isoverlap(s1, e1,s2,e2)) {
		    			 condition2=1;
		    			 break;
		    		 }	
		    		 if (j==0) {
		    			 max2=s1-e2;
		    		 }
		    		 else {
		    			 int num = s1-e2;
		    			 if (num>max2) {
		    				 max2=num;
		    			 }
		    		 }
		    		
		    	 }
	    		 if (condition2==0) {
	    			 if (max1>max2) {
	    				 person2.add(i);
	    			 }
	    			 else {
	    				 person1.add(i);
	    			 }
	    		 }
	    		 else {
	    			 person1.add(i);
	    		 }
	    		 
	    	 }
	    	 else {
	    		 
	    		 for (int j=0;j<p2size;j++) {
		    		 int indexarr = person2.get(j);
		    		 
		    		 int s1 = startarr[i];
		    		 int e1 = endarr[i];
		    		 
		    		 int s2 = startarr[indexarr];
		    		 int e2 = endarr[indexarr];
		    		 
		    		 
		    		 
		    		 if (isoverlap(s1, e1,s2,e2)) {
		    			 condition2=1;
		    			 break;
		    		 }	
		    		 
		    		
		    	 }
	    		 
	    		 if (condition2==0) {
	    			 person2.add(i);
	    		 }
	    		 else {
	    			 result="IMPOSSIBLE";
	    		 }
	    		 
	    	 }
	    	 
	    	 if (result.equals("IMPOSSIBLE")) {
	    		 break;
	    	 }
	    	 
	     }
	     
	     if (!(result.equals("IMPOSSIBLE"))) {
	    	 String str = new String(new char[n]).replace("\0", "o");
			    
			    StringBuilder string = new StringBuilder(str);  
			    
			    for (int i=0;i<person1.size();i++) {
			    	int val1 = person1.get(i);
			    	string.setCharAt(val1, 'C');
			    }
			    
			    for (int i=0;i<person2.size();i++) {
			    	int val1 = person2.get(i);
			    	string.setCharAt(val1, 'J');
			    }
			     
			    result = string.toString();
	     }
	     
	     System.out.println("Case #" + t + ": " + result); 
	     
	     
	    
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
      
      
   
        



