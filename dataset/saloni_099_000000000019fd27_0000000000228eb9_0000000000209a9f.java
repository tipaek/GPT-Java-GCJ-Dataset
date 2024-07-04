
import java.util.*;

import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution  
{
	
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in=new Scanner(System.in);
		
		int T=in.nextInt();
		for(int i=0;i<T;i++){
		    String s=in.next();
		    
		    String ans="";
		    int depth=0;
		    
		    for(int j=0;j<s.length();j++) {
		    	int x=Integer.valueOf(s.substring(j, j+1));
		    	
		    	
		    	
		    	if(x==depth) {
		    		ans=ans+Integer.toString(x);
		    	}
		    	else if(x>depth) {
		    		for(int k=0;k<(x-depth);k++) {
		    			ans=ans+"(";
		    		}
		    		depth=x;
		    		ans=ans+Integer.toString(x);
		    		
		    	}
		    	else if(x<depth) {
		    		
		    		for(int k=0;k<(depth-x);k++) {
		    			ans=ans+")";
		    		}
		    		depth=x;
		    		ans=ans+Integer.toString(x);
		    		
		    		
		    	}
		    	
		    }
		    		
		    for(int h=0;h<depth;h++) {
    			ans=ans+")";
    		}   
		    
		    
		System.out.println("Case #" + (i+1) + ": " + (ans));
		 
		    
		}    
		
	}
}
