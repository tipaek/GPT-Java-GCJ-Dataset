import java.util.*;

public class Solution
{
	public static void main(String s[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		ArrayList<String> list = new ArrayList();
		for(int k=0;k<t;k++)
		{
			int n = sc.nextInt();
			int cp = 0,jp=0;
			PriorityQueue<Jod> prq = new PriorityQueue<Jod>(n, new Comparator<Jod>(){
					public int compare(Jod s1, Jod s2) { 
						if (s1.p1 > s2.p1) 
							return 1; 
						else if (s1.p1 < s2.p1) 
							return -1; 
										return 0; 
				} 
			});
			PriorityQueue<Jod> prq1=
                    new PriorityQueue<Jod>(n,new Comparator<Jod>(){
					public int compare(Jod s1, Jod s2) { 
						if (s1.order > s2.order) 
							return 1; 
						else if (s1.order < s2.order) 
							return -1; 
										return 0; 
		} 
			});
			StringBuilder sb = new StringBuilder();
			Boolean imp = false;
			for(int i=0;i<n;i++)
			{
				
				
					int a1 = sc.nextInt();
					int a2 = sc.nextInt();
					
					
					prq.add(new Jod(a1,a2,i));
					
					
				
			}
			
			for(int i=0;i<n;i++)
			{
				Jod p = prq.poll();
				if(p.p1>=cp)
				{
					p.ch = 'C';
					cp = p.p2;
				}
				
				else if(p.p1>=jp)
				{
					p.ch = 'J';
					jp = p.p2;
				}
				else{
					sb = new StringBuilder("IMPOSSIBLE");
					imp = true;
					break;
				}
				prq1.add(p);
			}
			
			if(!imp)
			{
			while(!prq1.isEmpty()){
				Jod pt = prq1.poll();
					sb.append(pt.ch);
			}
			}
			
			String ans = "Case #"+(k+1)+": "+sb.toString();
			list.add(ans);
		}
		
		for(String ans1: list)
			System.out.println(ans1);
	
	}
}

class Jod { 
    int  p1;
	int p2;
	int order;
	char ch;
	Jod()
	{
	}
	Jod(int P1, int P2,int Order)
	{
		p1 = P1;
		p2 = P2;
		order = Order;
		ch = 'a';
	}
             

        }