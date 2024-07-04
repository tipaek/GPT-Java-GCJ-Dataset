import java.util.*;
class CodeJam2
{
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		for(int t=1;t<=T;t++)
		{
			String s="",a="";
			s=scan.next();
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i)=='0')
					a+=s.charAt(i);
				else if(s.charAt(i)=='1')
					a+="("+s.charAt(i)+")";
				else if(s.charAt(i)=='2')
					a+="(("+s.charAt(i)+"))";
				else if(s.charAt(i)=='3')
					a+="((("+s.charAt(i)+")))";
				else if(s.charAt(i)=='4')
					a+="(((("+s.charAt(i)+"))))";
				else if(s.charAt(i)=='5')
					a+="((((("+s.charAt(i)+")))))";
				else if(s.charAt(i)=='6')
					a+="(((((("+s.charAt(i)+"))))))";
				else if(s.charAt(i)=='7')
					a+="((((((("+s.charAt(i)+")))))))";
				else if(s.charAt(i)=='8')
					a+="(((((((("+s.charAt(i)+"))))))))";
				else if(s.charAt(i)=='9')
					a+="((((((((("+s.charAt(i)+")))))))))";
			}
			String ans=a;
			while(ans.indexOf(")(")!=-1)
			{
				ans=check(ans);
			}
			System.out.println("Case #"+t+": "+ans);
		}
	}
	public static String check(String a)
	{
			String ans="";
			for(int i=0;i<a.length()-1;i++)
			{
				if(a.charAt(i)==')' && a.charAt(i+1)=='(')
				{
					i++;
				}
				else
					ans+=a.charAt(i);
			}
			return ans+a.charAt(a.length()-1);
	}
}