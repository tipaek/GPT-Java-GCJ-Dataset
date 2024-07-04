import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static class Link
	{
		int u = 0;
		int v = 0;
		int add = 0;
		int lat = 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++)
		{
			int c = sc.nextInt();
			int d = sc.nextInt();
			int[] x = new int[c+1];
			for(int j=2;j<=c;j++)
			{
				x[j] = sc.nextInt();
			}
			Link[] l = new Link[d];
			for(int j=0;j<d;j++)
			{
				l[j] = new Link();
				l[j].u = sc.nextInt();
				l[j].v = sc.nextInt();
				if(l[j].v==1)
				{
					l[j].v = l[j].u;
					l[j].u = 1;
				}
			}
			System.out.println("Case #"+i+": "+solve(c, d, x, l));
		}
		sc.close();
	}
	
	public static int N = 10000000;

	public static String solve(int c, int d, int[] x, Link[] l)
	{
		int r = 0;
		ArrayList<Link> cand = new ArrayList<Link>();
		for(Link ll : l)
		{
			if(ll.u==1)
			{
				cand.add(ll);
			}
		}		
		
		while(r<d)
		{
			int minTime = N;
			int minN = N;
			for(Link ll : cand)
			{				
				int xx = x[ll.v];
				if(xx<0 && -xx < minN)
				{
					minN = -xx;
				}
				else if(xx>0 && xx < minTime)
				{
					minTime = xx;
				}
			}
				
			ArrayList<Link> newcand = new ArrayList<Link>();
			if(minN<=r+1)
			{
				for(Link ll : cand)
				{
					int xx = x[ll.v];
					if(xx == -minN)
					{
						ll.lat = ll.add + 1;
						r++;
						x[ll.v] = 0;
						
						for(Link lll: l)
						{
							if(lll.lat>0 || lll.u==1) continue;
							if(lll.u == ll.v || lll.v == ll.v)
							{
								lll.v = lll.u == ll.v ? lll.v : lll.u;
								lll.u = 1;
								newcand.add(lll);
							}
						}
					}
					else
					{
						if(x[ll.v]>0)
						{
							x[ll.v] -= 1;
						}						
						ll.add += 1;
						newcand.add(ll);
					}
				}
			}
			else
			{
				for(Link ll : cand)
				{
					int xx = x[ll.v];
					if(xx == minTime)
					{
						ll.lat = ll.add + minTime;
						r++;
						x[ll.v] = 0;
						
						for(Link lll: l)
						{
							if(lll.lat>0 || lll.u==1) continue;
							if(lll.u == ll.v || lll.v == ll.v)
							{
								lll.v = lll.u == ll.v ? lll.v : lll.u;
								lll.u = 1;
								newcand.add(lll);
							}
						}
					}
					else
					{
						if(x[ll.v]>0)
						{
							x[ll.v] -= minTime;
						}
						ll.add += minTime;
						newcand.add(ll);
					}
				}
			}
			
			ArrayList<Link> newnewcand = new ArrayList<Link>();
			for(Link ll : newcand)
			{
				if(x[ll.v]==0)
				{
					r++;
					ll.lat = ll.add + 1;
				}
				else
				{
					newnewcand.add(ll);
				}
			}
			
			cand = newnewcand;
		}
		
		String str = ""+l[0].lat;
		for(int i=1;i<d;i++)
		{
			str += " "+l[i].lat;
		}
		return str;
	}

}
