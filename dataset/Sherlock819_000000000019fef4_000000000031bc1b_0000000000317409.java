import java.util.*;
import java.io.*;

class Solution
{
	public static String check(int x,int y,String s)
	{
		int l=s.length();
		int d=x+y;
		for(int i=0;i<l;i++)
		{
			if((i)==(Math.abs(x)+Math.abs(y)))
				return ""+(i+1);
			char c=s.charAt(i);
			if(c=='E')
			{
				x++;
			}
			else
			if(c=='W')
			{
				x--;
			}
			else
			if(c=='N')
			{
				y++;
			}
			else
			if(c=='S')
			{
				y--;
			}
			if((i+1)>=(Math.abs(x)+Math.abs(y)))
				return ""+(i+1);
		}
		
		return "IMPOSSIBLE";
	}
	
	public static void main(String args[])
	{
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int T=Integer.parseInt(br.readLine());
			for(int t=0;t<T;t++)
			{
				String s[]=br.readLine().split(" ");
				int x=Integer.parseInt(s[0]);
				int y=Integer.parseInt(s[1]);
				String st=check(x,y,s[2]);
				System.out.println("Case #"+(t+1)+": "+st);
			}
		}
		catch(Exception e)
		{
				System.out.println(e);
		}
	}
}