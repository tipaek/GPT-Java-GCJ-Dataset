import java.util.Arrays;
import java.util.Scanner;
 class Solution
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in);
		int i;
		int t=sc.nextInt();
		int p=t;
		while(t>0)
		{
			t--;
			int j;
			String s=sc.next();
			String ans="";
			int open=0;
			for(i=0;i<s.length();i++)
			{
				int a=Character.getNumericValue(s.charAt(i));
				if(a>open)
				{
					for(j=open;j<a;j++)
						ans+="(";
					
				}
				else if(a<open)
				{
					for(j=open;j>a;j--)
						ans+=")";
				}
					open=a;
				ans=ans+s.charAt(i);
			}
			for(i=open;i>0;i--)
				ans+=")";
			System.out.println("Case #"+(p-t)+": "+ans);
		}
		
	 }
} 