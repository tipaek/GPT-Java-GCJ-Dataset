import java.util.*;
public class Solution {
public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	int T = input.nextInt();
	for(int t = 1; t<=T; t++)
	{
		int n = input.nextInt();
		String[] data = new String[n];
		for(int i = 0; i<n; i++) data[i] = input.next();
		String start = "", end = "";
		boolean good = true;
		for(int i = 0; i<n; i++)
		{
			String cur = data[i].substring(0, data[i].indexOf('*'));
			if(cur.startsWith(start) || start.startsWith(cur))
			{
				if(cur.length() > start.length()) start = cur;
			}
			else
			{
				good = false;
			}
			cur = data[i].substring(1 + data[i].lastIndexOf('*'));
			if(end.endsWith(cur) || cur.endsWith(end))
			{
				if(cur.length() > end.length()) end = cur;
			}
			else
			{
				good = false;
			}
			data[i] = data[i].substring(data[i].indexOf('*'));
			data[i] = data[i].substring(0, data[i].lastIndexOf('*') + 1);
		}
		StringBuilder res = new StringBuilder("");
		if(good)
		{
			res.append(start);
			for(int i = 0; i<n; i++)
			{
				for(char c : data[i].toCharArray())
				{
					if(c != '*')
					{
						res.append(c);
					}
				}
			}
			res.append(end);
		}
		System.out.println("Case #" + t + ": " + (good ? res.toString() : "*"));
	}
}
}
