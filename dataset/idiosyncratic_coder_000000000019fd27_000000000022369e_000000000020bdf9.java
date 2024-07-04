import java.io.*;
import java.util.*;
import java.math.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		int nc = in.nextInt();
		ArrayList<Integer> key = new ArrayList<Integer>();
		Map<Integer, Integer> times = new HashMap<>();
		for(int x = 0; x < nc; x++)
		{
			key.clear();
			times.clear();
			int n = in.nextInt();
			String ans = "CJ";
			int time1;
			for(int i = 0; i < n; i++)
			{
				time1 = in.nextInt();
				key.add(time1);
				times.put(time1, in.nextInt());
			}
			Collections.sort(key);
			int y = 2;
			int cc =  times.get(key.get(0));
			int jc = times.get(key.get(1));
			while(y < n)
			{
				if(key.get(y) < cc && key.get(y) < jc)
				{
						ans = "IMPOSSIBLE";
						break;
				}
				if(key.get(y) >= cc)
				{
					ans+="C";
					cc = times.get(key.get(y));
				}
				else if(key.get(y) >= jc)
				{
					ans+="J";
					jc = times.get(key.get(y));
				}
				y++;
				
			}
			System.out.printf("Case #%d: ", x + 1);
			System.out.println(ans);
		}
	}
}
