import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args)
	{
		
		Scanner sc=new Scanner(System.in);
		int t= sc.nextInt();
		int cs=1;
		while(t-->0)
		{
			int x=sc.nextInt();
			int y=sc.nextInt();
			String str=sc.next();
			int ans=Integer.MAX_VALUE;
			if(x==0&&y==0)
			{
				System.out.println("Case #"+cs+": "+0);
				cs++;
			   continue;
			}
			for(int i=0;i<str.length();i++)
			{
				char c=str.charAt(i);
				if(c=='S')
				{
					y--;
					
				}
				else if(c=='N')
				{
					y++;
				}
				else if(c=='E')
				{
					x++;
				}
				else
				{
					x--;
				}
			int time_c=i+1;
			int time_n=Math.abs(x)+Math.abs(y);
			if(time_c>=time_n)
			{
				ans=Integer.min(ans, time_c);
			}
			}
			if(ans==Integer.MAX_VALUE)
			{
				System.out.println("Case #"+cs+": "+"IMPOSSIBLE");
				cs++;
			}
			else
			{
				System.out.println("Case #"+cs+": "+ans);
				cs++;
			}
			
		}
        
	
	}
 
}
