import java.util.*;
class Pair implements Comparable<Pair>
{
	int start = 0;
	int end = 0;
	Pair(int f,int s)
	{
		this.start = f;
		this.end = s;
	}
	public int compareTo(Pair a)
	{
		return this.end - a.end;
	}
}
public class Solution
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int l1=1;l1<=t;l1++)
		{
			int n = sc.nextInt();
			Pair arr[] = new Pair[n];
			Pair ori[] = new Pair[n];
			for(int i=0;i<n;i++)
			{
				int s1 = sc.nextInt();
				int s2 = sc.nextInt();
				arr[i] = new Pair(s1,s2);
				ori[i] = arr[i];
			}
			Arrays.sort(arr);
			boolean check[] = new boolean[n];
			Arrays.fill(check,false);
			Map<Pair,Character> map = new HashMap<Pair,Character>();
			char current = 'C';
			Pair prev = arr[0];
			map.put(prev,current);
			check[0]=true;
			for(int i=1;i<n;i++)
			{
				if(arr[i].start>=prev.end)
				{
					map.put(arr[i],current);
					prev = arr[i];
					check[i] = true;
				}
			}
			List<Pair> temp = new ArrayList<Pair>();
			List<Integer> pos = new ArrayList<Integer>();
			for(int i=0;i<n;i++)
			{
				if(check[i]==false)
				{
					temp.add(arr[i]);
					pos.add(i);
				}
			}
			if(temp.size()>0)
			{
				prev = temp.get(0);
				check[pos.get(0)]=true;
				map.put(prev,'J');
			}
			current = 'J';
			for(int i=1;i<temp.size();i++)
			{
				if(temp.get(i).start>=prev.end)
				{
					map.put(temp.get(i),current);
					prev = temp.get(i);
					check[pos.get(i)] = true;
				}
			}
			int flag = 0;
			for(int i=0;i<n;i++)
			{
				if(check[i] == false)
				{
					flag=1;
					break;
				}
			}
			if(flag == 1)
			{
				System.out.println("Case #"+l1+": "+"IMPOSSIBLE");
			}
			else
			{
				String ans = "";
				for(int i=0;i<n;i++)
					ans+=map.get(ori[i]);
				System.out.println("Case #"+l1+": "+ans);
			}
		}
	}
}