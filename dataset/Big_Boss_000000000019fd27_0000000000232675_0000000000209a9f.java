import java.util.Scanner;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t=in.nextInt();
		for(int i=1; i<=t; i++)
		{
			String s=in.next();
			StringBuilder res = new StringBuilder();
			int opening_brackets=0;
			for(int j=0; j<s.length(); j++)
			{
				int val=Character.getNumericValue(s.charAt(j));
				if(opening_brackets<val)
				{
					for(int k=opening_brackets; k<val; k++)
					{
						res.append('(');
						opening_brackets++;
					}
				}
				else if(opening_brackets>val)
				{
					for(int k=opening_brackets; k>val; k--)
					{
						res.append(')');
						opening_brackets--;
					}
				}
				res.append(s.charAt(j));
			}
			for(int k=opening_brackets; k>0; k--)
			{
				res.append(')');
				opening_brackets--;
			}
			System.out.println("Case #" + i + ": "+res);
		}
	}

}
