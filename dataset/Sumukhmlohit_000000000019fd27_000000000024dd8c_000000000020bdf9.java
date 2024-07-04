import java.util.*;

public class Solution {

	public  String activity(int n,TreeMap<Integer,Integer> act)
	{
		String str="";
		int index=0;
		int prevj=0,prevc=0,f,s;
		StringBuilder res=new StringBuilder(str); 
		for(Map.Entry<Integer, Integer> i:act.entrySet())
		{	f=i.getValue();s=i.getKey();
			if(index==0)
			{	index++;
				str=str+"J";
				prevj=f;
			}
			else if(s>=prevj)
			{	
				str=str+"J";
				prevj=f;
			}
			else if(s>=prevc)
			{	
				str=str+"C";
				prevc=f;
			}
			
			else {
			return "IMPOSSIBLE";
			}
		}
		return str;
	}
	
	public static void main(String[] args)
	{
	Scanner sc=new Scanner(System.in);
	int t,n,s,f;
	t=sc.nextInt();
	
	
	String ans="";
	for(int i=0;i<t;i++)
	{
		n=sc.nextInt();
		TreeMap<Integer,Integer> act=new TreeMap<Integer,Integer>();
			for(int j=0;j<n;j++)
			{
				s=sc.nextInt();
				f=sc.nextInt();
				act.put(s, f);
			}
			Solution ob=new Solution();
			ans+="Case #"+i+" :";
			ans+=ob.activity(n,act);
			ans+='\n';
	}

System.out.println(ans);	
	}
}
