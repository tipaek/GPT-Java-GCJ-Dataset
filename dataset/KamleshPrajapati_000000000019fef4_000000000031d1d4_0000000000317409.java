import java.util.*;

class Solution 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1;t<=test;t++)
		{
			int x,y;
			x=sc.nextInt();
			y=sc.nextInt();
			int total = Math.abs(x)+Math.abs(y);
			String s = sc.nextLine();
			int len = s.length();
			boolean possible = false;
			int ans=0;
			if(total==0)
			{
				ans=0;
				possible=true;
			}
			else
			{
				for(int i=1;i<len;i++)
				{
					if(s.charAt(i)=='N')
					{
						y++;
					}
					else if(s.charAt(i)=='S')
					{
						y--;
					}
					else if(s.charAt(i)=='E')
					{
						x++;
					}
					else if(s.charAt(i)=='W')
					{
						x--;
					}
					total = Math.abs(x)+Math.abs(y);
					if(total<=i)
					{
						possible = true;
						ans=i;
						break;
					}
				}
			}
			if(possible)
				System.out.println("Case #"+t+": "+ans);
			else
				System.out.println("Case #"+t+": "+"IMPOSSIBLE");
		}
	}

}
