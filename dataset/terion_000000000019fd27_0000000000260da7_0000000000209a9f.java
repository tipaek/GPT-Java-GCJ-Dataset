import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for(int i=1;i<=t;i++)
		{
			String str = sc.nextLine();			
			System.out.println("Case #"+i+": "+solve(str));
		}
		sc.close();
	}

	public static String solve(String str)
	{
		StringBuffer buf = new StringBuffer();
		int depth = 0;
		
		for(int i=0;i<str.length();i++)
		{
			String s = str.substring(i, i+1);
			int x =  Integer.parseInt(s);

			for(;depth<x;depth++)
			{
				buf.append('(');
			}
			
			for(;depth>x;depth--)
			{
				buf.append(')');
			}

			buf.append(s);
		}
		
		for(;depth>0;depth--)
		{
			buf.append(')');
		}
		
		return buf.toString();
	}
}
