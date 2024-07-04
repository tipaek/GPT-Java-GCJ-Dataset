import java.util.*;
public class Solution
{
	public static void main(String ar[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int t=0;
		while(t<n)
		{
		String s=sc.next();
		char []c=s.toCharArray();
		int p=0;
		String ans="";
		int sp=0,ep=0;
		int x=0;
		int k=0;
		//System.out.println(s);
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
				if(x==(c[i-1]-48))
				{	
					//break;
				}
				else if(x>sp)
				{
					k=x;
					if(sp==0)
					{
					while(k!=0)
					{
						ans=ans+")";
						sp--;
						k--;
					}
					}
					sp--;
					while(x!=0)
					{
						ans=ans+"(";
						sp++;
						x--;
					}
				}else if(x<sp)
				{
					k=sp-x;
					while(k!=0)
					{
						ans=ans+")";
						k--;
						sp--;
					}
					/*while(x!=0)
					{
						ans=ans+"(";
						x--;
					}*/
				}
			}
			ans=ans+c[i];
		}	
		while(sp!=0)
		{
			ans=ans+")";
			sp--;
		}
		System.out.println("Case #"+(t+1)+":"+" "+ans);
		t++;
		}
	}
	}
