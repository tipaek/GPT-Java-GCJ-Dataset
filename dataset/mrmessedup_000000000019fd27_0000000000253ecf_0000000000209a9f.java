import java.util.*;
public class Solution
{
	public static void main(String ar[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int lo=0;
		while(lo<n)
		{
		String s=sc.next();
		char []c=s.toCharArray();
		int p=0;
		String ans="";
		int sp=0,ep=0;
		int x=0;
		int k=0;
		for (int i = 0; i < c.length; i++) {
			x=c[i]-48;
			if(sp==0)
			{
				while(x!=0)
				{
					ans=ans+"(";
					x--;
					sp++;
				}
			}
			else
			{
				if((sp-ep)>x)
				{
					k=sp-ep-x;
					while(k!=0)
					{
						ans=ans+")";
						ep++;
						k--;
					}
					k=sp-ep-x;
					while(k!=0)
					{
						ans=ans+"(";
						sp++;
					}
				}
				else if((sp-ep)<x)
				{
					sp=0;
					while(x!=0)
					{
						ans=ans+"(";
						sp++;
						x--;
					}
				}
				
			}
			ans=ans+c[i];
			
		}	
		while(sp!=0)
		{
			if((c[s.length()-1]-48)!=0)
			{
			ans=ans+")";
			sp--;
			}
			else
				break;
		}
		System.out.println("Case #"+(lo+1)+": "+ans);
		lo++;
		}
	}
}