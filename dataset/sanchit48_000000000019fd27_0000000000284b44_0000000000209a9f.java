import java.util.*;

class Solution
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int pos = t;
		while (t-- > 0)
		{
			String s = sc.next();
			StringBuffer str = new StringBuffer("");
			String left = "(";
			String right = ")";
			int c = 0;

			Stack<String> st = new Stack<>();

			for(int i=0;i<s.length();i++)
			{
				c = 0;
				int num = Integer.parseInt(String.valueOf(s.charAt(i)));
				if(!st.isEmpty())
				{
					for(int j=0;j<num;j++)
					{
						if(st.peek().equals(right))
						{
							st.pop();
							c++;
						}
					}
				}

				for(int j=0;j<num-c;j++)
					st.add(left);

				st.add(String.valueOf(num));

				for(int j=0;j<num;j++)
					st.add(right);
			}

			while(!st.isEmpty())
				str.append(st.pop());

			System.out.println("Case #" + (pos - t) + ": " + str.reverse());
		}
	}
}
