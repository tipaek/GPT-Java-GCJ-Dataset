import java.util.*;
public class Solution {
public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	int T = input.nextInt();
	for(int t = 1; t<=T; t++)
	{
		int n = input.nextInt();
		System.out.println("Case #" + t + ":");
		System.out.println("1 1");
		n--;
		int val = 1;
		boolean flipped = true;
		while(n > 0)
		{
			if(n >= val)
			{
				flipped = false;
				System.out.println((val+1) + " " + 2);
				n -= val;
			}
			else
			{
				if(!flipped)
				{
					flipped = true;
					n--;
					System.out.println((val) + " " + 1);
					if(n == 0) break;
				}
				System.out.println((val+1) + " " + 1);
				n--;
			}
			val++;
		}
	}
}
}
