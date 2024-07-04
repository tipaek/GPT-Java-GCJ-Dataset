import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution
{

	public static String addOpening(String s, int no)
	{
		s+="(";
		no=no-1;
		if(no > 0)
			return addOpening(s, no);
		return s;
	}
	public static String addClosing(String s, int nc)
	{
		s+=")";
		nc = nc-1;
		return s;
	}
	
	public static String addPara(String s, int len)
	{
		String s1="";
		for(int i=1;i<=len ; i++)
		{
			if((int)s.charAt(i)-(int)s.charAt(i-1) == 0 )
			{
				s1+=s.charAt(i);
			}
			else if((int)s.charAt(i)-(int)s.charAt(i-1) > 0)
			{
			    int no = (int)s.charAt(i) - (int)s.charAt(i-1);
                s1 = addOpening(s1, no)+s.charAt(i) ;
			}
			else if((int)s.charAt(i)-(int)s.charAt(i-1)  < 0)
			{
				int nc =-( (int)s.charAt(i) - (int)s.charAt(i-1));
				s1 = addClosing(s1, nc)+s.charAt(i);
			}
		}
		
		return s1;
	}
	
	public static String check(String s1)
	{
		int o=0,c=0;
		for(int i=0;i<s1.length();i++)
		{
			if(s1.charAt(i) == '(')
			{
				o++;
			}
			else if(s1.charAt(i)==')')
			{
				c++;
			}
			else
				continue;
		}
		while(o!=c)
		{
			s1 = addClosing(s1, c);
			c++;
		}
		return s1;
	}
	
	public static void main(String[] args)
	{
		int cases=1;
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		while(t!=0)
		{
			String s =sc.next();
			String s1="";
			int len = s.length();
			s="0"+s;
			s1 = addPara(s, len);
			s1= check(s1);
			System.out.println("Case #"+cases+": "+s1);
			t--;
			cases++;
		}
		
	}

}
