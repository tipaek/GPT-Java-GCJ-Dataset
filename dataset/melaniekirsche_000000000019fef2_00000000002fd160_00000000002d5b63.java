import java.util.*;
public class Solution {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		int a = input.nextInt(), b = input.nextInt();
		int diff = (int)1e9-a;
		for(int t = 1; t<=T; t++)
		{
			int maxLeft = diff, maxRight = diff, maxTop = diff, maxBottom = diff;
			
			boolean done = false;
			for(int i = -maxRight; i<=maxLeft && !done; i++)
			{
				for(int j = -maxTop; j <= maxBottom && done; j++)
				{
					System.out.println(i+" "+j);
					String verdict = input.next();
					
					if(verdict.equals("CENTER"))
					{
						done = true;
					}
				}
			}
		}
	}
}
