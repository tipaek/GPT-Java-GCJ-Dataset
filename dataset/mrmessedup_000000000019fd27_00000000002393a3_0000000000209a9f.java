import java.util.*;
public class Solution
{
	public static void main(String ar[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int po=0;
		while(po<n)
		{
		String s=sc.next();
		char []c=s.toCharArray();
		int p=0;
		String ans="";
		int pt=0;
		for (int i = 0; i < c.length; i++) {
			if(pt==0 && c[i]-48==1)
			{
				ans=ans+"(";
				pt++;
			}
			else if(pt>0 && c[i]-48!=1)
			{
				ans=ans+")";
				pt--;
			}
			if(pt!=0)
			{
				ans=ans+"1";
			}
			if(c[i]-48==0)
				ans=ans+"0";
		}
		if(pt!=0)
			ans=ans+")";
		System.out.println("Case #"+(po+1)+":"+" "+ans);
		po++;
		}
	}
}