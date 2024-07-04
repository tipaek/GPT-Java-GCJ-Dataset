import java.io.*;
import java.util.*;
import java.math.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		int nc = in.nextInt();
		for(int x = 0; x < nc; x++)
		{
			TreeMap<Integer, List<Integer>> times = new TreeMap<>();
			Map<Integer, String> order = new LinkedHashMap<>();
			int n = in.nextInt();
			String ans = "";
			int time1;
			int time2;
			for(int i = 0; i < n; i++)
			{
				time1 = in.nextInt();
				time2 = in.nextInt();
				if(!times.containsKey(time1))
				{
					ArrayList<Integer> list = new ArrayList<Integer>();
					times.put(time1, list);
				}
				times.get(time1).add(time2);
				order.put(time1, "");
				Collections.sort(times.get(time1));
			}
			int cc = 0;
			int jc = 0;
			for(Map.Entry<Integer, List<Integer>> e : times.entrySet())
			{
				for(int a = 0; a < e.getValue().size(); a++)
				{	
					if(e.getKey() < cc && e.getKey() < jc)
					{
							ans = "IMPOSSIBLE";
							break;
					}
					if(e.getKey() >= cc)
					{
						order.replace(e.getKey(), "C");
						cc = e.getValue().get(a);
					}
					else if(e.getKey() >= jc)
					{
						order.replace(e.getKey(), "J");
						jc = e.getValue().get(a);
					}
				
				}
			}
			if(ans.equals(""))
			{
				for(String y : order.values())
				{
					ans+=y;
				}
			}
			System.out.printf("Case #%d: ", x + 1);
			System.out.println(ans);
		}
	}
}

