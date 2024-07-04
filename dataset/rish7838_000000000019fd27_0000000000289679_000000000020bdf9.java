import java.util.*;

class Solution
{
	public static void main(String s[])
	{
		
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		ArrayList<String> list = new ArrayList();
		for(int k=0;k<t;k++)
		{
			int n = sc.nextInt();
			int a[][] = new int[n][n];
			long sum = 0;
			int max1 = 0;
			int max2 = 0;
			int cc = 0,jc=0;
			PriorityQueue<Pair> pq = new PriorityQueue<Pair>(n, new Comparator<Pair>(){
					public int compare(Pair s1, Pair s2) { 
						if (s1.p1 > s2.p1) 
							return 1; 
						else if (s1.p1 < s2.p1) 
							return -1; 
										return 0; 
		} 
			});
			PriorityQueue<Pair> pq1=
                    new PriorityQueue<Pair>(n,new Comparator<Pair>(){
					public int compare(Pair s1, Pair s2) { 
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
					
					
					pq.add(new Pair(a1,a2,i));
					
					
				
			}
			
			for(int i=0;i<n;i++)
			{
				Pair p = pq.poll();
				
			//	System.out.println("pq = "+ p.p1);
				if(p.p1>=cc)
				{
					//sb.append("C");
					p.ch = 'C';
					cc = p.p2;
				}
				
				else if(p.p1>=jc)
				{
					//sb.append("J");
					p.ch = 'J';
					jc = p.p2;
				}
				else{
					sb = new StringBuilder("IMPOSSIBLE");
					imp = true;
					break;
				}
				pq1.add(p);
			}
			
			if(!imp)
			{
			for(Pair pt: pq1){
					sb.append(pt.ch);
				//	System.out.println(pt.p1+" "+pt.p2+" "+pt.ch+" "+pt.order);
			}
			}
			
			String ans = "Case #"+(k+1)+": "+sb.toString();
			list.add(ans);
			//System.out.println("Case #"+k+": "+sum+" "+rc+" "+cc);
		}
		
		for(String ans1: list)
			System.out.println(ans1);
	
	}
}

class Pair { 
    int  p1;
	int p2;
	int order;
	char ch;
	Pair()
	{
	}
	Pair(int P1, int P2,int Order)
	{
		p1 = P1;
		p2 = P2;
		order = Order;
		ch = 'a';
	}
             

        }
