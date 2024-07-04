
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
			int u = Integer.parseInt(str.nextToken());
			Map<Character, Long> map = new HashMap<>();
			for (int x = 1; x <= 10000; x++)
			{
				str = new StringTokenizer(br.readLine());
				long a = Long.parseLong(str.nextToken());
				String b = str.nextToken();
				
					if (a < 10)
					{
						if (map.containsKey(b.charAt(0)))
						{
							long value = map.get(b.charAt(0));
							if (value > a)
								map.put(b.charAt(0), a);
						} else
						{
							map.put(b.charAt(0), a);
						}
					} else
					{
						String s = a+"";
						if(b.length()==s.length())
						{
							a = a / 10;
							if (map.containsKey(b.charAt(0)))
							{
								long value = map.get(b.charAt(0));
								if (value > a)
									map.put(b.charAt(0), a);
							} else
							{
								map.put(b.charAt(0), a);
							}
							char c = b.charAt(1);
							if (!map.containsKey(c))
							{
								map.put(c, 100L);
							}
						}
					}
				
				char arr[] = new char[10];
				for (Entry<Character, Long> ii : map.entrySet())
				{
					char key = ii.getKey();
					long pos = ii.getValue();
					if (pos < 10)
					{
						arr[(int) pos] = key;
					} else
					{
						arr[0] = key;
					}
				}
				String s = "";
				for (int i = 0; i < 10; i++)
				{
					s = s + arr[i];
				}
				System.out.println("Case #" + (tt + 1) + ": " + s);
			}
		}
	}

}
