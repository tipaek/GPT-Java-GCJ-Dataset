// package codejam_2020;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		
		for(int p=1;p<=t;p++)
		{
		
			
			int n=Integer.parseInt(br.readLine());
			HashMap<Pair,String> hm=new HashMap<>();
			ArrayList<Pair> al=new ArrayList<>();
			for(int i=1;i<=n;i++)
			{
				String[] s=br.readLine().split(" ");
				int x=Integer.parseInt(s[0]);
				int y=Integer.parseInt(s[1]);
				Pair p2=new Pair(x,y);
				hm.put(p2,"");
				
				al.add(p2);
			}
			
			ArrayList<Pair> al2=new ArrayList<>(al);
			
			
			
			Collections.sort(al,new MySort());
			
			StringBuffer sb=new StringBuffer();
			boolean is_c=false;
			boolean	is_j=false;
			int c_end=0;
			int j_end=0;
			
			boolean imp=false;
			
			
			for(Pair p1:al)
			{					
				if(p1.s>=c_end)
				{
					hm.replace(p1, "C");
					
//					sb.append("C");
					c_end=p1.e;
					
				}
				else if(p1.s >=j_end)
				{
					hm.replace(p1, "J");
//					sb.append("J");
					j_end=p1.e;
					
				}
				else {
					imp=true;
					break;
				}
				
			}
			
			if(imp)
			{
				System.out.println("Case #"+p+": "+"IMPOSSIBLE");
			}
			else {
				
				
				for(Pair px:al2)
				{
					sb.append(hm.get(px));
					
					
				}
				
				System.out.println("Case #"+p+": "+sb.toString());
			}
			
			
		}

	}

}

class MySort implements Comparator<Pair>
{

	@Override
	public int compare(Pair p1, Pair p2) {
		// TODO Auto-generated method stub
		return (p1.s-p2.s);
	}
	
}





class Pair{
	
	int s,e;
	public Pair(int s,int e)
	{
		this.s=s;
		this.e=e;
	}
	@Override
	public String toString() {
		return "[s=" + s + ", e=" + e + "]";
	}
	
	
	
}


