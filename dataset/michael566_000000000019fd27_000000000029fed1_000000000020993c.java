package com.google;
import java.io.*;
import java.util.*;
 
 
public class Main{
   public static void main(String[] args) {
	   
      Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

//   
//      MyScanner sc = new MyScanner();
//      out = new PrintWriter(new BufferedOutputStream(System.out));
  
      
      int t = sc.nextInt () ;

      
      for ( int m = 1 ; m <= t ; m ++ ) {
          int n = sc.nextInt (); 

          int [][] a = new int [n][n]; 
    	   
    	  for ( int i = 0 ; i < n; i ++ ) {
        	  
        	  for ( int j = 0 ; j < n ; j ++ ) {
        	  
        		  int l = sc.nextInt () ;
        	 
        		  a [i][j] = l ;  
        	  }
        	  
          }
    	  
for ( int i = 0 ; i < n; i ++ ) {
        	  
        	  for ( int j = 0 ; j < n ; j ++ ) {
        	  
        		  System.out.print ( a [i] [j] ) ;   
        	  }
        	  
        	  System.out.println (  ) ;
          }
    	 
    	  int k = 0 ; 
    	  int r = 0 ; 
    	  int c = 0 ;

          for ( int i = 0 ; i < n; i ++ ) {
        	  
        	  for ( int j = 0 ; j < n ; j ++ ) {
        		  
        		  
        		  
        		  if ( i == j ) {
        			  
        			  k +=  a[i] [j]   ; 
        			  
        		  }
        	  }        	  
          }
          
          for ( int i = 0 ; i < n; i ++ ) {
        	  
        	  for ( int j = 0 ; j < n ; j ++ ) {
        		   
        		  for ( int p = i + 1 ; p < n ; p ++ ) {
        			  
            		  if ( a [i][p] ==  a [i][j] ) {
            			  
            			  c ++ ; 
            			  break ; 
            		  }  				  
        		  }
        		
        		  
        	  }	  
        	  
          }
          
          for ( int j = 0 ; j < n; j ++ ) {
        	  
        	  for ( int i = 0 ; i < n ; i ++ ) {
        		  
        		
        				  
        		  for ( int p = j + 1 ; p < n ; p ++ ) {
        			  
            		  if ( a [i][p] ==  a [i][j] ) {
            			  
            			  r ++ ; 
            			  break ; 
            		  }  				  
        		  }
        		
        		  
        	  }	  
        	  
          }
    	  
     	 	
          System.out.println("Case #" + m + ": " + k + " " + r + " " + c );
      
      
      }
      
      
      

      // Stop writing your solution here. -------------------------------------
     	 sc.close();
      }
   }

     

	
   
   //--------------------------------------------------------

