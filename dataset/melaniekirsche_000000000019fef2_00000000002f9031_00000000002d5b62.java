import java.util.*;
public class Solution {
public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	int T = input.nextInt();
	for(int t = 1; t<=T; t++)
	{
		long x = input.nextInt(), y = input.nextInt();
		long step = 1;
		boolean good = true;
		String res = "";
		while(step < 4e10)
		{
			//System.out.println(x+" "+y);
			if(x == 0 && y == 0) break;
			if(x == 0 && y == step)
			{
				y -= step;
				res += 'N';
				break;
			}
			if(x == 0 && y == -step)
			{
				y += step;
				res += 'S';
				break;
			}
			if(y == 0 && x == step)
			{
				x -= step;
				res += 'E';
				break;
			}
			if(y == 0 && x == -step)
			{
				x += step;
				res += 'W';
				break;
			}
			long ax = Math.abs(x), ay = Math.abs(y);
			if(ax%step != 0 || ay%step != 0)
			{
				good = false;
				break;
			}
			
			if(ax%(2*step) == 0 && ay%(2*step) == 0)
			{
				good = false;
				break;
			}
			
			if(ax%(2*step) != 0 && ay%(2*step) != 0)
			{
				good = false;
				break;
			}
			
			if(ax%(2*step) == step)
			{
				if(Math.abs(x + step) % (4*step) == ay % (4*step))
				{
					x -= step;
					res += 'E';
				}
				else
				{
					x += step;
					res += 'W';
				}
			}
			else if(ay%(2*step) == step)
			{
				if(Math.abs(y + step) % (4*step) == ax % (4*step))
				{
					y -= step;
					res += 'N';
				}
				else
				{
					y += step;
					res += 'S';
				}
			}
			else
			{
				good = false;
				break;
			}
			step *= 2;
		}
		if(step > 1e10) good = false;
		if(!good)
		{
			res = "IMPOSSIBLE";
		}
		System.out.println("Case #" + t + ": " + res);
	}
}
}
