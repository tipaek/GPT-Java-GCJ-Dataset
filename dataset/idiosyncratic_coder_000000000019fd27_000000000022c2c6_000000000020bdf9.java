import java.io.*;
import java.util.*;
import java.math.*;
public class Problem3 {
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		int nc = in.nextInt();
		for(int x = 0; x < nc; x++)
		{
			TreeMap<Integer, List<Integer>> times = new TreeMap<>();
			Map<Integer, List<String>> order = new LinkedHashMap<>();
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
					ArrayList<String> o2 = new ArrayList<String>();
					order.put(time1,o2);
				}
				times.get(time1).add(time2);
				order.get(time1).add(Integer.toString(time2));
				if(times.get(time1).size() > 2)
				{
					ans = "IMPOSSIBLE";
					break;
				}
				Collections.sort(times.get(time1));
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
					if(e.getKey() < cc && e.getKey() < jc)
					{
							ans = "IMPOSSIBLE";
							break;
					}
					if(e.getKey() >= cc)
					{
						int ind = order.get(e.getKey()).indexOf(Integer.toString(e.getValue().get(a)));
						order.get(e.getKey()).set(ind, "C");
						cc = e.getValue().get(a);
					}
					else if(e.getKey() >= jc)
					{
						int ind = order.get(e.getKey()).indexOf(Integer.toString(e.getValue().get(a)));
						order.get(e.getKey()).set(ind, "J");
						jc = e.getValue().get(a);
					}
				
				}
			}
			if(ans.equals(""))
			{
				for(List<String> y : order.values())
				{
					for(int b = 0; b < y.size(); b++)
					{
						ans += y.get(b);
					}
				}
			}
			System.out.printf("Case #%d: ", x + 1);
			System.out.println(ans);
		}
	}
}

