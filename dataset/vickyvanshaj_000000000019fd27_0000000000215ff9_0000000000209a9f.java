import java.util.*;
import java.io.*;

public class Solution
{

	public static void main(String[] args)
	{
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int m=1;
		while(t-->0)
		{
			String s=sc.next();
			ArrayList<Character> list=new ArrayList<>();
			for(int i=0;i<s.length();i++)
			{
				char c=s.charAt(i);
				if(c=='0')
				{
					list.add('0');
					continue;
				}
				if(c=='1')
				{
					list.add('(');
					list.add('1');
					boolean flag=false;
					for(int j=i+1;j<s.length();j++)
					{
						char c2=s.charAt(j);
						if(c2=='1')
						{
							list.add('1');
							i=j;
							flag=true;
						}
						else
						{
							break;
						}
					}
						list.add(')');
				}
			}
			String ans="";
			for(char c:list)
			{
				ans=ans+Character.toString(c);
			}
			System.out.println("Case #"+m+": "+ans);
			m++;
		}


	}
}