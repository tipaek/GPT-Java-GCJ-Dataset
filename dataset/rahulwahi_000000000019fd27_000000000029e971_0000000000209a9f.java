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
      
      
      for( int k = 1 ; k <= T ; k++ )
      {
    		 String input = scanner.nextLine();
    		 StringBuilder str = new StringBuilder();
    		 
    		 int offset = 0 ; 
    		 int prev = 0 ;
    		 for( int i = 0 ; i < input.length() ; i++ )
    		 {
    		 	char c = input.charAt(i) ;
    		 	int digit = Character.getNumericValue( c ) ;
    		 	
    			if( digit > prev)
    			{
    				for( int j = 0 ; j < digit - prev ; j++)
    				{
    					str.append("(") ;
    				}
    				str.append( c ) ;
    				prev = digit ;
    			}
    			else if( digit < prev)
    			{
    				int tmp = prev ;
    				for( int j = 0 ; j <  tmp - digit ; j++)
    				{
    					str.append(")") ;
    					prev--;
    				}
    				str.append( c ) ;
    				//prev = prev - digit ;
    			}
    			else
    			{
    				str.append( c ) ;
    			}
    		
    		 	
    		 		
    		 	
    		 }
    		 
    		 for( int i = 0 ;  i < prev ; i++)
    			str.append(")") ;
    		 System.out.println( "Case #" + k + ": " + str ) ;
    		 
    	
    		 
      
      
	}
}
}