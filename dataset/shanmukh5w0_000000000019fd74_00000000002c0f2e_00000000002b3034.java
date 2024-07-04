import java.util.*;
public class Solution
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n,max,count[],ans,c1,c;
		String s[];
		for(int i=0;i<t;i++)
		{
			c1 = 0;
			c = 0;
			n = sc.nextInt();
			s = new String[n];
			for(int j=0;j<n;j++)
			{
				s[j] = sc.next();
			}
			count = new int[n];
			for(int j=0;j<n;j++)
			{
				count[j] = 0;
			}
			for(int j=0;j<n;j++)
			{
				if(s[j].charAt(0)=='*')
				{
					c++;
				}
				count[j] = s[j].length()-1;

			}
			max = count[0];
			ans = 0;
			for(int j=0;j<n;j++)
			{
				if(count[j]>max)
				{
					max = count[j];
					ans = j;
				}
			}
			if(c==n)
			{
				for(int k=0;k<n;k++)
				{
					for(int j=0;j<=max;j++)
					{
						//System.out.println(s[ans].substring(j,max+1));
						//System.out.println(s[k].substring(1,s[k].length()));
						if((s[ans].substring(j,max+1)).equals(s[k].substring(1,s[k].length())))
						{
							c1++;
							break;
						}
					}
				}
				//System.out.println(c1);
				if(c1 == n)
				{
					String s1 = "";
					for(int j=1;j<s[ans].length();j++)
					{
						s1 += s[ans].charAt(j);
					}
					System.out.println("Case #"+(i+1)+": "+s1);
				}
				else
				{
					System.out.println("Case #"+(i+1)+": *");
				}
			}
		}
	}
}
				
				
				