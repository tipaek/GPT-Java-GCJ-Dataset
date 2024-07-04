import java.util.*;
 class Solution
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in);
		int i;
		int t=sc.nextInt();
		int p=t;
		while(t>0)
		{
			t--;
			HashMap<Integer,Integer> ti=new HashMap ();
			HashMap<Integer,Integer> si=new HashMap ();
			int c=0,j=0;
			int n=sc.nextInt();
			int be[]=new int[1440];
			int k[]=new int[n];
			int or[]=new int[n];
			char an[]= new char[1441];
			for(i=0;i<n;i++)
			{
				int temp=sc.nextInt();
				k[i]=temp;
				or[i]=temp;
				int val=sc.nextInt();
				be[temp]++;
				if(ti.get(temp)==null)
				{
					ti.put(temp,val);
					si.put(temp,val);
				}
				else
				{
					if(ti.get(temp)<val)
						ti.put(temp, val);
					else
						si.put(temp, val);
				}
			}
			Arrays.sort(k);
			Map<Integer,Integer> g=new TreeMap(ti);
			String ans="";
			c=g.get(k[0]);
			an[k[0]]='C';
			int flag=0;
			for(i=1;i<n;i++)
			{
				if(be[k[i]]>2)
				{
					flag=1;
					ans="IMPOSSIBLE";
					break;
				}
				if(k[i]>=c)
				{
					an[k[i]]='C';
					c=g.get(k[i]);
					
				}
				else
				{
					if(k[i]>=j)
					{
						an[k[i]]='J';
						j=g.get(k[i]);
					}
					else
					{
						ans="IMPOSSIBLE";
						flag=1;
						break;
					}
				}
			}
			if(flag==1)
				System.out.println("Case #"+(p-t)+": "+ans);
			else
			{
				for(i=0;i<n;i++)
					ans+=an[or[i]];
				System.out.println("Case #"+(p-t)+": "+ans);
			}
		}
		
	 }
} 