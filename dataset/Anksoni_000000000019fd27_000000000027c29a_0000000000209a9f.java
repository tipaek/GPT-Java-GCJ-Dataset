import java.util.*;
class Solution
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=1; i<=t; i++)
		{
			String s = in.next();
			Stack<Character> st = new Stack<Character>();
			int p = Integer.parseInt(String.valueOf(s.charAt(s.length()-1)));
			StringBuffer sb = new StringBuffer();
			for(int j=0; j<s.length(); j++)
			{
				st.push(s.charAt(j));
				if(j==0)
				{
					int num = Integer.parseInt(String.valueOf(s.charAt(j)));
					for(int k=1; k<=num; k++)
					{
						sb.append("(");
					}
					sb.append(st.pop());
				}
				else if(j>0 && (j<s.length()))
				{
					int temp1 = Integer.parseInt(String.valueOf(s.charAt(j-1)));
					int temp2 = Integer.parseInt(String.valueOf(s.charAt(j)));
					if(temp1 > temp2)
					{
						for(int k=1; k<=(temp1-temp2); k++)
						{
							sb.append(")");
						}
						sb.append(st.pop());
					}
					else
					{
						for(int k=1; k<=(temp1-temp2); k++)
						{
							sb.append("(");
						}
						sb.append(st.pop());
					}
				}
			}
			for(int j=1; j<=p; j++)
			{
				sb.append(")");
			}
			System.out.println("Case #"+i+": "+sb);
		}
	}
}
