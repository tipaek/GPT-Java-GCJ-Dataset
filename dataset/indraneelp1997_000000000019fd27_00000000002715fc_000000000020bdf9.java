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
	static boolean check(List<Pair> arr, Pair temp)
	{
		for(int i=0;i<arr.size();i++)
		{
			int t1 = Math.max(arr.get(i).start,temp.start);
			int t2 = Math.min(arr.get(i).end,temp.end);
			if(t1<t2)
				return true;
		}
		return false;
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int l1=1;l1<=t;l1++)
		{
			int n = sc.nextInt();
			Pair arr[] = new Pair[n];
			for(int i=0;i<n;i++)
			{
				int s1 = sc.nextInt();
				int s2 = sc.nextInt();
				arr[i] = new Pair(s1,s2);
			}
			int flag = 0;
			List<Pair> jamie = new ArrayList<Pair>();
			List<Pair> camie = new ArrayList<Pair>();
			String ans = "";
			for(int i=0;i<n;i++)
			{
				if(!check(camie,arr[i]))
				{
					ans+='C';
					camie.add(arr[i]);
				}
				else if(!check(jamie,arr[i]))
				{
					ans+='J';
					jamie.add(arr[i]);
				}
				else
				{
					flag = 1;
					break;
				}
			}
			if(flag == 1)
				System.out.println("Case #"+l1+": "+"IMPOSSIBLE");
			else
				System.out.println("Case #"+l1+": "+ans);
		}
	}
}