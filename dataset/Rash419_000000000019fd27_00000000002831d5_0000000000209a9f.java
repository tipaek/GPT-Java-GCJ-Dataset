import java.util.*;
public class Solution
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int r=0;r<t;r++)
		{
			String str = scan.next();
			System.out.print("Case #" + (r+1) + ": ");
			createOpen(Character.getNumericValue(str.charAt(0)));
			System.out.print(str.charAt(0));
			for(int i=1;i<str.length();i++)
			{
				if(str.charAt(i) < str.charAt(i-1))
				{
					int diff=Character.getNumericValue(str.charAt(i-1))-Character.getNumericValue(str.charAt(i));
					createClose(diff);
					System.out.print(str.charAt(i));
				}
				else if(str.charAt(i) > str.charAt(i-1))
				{
					int diff=Character.getNumericValue(str.charAt(i))-Character.getNumericValue(str.charAt(i-1));
					createOpen(diff);
					System.out.print(str.charAt(i));
				}
				else
				{
					System.out.print(str.charAt(i));
				}
			}
			createClose(Character.getNumericValue(str.charAt(str.length()-1)));
			System.out.println();
		}
	}
	static void createOpen(int n)
	{
		StringBuilder str = new StringBuilder();
		for(int i=1;i<=n;i++)
		{
			str.append("(");
		}
		System.out.print(str.toString());
	}
	static void createClose(int n)
	{
		StringBuilder str = new StringBuilder();
		for(int i=1;i<=n;i++)
		{
			str.append(")");
		}
		System.out.print(str.toString());
	}
}	
		

