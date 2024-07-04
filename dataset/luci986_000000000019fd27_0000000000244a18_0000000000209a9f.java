/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
    
    
    	    

    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		int sss=1;
		in.nextLine();
		while(t>0)
		{
		    
		    
		    String s=in.nextLine();
		   System.out.print("Case #"+sss+": ");
	        String ss="";
	        int cd=s.charAt(0)-48;
	
	        for(int i=0;i<cd;i++)
	        {
	            //System.out.print("(");
	            ss+="(";
	        }
	        
	        ss+=cd;
	        //System.out.print(cd);
	
	
	
	        for(int i=1;i<s.length();i++)
	        {
	            if(s.charAt(i)-48>=cd)
	            {
	                for(int j=0;j<(s.charAt(i)-48)-cd;j++)
	                {
	                    //System.out.print("(");
	                    ss+="(";
	                }
	                //System.out.print(s.charAt(i)-48);
	                ss+=s.charAt(i);
	                cd=s.charAt(i)-48;
	            }
	            
	            else
	            {
	                
	                for(int j=0;j>(s.charAt(i)-48)-cd;j--)
	                {
	                   // System.out.print(")");
	                    ss+=")";
	                }
	               // System.out.print(s.charAt(i)-48);
	               ss+=s.charAt(i);
	                cd=s.charAt(i)-48;
	            }
	        }
	        
	        
	        for(int i=0;i<cd;i++)
	        {
	            //System.out.print(")");
	            ss+=")";
	        }
	        
	        System.out.println(ss.trim());
	
	
	
	 
		    sss++;
	
	
		 
		    t--;
		}
	}
}
