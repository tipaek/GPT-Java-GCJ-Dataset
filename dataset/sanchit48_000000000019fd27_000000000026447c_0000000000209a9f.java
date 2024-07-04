import java.util.*;
class Solution
{
	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int pos = t;
		while(t-- > 0)
		{
			String s = sc.next();
			StringBuffer st = new StringBuffer(s);
			String left  = "(";
			String right = ")";
			boolean start = false;

			for(int i=0;i<st.length();i++)
			{
				if(st.charAt(i)=='1')
				{
					if(!start)
					{
						st.insert(i, left);
						i++;
						start = true;
					}
				}
				else
				{
					if(start)
					{
						st.insert(i, right);
						start = false;
						i++;
					}
				}
				if (i + 1 == st.length())
				{
					if(start)
					{
						st.append(right);
						break;
					}
				}
			}

			System.out.println("Case #"+(pos-t)+": "+st.toString());
		}
	}
}
