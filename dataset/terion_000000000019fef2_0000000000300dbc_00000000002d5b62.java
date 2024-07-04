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
		int ax = Math.abs(x);
		int by = Math.abs(y);
		String path = "";
		int len = 0;
		int side = 0;
		while(ax>0 || by>0)
		{
			int a = ax%2;
			int b = by%2;
			if(len==0)
			{
				if((a^b)==1)
				{
					len++;
					side = a==1 ? 0 : 1;
				}
				else
				{
					return "IMPOSSIBLE";
				}
			}
			else if(len==1)
			{
				if((a^b)==1)
				{
					path += side==0 ? (x>0 ? "E" : "W") : (y>0 ? "N" : "S");
					side = a==1 ? 0 : 1;
				}
				else if(a==1 && b==1)
				{
					len++;
				}
				else
				{
					path += side==0 ? (x>0 ? "W" : "E") : (y>0 ? "S" : "N");
					for(int j=1;j<len;j++)
					{
						path += side==0 ? (y>0 ? "N" : "S") : (x>0 ? "E" : "W");
					}
					path += side==0 ? (x>0 ? "E" : "W") : (y>0 ? "N" : "S");
					len = 0;
				}
			}
			else if(a==1 && b==1)
			{
				len++;
			}
			else if(a==0 && b==0)
			{
				path += side==0 ? (x>0 ? "W" : "E") : (y>0 ? "S" : "N");
				for(int j=1;j<len;j++)
				{
					path += side==0 ? (y>0 ? "N" : "S") : (x>0 ? "E" : "W");
				}
				path += side==0 ? (x>0 ? "E" : "W") : (y>0 ? "N" : "S");
				len = 0;
			}
			else
			{
				return "IMPOSSIBLE";
			}
			ax/=2;
			by/=2;
		}
		

		if(len==1)
		{
			path += side==0 ? (x>0 ? "E" : "W") : (y>0 ? "N" : "S");
		}			
		else if(len>1)
		{
			path += side==0 ? (x>0 ? "W" : "E") : (y>0 ? "S" : "N");
			for(int j=1;j<len;j++)
			{
				path += side==0 ? (y>0 ? "N" : "S") : (x>0 ? "E" : "W");
			}
			path += side==0 ? (x>0 ? "E" : "W") : (y>0 ? "N" : "S");
			len = 0;
		}
		
		return path;
	}

}
