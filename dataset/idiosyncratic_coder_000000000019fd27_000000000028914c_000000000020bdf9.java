import java.io.*;
import java.util.*;
import java.math.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		int nc = in.nextInt();
		for(int x = 0; x < nc; x++)
		{
			TreeMap<Integer, List<Integer>> times = new TreeMap<Integer, List<Integer>>();
			List<Integer> et = new ArrayList<Integer>();
			int n = in.nextInt();
			String[] acs = new String[n];
			String ans = "";
			int time1 = 0;
			int time2 = 0;
			for(int i = 0; i < n; i++)
			{	time1 = in.nextInt();
				time2 = in.nextInt();
				et.add(time2);
				if(!times.containsKey(time1))
				{	ArrayList<Integer> list = new ArrayList<Integer>();
					times.put(time1, list);
					times.get(time1).add(i);
				}
				else
				{
					if(et.get(times.get(time1).get(0)) < time2)
					{
						times.get(time1).add(i);
					}
					else
					{
						times.get(time1).add(0, i);
					}
				}
				if(times.get(time1).size() > 2)
				{
					ans = "IMPOSSIBLE";
					break;
				}
			}
			if(ans.equals("IMPOSSIBLE"))
			{
				System.out.printf("Case #%d: ", x + 1);
				System.out.println(ans);
				break;
			}
			int cc = 0;
			int jc = 0;
			for(Map.Entry<Integer, List<Integer>> e : times.entrySet())
			{
				for(int a = 0; a < e.getValue().size(); a++)
				{	
					if(e.getKey() >= cc)
					{
						acs[e.getValue().get(a)] = "C";
						cc = et.get(e.getValue().get(a));
					}
					else if(e.getKey() >= jc)
					{
						acs[e.getValue().get(a)]= "J";
						jc = et.get(e.getValue().get(a));
					}
					else
					{
						ans = "IMPOSSIBLE";
						break;
					}
				
				}
			}
			if(ans.equals(""))
			{
				for(String y : acs)
				{
					ans+=y;
				}
			}
			System.out.printf("Case #%d: ", x + 1);
			System.out.println(ans);
		}
	}
}
