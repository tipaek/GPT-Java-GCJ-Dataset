import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			String s = sc.nextLine().substring(1);
			System.out.println("Case #"+i+": "+solve(x, y, s));
		}
		sc.close();
	}

	public static String solve(int x, int y, String s)
	{
		int i=0;
		for(i=0;i<s.length();i++)
		{
			if(Math.abs(x)+Math.abs(y)<=i)
			{
				return String.valueOf(i);
			}
			char d = s.charAt(i);			
			switch(d)
			{
			case 'E':
				x++;
				break;
			case 'W':
				x--;
				break;
			case 'N':
				y++;
				break;
			case 'S':
				y--;
				break;
			}
		}

		if(Math.abs(x)+Math.abs(y)<=i)
		{
			return String.valueOf(i);
		}
		return "IMPOSSIBLE";
	}
}
