import java.util.*;


public class Solution 
{
	boolean flag;
	
	String c="C";
	String j="J";
	String out;
	
	
	boolean merge(List<int[]> li)
	{
		int a[][]=new int[li.size()][];
		for(int i=0;i<li.size();i++)
		{
			a[i]=li.get(i);
		}
		Arrays.sort(a,(b,c) ->{
		if(b[0]!=c[0])
			return b[0]-c[0];
		else
			return b[1]-c[1];
		});
		
		for(int i=0;i<a.length-1;i++)
		{
			if(a[i][1]<=a[i+1][0])
				continue;
			else
				return false;
		}
		
		return true;
	}
	void dfs(int ar[][],String s,Set<Integer> set,List<int[]> cman,List<int[]> jman)
	{
		if(set.size()==ar.length)
		{
			out=s;
			flag=true;
			return;
		}
		
		for(int i=0;i<ar.length;i++)
		{
			if(!set.contains(i))
			{
				set.add(i);
				cman.add(ar[i]);
				if(merge(cman))
				{
					dfs(ar,s+c,set,cman,jman);
				}
				cman.remove(cman.size()-1);
				jman.add(ar[i]);
				if(merge(jman)) {
					dfs(ar,s+j,set,cman,jman);
				}
				jman.remove(jman.size()-1);
				set.remove(i);
			}
		}
	}
		String cal(int n,int boundaries[][],int min,int max)
	{
		flag=false;
		out="";
		
		List<int[]> cman=new ArrayList<>();
		List<int[]> jman=new ArrayList<>();
		dfs(boundaries,"",new HashSet<>(),cman,jman);
		
		
		return out;
	}
	
	
public static void main(String arrr[]) {	
	
	Scanner in=new Scanner(System.in);
	
	int t=in.nextInt();
	
	for(int ii=1;ii<=t;ii++)
	{
		Solution solution=new Solution();
		
		int n=in.nextInt();
		int activity[][]=new int[n][2];
		int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			activity[i][0]=in.nextInt();
			activity[i][1]=in.nextInt();
			min=Math.min(min,activity[i][0]);
			max=Math.max(max,activity[i][1]);
		}
		String output=solution.cal(n, activity,min,max);
		if(!solution.flag)
			System.out.println("Case #"+ii+":"+" IMPOSSIBLE");
		else
			System.out.println("Case #"+ii+":"+" "+output);
		
	}
	
	in.close();
}
}
