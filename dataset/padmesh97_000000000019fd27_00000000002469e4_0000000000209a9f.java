import java.util.*;

class Solution
{
	public static void main (String[] args) 
	{
	    int t;String s;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
		    s=sc.next();
		    String op=check(s);
		    System.out.println("Case #"+(i+1)+": "+op);
		}
	}
	
	static String check(String s)
	{
	    int qty=0;String ans="";
	    if(s.length()>0)
	    {
    	    for(int i=0;i<s.length();i++)
    	    {
    	        if(qty==0)
    	        {
    	            ans=ans+generate(1,(int)(s.charAt(i))-48);
    	            ans=ans+s.charAt(i);
    	            qty=(int)(s.charAt(i))-48;
    	        }
    	        else
    	        {
    	            if((int)s.charAt(i)==(int)s.charAt(i-1))
    	            {
    	                ans=ans+s.charAt(i);
    	            }
    	            else if((int)s.charAt(i)>=(int)s.charAt(i-1))
    	            {
    	                ans=ans+generate(1,((int)(s.charAt(i))-48)-qty);
    	                ans=ans+s.charAt(i);
    	                qty=(int)(s.charAt(i))-48;
    	            }
    	            else
    	            {
    	                ans=ans+generate(2,qty-((int)(s.charAt(i))-48));
    	                ans=ans+s.charAt(i);
    	                qty=(int)(s.charAt(i))-48;
    	            }
    	        }
    	       if(i==s.length()-1)
    	       ans=ans+generate(2,qty);
    	    }
	    }
	    return ans;
	}
	
	static String generate(int opr,int qty)
	{
	    String ans="";int i;
	    if(opr==1)
	    {
	        for(i=0;i<qty;i++)
	        ans+="(";
	    }
	    if(opr==2)
	    {
	        for(i=0;i<qty;i++)
	        ans+=")";
	    }
	    return ans;
	}
	
	
	
}