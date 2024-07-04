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
			int n = in.nextInt();
			String ans = "CJ";
			int time1 = 0;
			for(int i = 0; i < n; i++)
			{
				time1 = in.nextInt();
				key.add(time1);
				times.put(time1, in.nextInt());
			}
			Collections.sort(key);
			int y = 2;
			int occ = (times.get(key.get(0)));
			while(y < n)
			{
				if(key.get(y) < times.get(key.get(y-1)) && key.get(y) < occ)
				{
						ans = "IMPOSSIBLE";
						break;
				}
				if(key.get(y) > times.get(key.get(y-1)))
				{
					ans += ans.substring(ans.length()-1, ans.length());
				}
				else
				{
					if(ans.substring(ans.length()-1, ans.length()) == "C")
					{
						ans+= "J";
					}
					else
					{
						ans+="C";
					}
				}
				y++;
				occ = Math.max(occ, times.get(key.get(y-2)));
				
			}
			System.out.printf("Case #%d: ", x + 1);
			System.out.println(ans);
		}
	}
}
