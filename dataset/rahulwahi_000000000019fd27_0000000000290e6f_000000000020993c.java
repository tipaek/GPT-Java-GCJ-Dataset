/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		 Scanner scanner = new Scanner(System.in);
    	int T ;
      T = Integer.parseInt(scanner.nextLine());
      
      
      for( int i = 1 ; i <= T ; i++ )
      {
    		 int N = scanner.nextInt();
    		 int K = 0 , r = 0 , c = 0 ;
    		 
    		 //System.out.println(N) ;
    		 int[][] matix = new int[N][N];
    		 
    		 
    		 for( int j = 0 ; j < N ; j++ )
    		 {
    		 	boolean flag = false ;
    		 	Set<Integer> distinct = new HashSet<>() ;
    		 	for( int k = 0 ; k < N ; k++ )
    		 	{
    		 		matix[j][k] = scanner.nextInt();
    		 		if( distinct.contains( matix[j][k] ) )
    		 		{
    		 			flag = true ;
    		 		}
    		 		distinct.add( matix[j][k] ) ;
    		 		
    		 		if( k == j )
    		 			K = K + matix[j][k] ;
    		 	}
    		 
    		 
    		 if( flag )
    			r++;
    		 }
    		 
    		 for( int j = 0 ; j < N ; j++ )
    		 {
    		 	Set<Integer> distinct = new HashSet<>() ;
    			boolean flag = false ;
    		 	for( int k = 0 ; k < N ; k++ )
    		 	{
    		 		
    		 		if( distinct.contains( matix[k][j] ) )
    		 		{
    		 			flag = true ;
    		 		}
    		 		distinct.add( matix[k][j] ) ;
    		 	}
    		 	
    		    
    		    if( flag )
    				c++;
    		 
    		 }
    		 
             System.out.println("Case #" + i + ": "+ K + " " + r + " " + c ) ;	 
    	
	}
    		
      
      
	}
}