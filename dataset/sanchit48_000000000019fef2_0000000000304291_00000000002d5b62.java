import java.util.*;
class Solution
{
	static String ans = "";
	public static boolean recFun(int x, int y, int steps, String s)
	{
		if(x == 0 && y == 0)
			return true;

		if (steps == 0)
			return false;

		if(x == 0 && y > 0)
		{
			boolean a = recFun(x, y-steps, steps/2, s);
			if (a)
			{
				s += "N";
				ans += s;
				return true;
			}
			else
				return false;
		}

		else if(x == 0 && y < 0)
		{
			boolean a = recFun(x, y+steps, steps/2, s);
			if (a)
			{
				s += "S";
				ans += s;
				return true;
			}
		}

		else if(x > 0 && y == 0)
		{
			boolean a = recFun(x-steps, y, steps/2, s);
			if (a)
			{
				s += "E";
				ans += s;
				return true;
			}
		}

		else if(x < 0 && y == 0)
		{
			boolean a = recFun(x+steps, y, steps/2, s);
			if (a)
			{
				s += "W";
				ans += s;
				return true;
			}
		}

		else if(x > 0 && y > 0)
		{
			boolean a = recFun(x-steps, y, steps / 2, s);
			boolean b = recFun(x, y-steps, steps / 2, s);
			if (a)
				s += "E";
			if (b)
				s += "N";
			if(a || b)
			{
				ans += s;
				return true;
			}
		}
		else if (x < 0 && y > 0)
		{
			boolean a = recFun(x+steps, y, steps / 2, s);
			boolean b = recFun(x, y-steps, steps / 2, s);
			if (a)
				s += "W";
			if (b)
				s += "N";
			if (a || b)
			{
				ans += s;
				return true;
			}
		}
		else if (x < 0 && y < 0)
		{
			boolean a = recFun(x+steps, y, steps / 2, s);
			boolean b = recFun(x, y+steps, steps / 2, s);
			if(a)
				s+="W";
			if (b)
				s += "S";
			if (a || b)
			{
				ans += s;
				return true;
			}
		}
		else if (x > 0 && y < 0)
		{
			boolean a = recFun(x-steps, y, steps / 2, s);
			boolean b = recFun(x, y+steps, steps / 2, s);
			if (a)
				s += "E";
			if (b)
				s += "S";
			if (a || b)
			{
				ans += s;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args)
    {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int p=1;p<=t;p++)
		{
			ans = "";
			String s = "";
			int x = sc.nextInt();
			int y = sc.nextInt();

			if(x == 0 && y == 1)
			{
				System.out.println("CASE #" + p + ": " + "S");
				continue;
			}
			if (x == 0 && y == -1) {
				System.out.println("CASE #" + p + ": " + "N");
				continue;
			}
			if (x == 1 && y == 0) {
				System.out.println("CASE #" + p + ": " + "W");
				continue;
			}
			if (x == -1 && y == 0) {
				System.out.println("CASE #" + p + ": " + "E");
				continue;
			}

			int steps = (x==0 || y==0) ? (int)Math.ceil(Math.log(Math.max(Math.abs(x), Math.abs(y))) / Math.log(2)) : (int) Math
					.pow(2, Math.max(Math.abs(x), Math.abs(y)) - 1);

			//System.out.println(steps);

			boolean k = recFun(x, y, steps, s);
			//System.out.println(k);
			if(!k)
				ans = "IMPOSSIBLE";

			System.out.println("CASE #"+p+": "+ans);
		}
    }
}
