import java.util.*;
		
class Solution
{
    static ArrayList<Integer> cslot = new ArrayList<Integer>(25);
    static ArrayList<Integer> jslot = new ArrayList<Integer>(25);

	public static void main (String[] args) 
	{
		int t,n,s,e;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
		    String ans="";boolean curr_free=true;
		    n=sc.nextInt();
		    for(int j=0;j<n;j++)
		    {
		        s=sc.nextInt();
		        e=sc.nextInt();
		        if(j==0)
		        {
		            cslot.add(s);
		            cslot.add(e);
		            ans+="C";
		        }
		        else if(j==1)
		        {
		            jslot.add(s);
		            jslot.add(e);
		            ans+="J";
		        }
		        else
		        {
		            if(cCheck(1,s,e))
		            {
		                ans+="C";
		                cslot.add(s);
		                cslot.add(e);
		            }
		            else
		            curr_free=false;
		            
		            if(!curr_free)
		            {
		                if(jCheck(1,s,e))
		                {
		                    ans+="J";
		                    jslot.add(s);
		                    jslot.add(e);
		                    curr_free=true;
		                }
		            }
		            
		            if(curr_free==false)
		            {
		                ans="IMPOSSIBLE";
		                break;
		            }
		        }
		    }
		    System.out.println("Case #"+(i+1)+": "+ans);
		    jCheck(2,0,0);
		    cCheck(2,0,0);
		}
	}
	
	static boolean cCheck(int ch,int s,int e)
	{
	    boolean vacant=true;
	    if(ch==1)
	    {
	        for(int i=0;i<cslot.size();i+=2)
	        {
	            if(s>cslot.get(i) && s<cslot.get(i+1))
	            {
	                vacant=false;
	                break;
	            }
	        }
	    }
	    if(ch==2)
	    cslot.clear();
	    
	    return vacant;
	}
	
	static boolean jCheck(int ch,int s,int e)
	{
	    boolean vacant=true;
	    if(ch==1)
	    {
	        for(int i=0;i<jslot.size();i+=2)
	        {
	            if(s>jslot.get(i) && s<jslot.get(i+1))
	            {
	                vacant=false;
	                break;
	            }
	        }
	    }
	    if(ch==2)
	    jslot.clear();
	    
	    return vacant;
	}
}