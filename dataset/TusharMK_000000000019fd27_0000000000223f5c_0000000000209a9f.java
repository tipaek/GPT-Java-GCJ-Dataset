import java.util.*;
public class Solution {
	final static String OPEN = "(";
	final static String CLOSE =")";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int z = 0 ; z < t ; z++ )
		{
			String s = sc.next();
			String ans = "";
			int st = Integer.parseInt(s.charAt(0)+"");
			for(int i = 0 ; i < st ; i++ )
			{
				ans += OPEN;
			}
			
			for(int i = 0 ; i < s.length() - 1 ; i++ )
			{
				int cur = Integer.parseInt(s.charAt(i)+"");
				int next = Integer.parseInt(s.charAt(i+1)+"");
				if(cur < next )
				{
					 ans += addOpen(cur ,  next - cur);
				}
				else if(cur > next)
				{
					ans += addClose( cur , cur - next);
				}
				else
				{
					ans += cur;
				}
				
			}
			
			int end = Integer.parseInt(s.charAt(s.length() - 1 )+"");
			ans += end;
			for(int i = 0 ; i < end ; i++ )
			{
				ans += CLOSE;
			}
			System.out.println("Case #" + (z+1) + ": "+ans);
		}
		sc.close();	
	}
	public static String addOpen(int c, int n)
	{
		String s = "";
		s += c;
		for(int i = 0 ; i < n ; i++ )
		{
			s += OPEN;
		}
		
		return s;
	}
	public static String addClose(int c, int n)
	{
		String s = "";
		s+= c;
		for(int i = 0 ; i < n ; i++ )
		{
			s += CLOSE;
		}
		
		return s;
	}

}