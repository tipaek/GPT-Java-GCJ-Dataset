import java.lang.*;
import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int tt=1;tt<=t;tt++)
		{
		    int n=sc.nextInt();
		    int[] st=new int[n];
		    int[] et=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        st[i]=sc.nextInt();
		        et[i]=sc.nextInt();
		    }
		    String y="";
		    if(n<2)
		    {
		        y="C";
		    }
		    else if(n==2 && et[0]==st[1])
		    {
		        y="CC";
		    }
		    else if(n>2)
		    {
		        ArrayList<String> s=new ArrayList<>();
		      //  s.add("C");
		      //  if(et[0]==st[1])
		      //      s.add("C");
		      //  else
		      //      s.add("J");
		        if(st[0]>st[1])
    		        s.add("J");
    		    else
    		        s.add("C");
		        if(et[0]==st[1])
		            s.add(s.get(s.size()-1));
		        else 
		        {
		            if(s.get(s.size()-1)=="C")
		                s.add("J");
		            else    
		                s.add("C");
		        }
		        for(int i=0;i<n;i++)
		        {
		            for(int j=i+2;j<n;j++)
		            {
		                if(et[i]<st[j])
		                {
		                    s.add("C");
		                }
		                else if(et[i+1]<st[j])
                        {
                            s.add("J");
                        }		                
		            }
		        }
		        for(int i=0;i<s.size();i++)
		        {
		            y=y+s.get(i);
		        }
		        for(int i=0;i<n;i++)
		        {
		            if((st[i]+et[i])/60==24)
    		        {
    		            y="IMPOSSIBLE";
        		        break;
    		        }
		        }

		    }
		    System.out.println("Case #"+tt+": "+y);
		}
	}
}
