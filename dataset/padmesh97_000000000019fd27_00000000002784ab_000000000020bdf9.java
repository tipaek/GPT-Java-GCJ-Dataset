import java.util.*;
		
class Solution
{
    static ArrayList<Integer> cslot = new ArrayList<Integer>(20);
    static ArrayList<Integer> jslot = new ArrayList<Integer>(20);

	public static void main (String[] args) 
	{
		int t,n,s,e;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
		    String ans="";boolean curr_free=true,answer=false;
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
		            if(cCheck(s,e)==true && answer==false)
		            {
		                ans+="C";
		                cslot.add(s);
		                cslot.add(e);
		            }
		            else
		            curr_free=false;
		            
		            if(curr_free==false && answer==false)
		            {
		                if(jCheck(s,e)==true)
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
		                answer=true;
		            }
		        }
		    }
		    System.out.println("Case #"+(i+1)+": "+ans);
		    cslot.clear();
		    jslot.clear();
		}
	}
	
	static boolean cCheck(int s,int e)
	{
	    boolean vacant=true;
        for(int i=0;i<cslot.size();i+=2)
        {
            if((s>=cslot.get(i) && s<cslot.get(i+1)) || (e>cslot.get(i) && e<=cslot.get(i+1)))
            vacant=false;
        }

	    return vacant;
	}
	
	static boolean jCheck(int s,int e)
	{
	    boolean vacant=true;
        for(int i=0;i<jslot.size();i+=2)
        {
            if((s>=jslot.get(i) && s<jslot.get(i+1)) || (e>jslot.get(i) && e<=jslot.get(i+1)))
            vacant=false;
        }
	    
	    return vacant;
	}
}