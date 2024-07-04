
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int k=sc.nextInt();
		int flag=0;
		sc.nextLine();
	for(int t=1;t<=k;t++)
	{
	    String s=sc.nextLine();
	    //System.out.println(s);
	    StringBuffer str=new StringBuffer("");
	   if(s.length()==1)
	   {
	    int y=Integer.parseInt(s.charAt(0)+"");
	    if(y==0)
	    {
	        str.append("0");
	    }
	    else{
	    for(int i=0;i<y;i++)
	    {
	        str.append("(");
	    }
	    str.append(""+y);
	    for(int i=0;i<y;i++)
	    {
	        str.append(")");
	    }
	    }
	   }
	   else{
	       if(Integer.parseInt(s.charAt(0)+"")==0)
	       {
	           str.append("0");
	       }
	       else{
	       for(int i=0;i<Integer.parseInt(s.charAt(0)+"");i++)
	       {
	           str.append("(");
	       }
	       str.append(""+s.charAt(0));
	       for(int i=0;i<Integer.parseInt(s.charAt(0)+"")-Integer.parseInt(s.charAt(1)+"");i++)
	       {
	           str.append(")");
	       }
	       }
	    for(int i=1;i<s.length()-1;i++)
	    {
	        int x=Integer.parseInt(s.charAt(i)+"")-Integer.parseInt(s.charAt(i-1)+"");
	        int y=Integer.parseInt(s.charAt(i)+"")-Integer.parseInt(s.charAt(i+1)+"");
	        if(x>0)
	        {
	            for(int j=0;j<x;j++)
	            {
	                str.append("(");
	            }
	        }
	        str.append(s.charAt(i)+"");
	        if(y>0)
	        {
	            for(int j=0;j<y;j++)
	            {
	                str.append(")");
	            }	            
	        }
	        
	    }
	    if(Integer.parseInt(s.charAt(s.length()-1)+"")==0)
	    {
	        str.append("0");
	    }
	    else{
	       for(int i=0;i<Integer.parseInt(s.charAt(s.length()-1)+"")-Integer.parseInt(s.charAt(s.length()-2)+"");i++)
	       {
	           str.append("(");
	       }
	       str.append(""+s.charAt(s.length()-1));
	       for(int i=0;i<Integer.parseInt(s.charAt(s.length()-1)+"");i++)
	       {
	           str.append(")");
	       }	    
	   }
	   }
	System.out.println("Case #"+t+": "+str.toString());
	    
	}
	    
	}
}