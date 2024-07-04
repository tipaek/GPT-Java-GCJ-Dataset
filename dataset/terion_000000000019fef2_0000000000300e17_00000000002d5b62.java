import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println("Case #"+i+": "+solve(x, y));
		}
		sc.close();
	}

	public static String solve(int x, int y)
	{
		String res = "";
		String path = solvex(Math.abs(x), Math.abs(y));
		if(path==null)
		{
			return "IMPOSSIBLE";
		}
		for(int i=0;i<path.length();i++)
		{
			char c = path.charAt(i);
			res += (c=='W' && x>0) ? "W" :
				   	(c=='E' && x>0) ? "E" :
					   (c=='W' && x<0) ? "E" :
						   (c=='E' && x<0) ? "W" :
							   (c=='N' && y>0) ? "N" :
								   (c=='S' && y>0) ? "S" :
									   (c=='N' && y<0) ? "S" :
										   (c=='S' && y<0) ? "N" : "";
		}
		return res;
	}
	
	public static String solvex(int x, int y)
	{
		if(x==0 && y==0)
		{
			return "";
		}
		if(((x%2)^(y%2))==0)
		{
			return null;
		}
		if(x%2==1) {
			String res = solvex(x/2, y/2);
			if(res!=null)
			{
				return "E"+res;
			}
			res = solvex(x/2 + 1, y/2);
			if(res!=null)
			{
				return "W"+res;
			}
			return null;
		}
		
		if(y%2==1) {
			String res = solvex(x/2, y/2);
			if(res!=null)
			{
				return "N"+res;
			}
			res = solvex(x/2, y/2 + 1);
			if(res!=null)
			{
				return "S"+res;
			}
			return null;
		}
		return null;
	}

}
