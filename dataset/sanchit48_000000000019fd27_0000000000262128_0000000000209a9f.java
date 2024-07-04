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
			boolean flag = false;

			for(int i=0;i<st.length();i++)
			{
				if(st.charAt(i)!='1')
					flag = true;
			}
			if(!flag)
			{
				st.insert(0, left);
				st.append(right);
			}

			if(flag)
			{
				for(int i=0;i<st.length();i++)
				{
					if(st.charAt(i)=='1')
					{
						st.insert(i, left);
						if (i + 2 == st.length())
						{
							st.append(right);
							break;
						}

						for(int j=i+2;j<st.length();j++)
						{
							if(st.charAt(j) == '0')
							{
								st.insert(j, right);
								i = j;
								break;
							}
						}
					}
				}
			}

			System.out.println("Case #"+(pos-t)+": "+st.toString());
		}
	}
}
