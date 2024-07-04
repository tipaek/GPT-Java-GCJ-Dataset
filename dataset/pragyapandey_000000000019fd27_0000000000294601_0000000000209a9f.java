import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws IOException 
	{
	    
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test=Integer.parseInt(br.readLine());
	   // int test;
	   
	   for(int i=0;i<test;i++)
	   {
	       String a=br.readLine();
	    int open=0;
	    int closed=0;
	    System.out.print("Case #"+(i+1)+": ");
	       for(int j=0;j<a.length();j++)
	       {
	          
	           int c=a.charAt(j)-'0';
	          // System.out.println(c);
	         if(j==0){
	           for(int k=0;k<c;k++)
	           {
	               System.out.print("(");
	               open++;
	               
	           }
	         
	              System.out.print(c);
	         }
	        else
	       { if (open-closed>c)
	        {int d=open-closed-c;
	              for(int k=0;k<d;k++)
	           {
	               System.out.print(")");
	               closed++;
	               
	           }}
	            
	            else if(c>0&&open-closed<c)
	            {
	                
	            //    System.out.println("o"+open);
	              //   System.out.println("c"+closed);
	                //  System.out.println("ch"+c);
	                int t=c-(open-closed);
	                 //System.out.println("t"+t);
	                for(int b=0;b<t;b++)
	           {
	               System.out.print("(");
	               open++;
	               
	           } 
	            }
	            
	        System.out.print(c);
	            
	            
	        
	       }
	           
	           
	       }
	   
	       if(open>closed)
	       {
	           for(int m=0;m<open-closed;m++)
	           {
	               System.out.print(")");
	           }
	           
	       }
	        System.out.println();
	   }
	   
	    
	}
}