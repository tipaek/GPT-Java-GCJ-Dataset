// package codejam_1b;
import java.util.*;
import java.io.*;



public class Solution{

	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int obj=1;obj<=t;obj++)
		{
			String[] s1=br.readLine().split(" ");
			int r=Integer.parseInt(s1[0]);
			int s=Integer.parseInt(s1[1]);
			
			ArrayList<Integer> al=new ArrayList<>();
			for(int i=1;i<=s;i++)
			{
				for(int j=1;j<=r;j++)
				{
					al.add(j);
				}
			}
		
			ArrayList<Pair> res=new ArrayList<>();
			for(int i=al.size()-1;i>=0;i--)
			{
				Pair p=algo(al,i);
//				System.out.println(p.x+" "+p.y);
				if(p.x!=0&&p.y!=0 )
				{
					res.add(p);
				}
				
			}
			
			System.out.println("Case #"+obj+": "+res.size());
			for(Pair p:res)
			{
				System.out.println(p.x+" "+p.y);
			}
			
			
		}
		
		
		
		

	}
	
	public static Pair algo(ArrayList<Integer> al,int n)
	{
		int z=al.get(n);
		int in1=n;
		int temp=al.get(0);
		boolean flag=true;
		
		int val=al.get(n);
		
		for(int i=n-1;i>=0;i--)
		{
			int hp=al.get(i);
			if(hp==z)
			{
				in1=i;
			}	
			
			val=al.get(i);
			
		}
		
		
		
		if(in1==n || (n-in1==1) || val==z)
		{
			return new Pair(0,0);
		}
		
		ArrayList<Integer> a2=new ArrayList<>();
		
		int p1=in1+1;
		int p2=n-p1;
		
		
//		System.out.println(p1+" "+p2);
//		Pair p=new Pair(p1,p2);
		
		if(p1>=p2)
		{
		for(int i=0;i<=in1;i++)
		{
			a2.add(al.get(i));
		}
		
		ArrayList<Integer> a1=new ArrayList<>();
		for(int i=p1;i<n;i++)
		{
			a1.add(al.get(i));
		}
		
//		System.out.println(a2);
		
		int i1=0;
		
		if(p1==p2)
		{
			i1=0;
			for(int i=p1;i<p1+a2.size();i++)
			{
				al.set(i,a2.get(i1++));
			}
			i1=0;
			
			for(int i=0;i<p1;i++)
			{
				al.set(i, a1.get(i1++));
			}
		}
		else {
		i1=0;
		for(int i=in1;i<in1+a2.size();i++)
		{
			al.set(i, a2.get(i1++));
		}
		i1=0;
		for(int i=0;i<in1;i++)
		{
			al.set(i, a1.get(i1++));
		}
		
		}
	
		}
		else {
			
			ArrayList<Integer> a1=new ArrayList<>();
			for(int i=0;i<=in1;i++)
			{
				a1.add(al.get(i));
			}
			
		
			for(int i=p1;i<n;i++)
			{
				a2.add(al.get(i));
			}

//			System.out.println(a2);
			int i1=0;
			
			for(int i=0;i<a2.size();i++)
			{
				al.set(i,a2.get(i1++));				
			}		
//			i1=0;
			int i2=0;
			for(int i=0;i<a1.size();i++)
			{
				al.set(i1++, a1.get(i));
			}
			
			
		}
		
		
		
		
		
//		System.out.println(al);
		
		Pair re1=new Pair(p1,p2);
		return re1;
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	

}



class Pair
{
	int x,y;
	public Pair(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	
	
}
