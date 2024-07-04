import java.util.*;
class Solution
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
				ans=ans.replace(")(","");
			}
			System.out.println("Case #"+t+": "+ans);
		}
	}
}