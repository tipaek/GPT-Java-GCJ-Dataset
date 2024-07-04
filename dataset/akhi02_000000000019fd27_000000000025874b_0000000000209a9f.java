import java.util.*;
class Solution
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++)
		{
			String s=sc.next();
			String str="";
			int cur=0;
			for(int i=0;i<s.length();i++)
			{
				if(Character.getNumericValue(s.charAt(i))>cur)
				{
					int diff=Character.getNumericValue(s.charAt(i))-cur;
					int j=0;
					while(j<diff)
					{
						str=str+"(";
						j++;
					}
					str=str+s.charAt(i);
					cur=Character.getNumericValue(s.charAt(i));
				}
				else if(Character.getNumericValue(s.charAt(i))==cur)
				{
					str=str+s.charAt(i);
				}
				else
				{
					int l=0;
					int diff=cur-Character.getNumericValue(s.charAt(i));
					while(l<diff)
					{
						str=str+")";
						l++;
					}
					str=str+s.charAt(i);
					cur=Character.getNumericValue(s.charAt(i));	
				}
			}
			int k=0;
		    while(k<cur)
			{
				str=str+")";
				k++;
			}
			System.out.println("Case"+" "+"#"+t+":"+" "+str);
		}
	}
}	