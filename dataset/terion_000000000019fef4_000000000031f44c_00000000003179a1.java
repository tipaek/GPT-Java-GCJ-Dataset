import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
	
	static int N = 10000;
	
	static class Pair
	{
		char c;
		int x;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++)
		{
			int u = sc.nextInt();
			String[] arr = new String[N];
			for(int j=0;j<N;j++)
			{
				int x = sc.nextInt();
				arr[j] = sc.nextLine().substring(1);
			}
			System.out.println("Case #"+i+": "+solve(u, arr));
		}
		sc.close();
	}

	public static String solve(int u, String[] arr)
	{	
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		for(int i=0;i<arr.length;i++)
		{
			String word = arr[i];
			for(int j=0;j<word.length();j++)
			{
				char c = word.charAt(j);
				add(map, c, word.length()==u && j==0);
			}
		}
		
		Pair[] pairs = new Pair[10];
		int i=0;
		try {for(char c: map.keySet())
		{
			Pair p = new Pair();
			p.c = c;
			p.x = map.get(c);
			pairs[i] = p;
			i++;
		}}catch(Exception e) {return "0";}
		
		Arrays.sort(pairs, (a, b) -> a.x - b.x);
		
		String res = "";
		res += pairs[0].c;
		for(i=pairs.length - 1;i>0;i--)
		{
			res += pairs[i].c;
		}
		
		
		return res;
	}
	
	public static void add(TreeMap<Character, Integer> map, char c, boolean increase)
	{
		int value = map.containsKey(c) ? map.get(c) : 0;
		if(increase)
		{
			value++;
		}
		map.put(c, value);
	}
}
