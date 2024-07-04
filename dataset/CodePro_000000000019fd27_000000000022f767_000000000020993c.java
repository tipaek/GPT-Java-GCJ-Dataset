import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
    //  int m = in.nextInt();
		 int [][] myArray = new int[n][n];

      
      for(int f =0; f<n; f++) {
	 		for (int j=0; j<n; j++) {
	 			myArray[f][j]=in.nextInt();
	 		}
	 	}
 
		
	     int [][] a = new int[n][n];
	     int [][] a2 = new int[n][n];
        
	   
       	
	     
	     for(int j=0; j<n; j++) {
	    	 for(int p=0; p<n; p++) {
	    		 
	    	int x=myArray[j][p];
	    	a[j][x-1]++;
	    	 
	    	 }
	    	 
	    	 }
	     for(int j=0; j<n; j++) {
	    	 for(int p=0; p<n; p++) {
	    		 
	    	int x=myArray[p][j];
	    	a2[x-1][j]++;
	    	 
	    	 }
	    	 
	    	 }
	    
	     int nrows=0;   
	     int flag=0;
	     for(int j=0; j<n; j++) {
	    	 flag=0;
	    	 for(int p=0; p<n; p++) {
	           if(a[j][p]>1) {
	            flag=1;
	           }
	    
	    	 }
	    	 if (flag==1) {nrows++;}
	    	 }  

		  int ncol=0;   
		  int flag2=0  ; 
		  for(int j=0; j<n; j++) {
		    	flag2=0; 
			  for(int p=0; p<n; p++) {
		           if(a2[p][j]>1) {
                        flag2=1;
		           }
		   
		    	 }
		    	 if (flag2==1) {ncol++;}

		    	 } 
      
      
		     int digSum=0;
			  for(int o=0; o<n;  o++) {
				  digSum+=myArray[o][o];
			  }
      
      
      
      System.out.println("Case #" + i + ": " +digSum+" "+ (nrows) + " " + (ncol));
    
    
    
    
    }
   
  
}}
