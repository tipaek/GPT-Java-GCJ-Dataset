/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Solution
{
	public static void main(String[] args) {
	
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    String str;
	    String req="";
	    
	    sc.nextLine();
	    str=sc.nextLine();
	    int k,i,asc,co=0,r;
	    char ch,ch1='(',ch2=')';
	    for(k=0;k<str.length();k++)
	    {
	        ch=str.charAt(k);
	        asc=ch-'0';
	        for(i=0;i<asc;i++)
	        {
	            co++;
	            req=req+ch1;
	        }
	        req=req+ch;
	        i=k+1;
	        while(i<str.length() && str.charAt(i)==ch)
	        {
	            req=req+str.charAt(i);
	            i++;
	        }
	        
	        while(i<str.length() && str.charAt(i)<=ch)
	        {
	        
	            asc=str.charAt(i)-'0'-co;
	            if(asc>=0)
	            {
	                while(asc-->0)
	                {
	                    req=req+ch1;
	                    co++;
	                }
	            }
	            else
	            {
	                asc=str.charAt(i-1)-str.charAt(i);
	            while(asc-->0)
	            {
	                req=req+ch2;
	                co--;
	            }
	            }
	            req=req+str.charAt(i);
	            i++;
	        }
	        r=co;
	        while(r-->0)
	        {
	            req=req+ch2;
	            co--;
	        }
	        
	        k=i-1;
	    }
	    System.out.println("Case #1: "+req);
	    for(int m=1;m<t;m++)
	    {
	        str=sc.nextLine();
	        co=0;
	        req="";
	        for(k=0;k<str.length();k++)
	    {
	        ch=str.charAt(k);
	        asc=ch-'0';
	        for(i=0;i<asc;i++)
	        {
	            co++;
	            req=req+ch1;
	        }
	        req=req+ch;
	        i=k+1;
	        while(i<str.length() && str.charAt(i)==ch)
	        {
	            req=req+str.charAt(i);
	            i++;
	        }
	        
	        while(i<str.length() && str.charAt(i)<=ch)
	        {
	        
	            asc=str.charAt(i)-'0'-co;
	            if(asc>=0)
	            {
	                while(asc-->0)
	                {
	                    req=req+ch1;
	                    co++;
	                }
	            }
	            else
	            {
	                asc=str.charAt(i-1)-str.charAt(i);
	            while(asc-->0)
	            {
	                req=req+ch2;
	                co--;
	            }
	            }
	            req=req+str.charAt(i);
	            i++;
	        }
	        r=co;
	        while(r-->0)
	        {
	            req=req+ch2;
	            co--;
	        }
	        
	        k=i-1;
	    }
	    System.out.println("Case #"+(m+1)+": "+req);
	    
	    }
	    sc.close();
	}
}
