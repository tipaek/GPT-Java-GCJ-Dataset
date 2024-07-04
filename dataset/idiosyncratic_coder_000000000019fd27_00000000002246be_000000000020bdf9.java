import java.io.*;
import java.util.*;
import java.math.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		int nc = in.nextInt();
		for(int x = 0; x < nc; x++)
		{
			TreeMap<Integer, Integer> times = new TreeMap<>();
			int n = in.nextInt();
			String ans = "";
			int time1;
			int time2;
			for(int i = 0; i < n; i++)
			{
				time1 = in.nextInt();
				time2 = in.nextInt();
				times.put(time1, time2);
			}
			int cc = 0;
			int jc = 0;
			for(Map.Entry<Integer, Integer> e : times.entrySet())
			{
				if(e.getKey() < cc && e.getKey() < jc)
				{
						ans = "IMPOSSIBLE";
						break;
				}
				if(e.getKey() >= cc)
				{
					ans+="C";
					cc = e.getValue();
				}
				else if(e.getKey() >= jc)
				{
					ans+="J";
					jc = e.getValue();
				}
				
			}
			System.out.printf("Case #%d: ", x + 1);
			System.out.println(ans);
		}
	}
}
