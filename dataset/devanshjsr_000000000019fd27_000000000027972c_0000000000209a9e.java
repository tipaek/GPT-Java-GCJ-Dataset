/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		int b=sc.nextInt();
		//int st=1;
		
		while(t>0)
		{
		    String s1="",s2="",s3="",s4="",s="";
		    
		    
		    if(b==10)
		    {
		        int x=1;
		        while(x<=10)
		    {
		       System.out.println(x);
		       System.out.flush();
		        s1+=sc.next(); 
		        x++;
		    }
		    
		    s=s1;
		        
		    }
		    else
		    {
		        int x=1;
		        
		    
		    
		    while(x<=10)
		    {
		       System.out.println(x);
		       System.out.flush();
		        s1+=sc.next(); 
		        x++;
		    }
		    
		    while(x<=20)
		    {
		       System.out.println(x-5);
		       System.out.flush();
		        s2+=sc.next(); 
		        x++;
		    }
		    
		    while(x<=25)
		    {
		       System.out.println(x-20);
		       System.out.flush();
		        s3+=sc.next(); 
		        x++;
		    }
		    
		    while(x<=30)
		    {
		       System.out.println(x-10);
		       System.out.flush();
		        s4+=sc.next(); 
		        x++;
		    }
		    
		    String s1b=s1.substring(5,10);
		    String s1a=s1.substring(0,5);
		    String s2a=s2.substring(0,5);
		    String s2b=s2.substring(5,10);
		    
		    String s1ar="",s1br="",s1ac="",s1bc="",s1arc="",s1brc="";
		    String s2r="",s2c="",s2rc="";
		    for(int i=0;i<5;i++)
		    {
		        s1ar+=s1a.substring(4-i,5-i);
		    }
		    
		    
		    for(int i=0;i<5;i++)
		    {
		        s1br+=s1b.substring(4-i,5-i);
		    }
		    
		    for(int i=0;i<10;i++)
		    {
		        s2r+=s2.substring(9-i,10-i);
		    }
		    
		    
		    for(int i=0;i<5;i++)
		    {
		        if(s1a.charAt(i)=='1')
		        {
		            s1ac+="0";
		        }
		        else
		        {
		            s1ac+="1";
		        }
		    }
		    
		    for(int i=0;i<5;i++)
		    {
		        if(s1b.charAt(i)=='1')
		        {
		            s1bc+="0";
		        }
		        else
		        {
		            s1bc+="1";
		        }
		    }
		    
		    for(int i=0;i<10;i++)
		    {
		        if(s2.charAt(i)=='1')
		        {
		            s2c+="0";
		        }
		        else
		        {
		            s2c+="1";
		        }
		    }
		    
		    for(int i=0;i<5;i++)
		    {
		        if(s1ar.charAt(i)=='1')
		        {
		            s1arc+="0";
		        }
		        else
		        {
		            s1arc+="1";
		        }
		    }
		    
		    for(int i=0;i<5;i++)
		    {
		        if(s1br.charAt(i)=='1')
		        {
		            s1brc+="0";
		        }
		        else
		        {
		            s1brc+="1";
		        }
		    }
		    
		    for(int i=0;i<10;i++)
		    {
		        if(s2r.charAt(i)=='1')
		        {
		            s2rc+="0";
		        }
		        else
		        {
		            s2rc+="1";
		        }
		    }
		    
		    
		    
		    //n
		    if(s1b.equals(s2a)==true)
		    {
		        if(s1a.equals(s3)==true)
		        {
		             s=s3+s2+s4;
		            
		        }
		        
		        if(s1ar.equals(s4)==true)
		        {
		             s=s3+s2r+s4;
		            
		        }
		        
		        if(s1ac.equals(s3)==true)
		        {
		             s=s3+s2c+s4;
		            
		        }
		        
		        if(s1arc.equals(s4)==true)
		        {
		            s=s3+s2rc+s4;
		          
		        }
		    }
		    
		    //r
		    
		    if(s1br.equals(s2b)==true)
		    {
		        if(s1ar.equals(s4)==true)
		        {
		             s=s3+s2+s4;
		            
		        }
		        
		        if(s1a.equals(s3)==true)
		        {
		             s=s3+s2r+s4;
		            
		        }
		        
		        if(s1arc.equals(s4)==true)
		        {
		             s=s3+s2c+s4;
		          
		        }
		        
		        if(s1ac.equals(s3)==true)
		        {
		             s=s3+s2rc+s4;
		            
		        }
		    }
		    
		    
		    //c
		    
		    if(s1bc.equals(s2a)==true)
		    {
		        if(s1ac.equals(s3)==true)
		        {
		             s=s3+s2+s4;
		           
		        }
		        
		        if(s1arc.equals(s4)==true)
		        {
		             s=s3+s2r+s4;
		  
		        }
		        
		        if(s1a.equals(s3)==true)
		        {
		            s=s3+s2c+s4;
		      
		        }
		        
		        if(s1ar.equals(s4)==true)
		        {
		             s=s3+s2rc+s4;
		            
		        }
		    }
		    
		    //rc
		    
		    if(s1brc.equals(s2b)==true)
		    {
		        if(s1arc.equals(s4)==true)
		        {
		             s=s3+s2+s4;
		           
		        }
		        
		        if(s1ac.equals(s3)==true)
		        {
		             s=s3+s2r+s4;
		           
		        }
		        
		        if(s1ar.equals(s4)==true)
		        {
		             s=s3+s2c+s4;
		            
		        }
		        
		        if(s1a.equals(s3)==true)
		        {
		             s=s3+s2rc+s4;

		        }
		    }
		    }
		    
		    		System.out.println(s);
		            System.out.flush();
		    
		            String ans=sc.next();
		    
        		    if(ans.equals("N")==true)
        		    {
        		        break;
        		    }
        		    
        		   t--;
        		   
		    
		    
		}
	}
}
