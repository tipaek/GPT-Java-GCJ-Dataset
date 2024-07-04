import java.util.Scanner;
class Solution
{
	public static void main(String[] args)
	{
	Scanner scan=new Scanner(System.in);
	int t,i,j,k;
	String s,s1;
	t=scan.nextInt();
	for(i=1;i<=t;++i)
		{
		s=scan.next();
		s1="";
		for(j=0;j<s.charAt(0)-'0';++j)	
			s1=s1+"(";
		s1=s1+s.substring(0,1);
		for(j=1;j<s.length();++j)
			{
			if(s.charAt(j-1)<s.charAt(j))
				{
				for(k=0;k<s.charAt(j)-s.charAt(j-1);++k)
					s1=s1+"(";
				}
			else if(s.charAt(j-1)>s.charAt(j))
				{
				for(k=0;k<s.charAt(j-1)-s.charAt(j);++k)
					s1=s1+")";
				}
			s1=s1+s.substring(j,j+1);
			}
		for(j=0;j<s.charAt(s.length()-1)-'0';++j)	
			s1=s1+")";
		System.out.println("Case #"+i+": "+s1);
		}	
	}
}