import java.util.*;

public class Solution {

	public static StringBuilder brackets(String str)
	{
		StringBuilder s = new StringBuilder();
		int c = 0;
		for(int i=0;i<str.length();i++)
		{
			int d = (int) str.charAt(i) - 48;
			if(c == d) s.append(d);
			else if(c > d) 
			{
				while(c > d) {
					s.append(')');
					c--;
				}
				s.append(d);
			}
			else if(c < d) 
			{
				while(c < d) {
					s.append('(');
					c++;
				}
				s.append(d);
			}
		}
		while(c > 0) {
			s.append(')');
			c--;
		}
		return s;
	}
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for(int q=1;q<=t;q++)
		{
			String str = scn.next();
			System.out.println("Case #" + q + ": " + brackets(str));
		}
	}
}