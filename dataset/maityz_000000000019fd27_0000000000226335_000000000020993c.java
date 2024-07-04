import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	   try{
		int tt,li=1;
		//System.out.println("e"); 
		tt=Integer.parseInt(in.readLine());
		while(tt-->0)
		{
		    int n,s=0,r=0,cc=0,i,j,l;
		    n=Integer.parseInt(in.readLine());
		    int a[][]=new int[n][n];
		   
		
		
		for(i=0;i<n;i++)
		for(j=0;j<n;j++)
		a[i][j]=Integer.parseInt(in.readLine());;
		
		for(i=0;i<n;i++)
		s+=a[i][i];
		String ss="",s1="";
	    for(i=0;i<n;i++)
	    {
		   for(j=0;j<n;j++)
		     {
		     	ss+=Integer.toString(a[i][j]);
		      }
		   for(j=0;j<ss.length();j++)
		   { 
		     char c=ss.charAt(j);
		     if(s1.indexOf(c)<0)
		       s1+=c;
		   }
		   if(s1.length()!=ss.length())
		    r++;
		    s1="";ss="";
         //System.out.println("Case #: "+a+" "+b);
         //System.out.println(r);
     }
     for(i=0;i<n;i++)
	    {
		   for(j=0;j<n;j++)
		     {
		     	ss+=Integer.toString(a[j][i]);
		      }
		   for(j=0;j<ss.length();j++)
		   { 
		     char c=ss.charAt(j);
		     if(s1.indexOf(c)<0)
		       s1+=c;
		   }
		   if(s1.length()!=ss.length())
		    cc++;
		    s1="";ss="";
         //System.out.println("Case #: "+a+" "+b);
         //System.out.println(cc);
     }
     System.out.println("Case #"+li+": "+s+" "+r+" "+cc);
     li++;
}
}catch(Exception e){}
}
}


