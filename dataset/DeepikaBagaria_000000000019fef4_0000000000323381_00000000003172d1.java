import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class Solution
{
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tt = 0; tt < t; tt++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(str.nextToken());
			int d = Integer.parseInt(str.nextToken());
			int a[] = new int[n];
			str = new StringTokenizer(br.readLine());
			Map<Long,Integer> map = new HashMap<>();
			for(int i=0;i<n;i++)
			{
				Long x =Long.parseLong(str.nextToken());
				int value=1;
				if(map.containsKey(x))
				{
					value = map.get(x)+1;
				}
				map.put(x, value);
			}
			//Map<Integer,Integer> map = new HashMap<>();
			int ans=d-1;
			if(d==2)
			{
				for (Entry< Long, Integer> ii : map.entrySet())
				{
					if(ii.getValue()>=2) 
					{
						ans=0;
						break;
					}

				}
			}
			else if(d==3)
			{
				for (Entry< Long, Integer> ii : map.entrySet())
				{
					Long key = ii.getKey();
					if(key!=0 && key%2==0 && map.containsKey(key/2))
					{
						ans=1;
					}
					if (ii.getValue() == 2)
					{
						for (Entry<Long, Integer> i : map.entrySet())
						{
							if (i.getKey() > key)
							{
								ans = 1;
								break;
							}
						}
					}
					if(ii.getValue()>=3)
					{
						ans=0;
						break;
					}

				}
			}
			System.out.println("Case #"+(tt+1)+": "+ans);
		}
	}
}
