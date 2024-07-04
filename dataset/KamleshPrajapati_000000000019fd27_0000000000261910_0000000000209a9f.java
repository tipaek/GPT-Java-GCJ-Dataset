import java.util.Scanner;

class Solution
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		sc.nextLine();
		for(int t=1;t<=test;t++)
		{
			String s = sc.nextLine();
			int i=0;
			int bracket =0;
			String ans = "";
			while(i<s.length())
			{
				if(bracket==s.charAt(i)-'0')
				{
					ans+=s.charAt(i);
					i++;
				}
				else if(bracket<s.charAt(i)-'0')
				{
					ans+='(';
					bracket++;
				}
				else if(bracket>s.charAt(i)-'0')
				{
					ans+=')';
					bracket--;
				}
			}
			while(bracket!=0)
			{
				ans+=')';
				bracket--;
			}
			System.out.println("Case #"+t+": "+ans);
		}
	}
}
