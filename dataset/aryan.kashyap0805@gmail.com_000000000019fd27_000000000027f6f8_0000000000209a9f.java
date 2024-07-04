import java.util.*;
public class Solution
{
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int t1=0;t1<t;t1++)
		{
			String s = sc.next();
			int []opening = new int[s.length()];
			System.out.print("Case #"+(t1+1)+": ");
			for(int i=0;i<s.length();i++)
			{
				char c = s.charAt(i);
				int x = Character.getNumericValue(c);
				if(x>opening[i])
				{
					int value = x-opening[i];
					for(int j=i;j<opening.length;j++)
					{
						opening[j] += value;
					}
					for(int j=1;j<=value;j++)
					{
						System.out.print("(");
					}
					System.out.print(x);
				}
				else if(x<opening[i])
				{
					int value = opening[i]-x;
					for(int j=i;j<opening.length;j++)
					{
						opening[j] -= value;
					}
					for(int j=1;j<=value;j++)
					{
					System.out.print(")");
					}
					System.out.print(x);
				}
				else
				{
					System.out.print(x);
				}
			}
			int value = opening[opening.length-1];
			for(int i=1;i<=value;i++)
			{
				System.out.print(")");
			}
			System.out.println("");
		}
	}
}