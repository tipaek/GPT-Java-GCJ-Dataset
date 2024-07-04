import java.util.*;
import static java.lang.System.out;
class Solution
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int tt = Integer.parseInt(sc.nextInt());
		
		for(int t=1;t<=tt;t++)
		{
			String s = sc.nextLine();
			int i=0;
			int brac =0;
			StringBuilder sb=new StringBuilder();
			while(i<s.length())
			{
				if(brac==s.charAt(i)-'0')
				{
					sb.append(s.charAt(i));
					i++;
				}
				else if(bracket<s.charAt(i)-'0')
				{
					sb.append("(");
					brac++;
				}
				else if(brac>s.charAt(i)-'0')
				{
					sb.append(")");
					brac--;
				}
			}
			while(brac!=0)
			{
				sb.append(")");
				brac--;
			}
			System.out.println("Case #"+t+": "+sb.toString());
		}
	}
}
