import java.util.Scanner;
public class Solution {
public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	int T = input.nextInt();
	for(int t = 1; t<=T; t++)
	{
		char[] c = input.next().toCharArray();
		int n = c.length;
		int depth = 0;
		StringBuilder res = new StringBuilder("");
		for(int i = 0; i<n; i++)
		{
			int count = c[i] - '0';
			while(depth > count)
			{
				depth--;
				res.append(')');
			}
			while(depth < count)
			{
				depth++;
				res.append('(');
			}
			res.append(c[i]);
		}
		while(depth > 0)
		{
			res.append(')');
			depth--;
		}
		System.out.println("Case #" + t + ": " + res.toString());
	}
}
}
