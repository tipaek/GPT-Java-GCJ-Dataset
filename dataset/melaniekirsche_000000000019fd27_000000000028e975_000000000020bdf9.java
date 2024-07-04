import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
public class Solution {
public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	int T = input.nextInt();
	for(int t = 1; t<=T; t++)
	{
		int n = input.nextInt();
		char[] res = new char[n];
		Pair[] data = new Pair[n];
		for(int i = 0; i<n; i++) data[i] = new Pair(input.nextInt(), input.nextInt(), i);
		Arrays.sort(data);
		int lastC = -1, lastJ = -1;
		boolean canDo = true;
		for(int i = 0; i<n; i++)
		{
			if(data[i].a >= lastC)
			{
				res[data[i].i] = 'C';
				lastC = data[i].b;
			}
			else if(data[i].a >= lastJ)
			{
				res[data[i].i] = 'J';
				lastJ = data[i].b;
			}
			else canDo = false;
		}
		System.out.println("Case #" + t + ": " + (canDo ? new String(res) : "IMPOSSIBLE"));
	}
}
static class Pair implements Comparable<Pair>
{
	int a, b, i;
	Pair(int aa, int bb, int ii)
	{
		a = aa; b = bb; i = ii;
	}
	@Override
	public int compareTo(Pair o) {
		if(a != o.a) return a - o.a;
		return b - o.b;
	}
}
}
