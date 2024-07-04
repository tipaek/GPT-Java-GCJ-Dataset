/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
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
    		// System.out.println(N) ;
    		 int[][] activites = new int[N][3];
    		 //Map<String , String> map = new HashMap<>() ;
    		 
    		 boolean flag = false ;
    		 for( int j = 0 ; j < N ; j++ )
    		 {
    		 
    		 	Set<Integer> distinct = new HashSet<>() ;
    		    activites[j][0] = scanner.nextInt() ;
    		    activites[j][1] = scanner.nextInt() ;
    		    activites[j][2] = j ;
    		    
    		    
    		    
    		 }
    		 
    		 Arrays.sort(activites , (a,b) -> { return a[0] - b[0] ; } ) ;
    		 
    		
    		 
    		 int cEndTime = 0 , jEndTime = 0 ;
    		 char[] result = new char[N] ;
    		 for( int j = 0 ; j < N  ; j++ )
    		 {
    		 	if( activites[j][0] >=  cEndTime )
    		 	{
    		 		result[ activites[j][2] ] = 'c' ;
    		 		cEndTime = activites[j][1] ;
    		 		//map.put( "" + activites[0][j] +activites[0][j] ,  "j")  ;
    		 	}
    		 	else if ( activites[j][0] >=  jEndTime)
    		 	{
    		 		result[ activites[j][2] ] = 'j' ;
    		 		jEndTime = activites[j][1] ;
    		 	}
    		 	else
    		 	{
    		 		flag = true ;
    		 		break ;
    		 	}
    		 }
    		 
    		
    		 if( flag )
    		 {
    		 	System.out.println("Case #" + i + ": "+ "IMPOSSIBLE") ;
    		 }
    		 else
    		 {
    		 	
    		 	String res =  new String( result );
    		 	System.out.println( "Case #" + i + ": "+ result ) ;
    		 }
    		 	 
    	
	}
    		
      
      
	}	
}