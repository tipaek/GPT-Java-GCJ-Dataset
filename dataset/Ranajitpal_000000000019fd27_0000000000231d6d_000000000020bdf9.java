import java.util.Scanner;

public class Solution {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++)
		{
			int n = sc.nextInt();
			int s[] = new int[n];
			int e[] = new int[n];
			
			for(int i=0;i<n;i++)
			{
				s[i] = sc.nextInt();
				e[i] = sc.nextInt();
			}
			
			int j_start =0;
			int j_end =0;
			
			int c_start =0;
			int c_end =0;
			String r ="";
			for(int i=0;i<n;i++)
			{
				if(j_end<=s[i])
				{
					j_start = s[i];
					j_end = e[i];
					r += "J";
					continue;
				}
				else
				{
					if(c_end<=s[i])
					{
						c_start = s[i];
						c_end = e[i];
						r +="C";
						continue;
					}
					else
					{
						if(j_start>s[i] && j_start>=e[i] )
						{
							j_start = s[i];
							j_end = e[i];
							r +="J";
						}
						else
						{
							if(c_start>s[i] && c_start>=e[i] )
							{
								c_start = s[i];
								c_end = e[i];
								r +="C";
							}
							else
							{
								break;
							}
						}
					}
				}
			}
			
			if(r.length()!=n)
			{
				System.out.println("Case #"+t+": IMPOSSIBLE");
			}
			else
			{
				System.out.println("Case #"+t+": "+r);
			}
			
		}
	}
}
