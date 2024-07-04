import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[])
	{	
		Scanner sc=new Scanner(System.in);
		int t;
		t=sc.nextInt();
		sc.nextLine();
		String res1[]=new String[t];
		
		for(int i=0;i<t;i++)
		{
			String res="";
			int c=0,flag=0;
			String s=sc.nextLine();
			for(int j=0;j<s.length();j++)
			{
					char ch=s.charAt(j);
					
					int ch1=Integer.parseInt(String.valueOf(ch));
					if(flag==0)
					{
					for(int k=0;k<ch1;k++)
					{
						res+="(";
					}
						res+=ch;
					}
					
					if(flag==1)
					{
						int c1=(int)s.charAt(j-1);
						int c2=(int)s.charAt(j);
						int check=Math.abs(c1-c2);
						if(c1<c2)
						{
						for(int l=0;l<check;l++)
						{
							res+="(";
						}
							res+=ch;
						}
						else if(c1>c2)
						{
						for(int l=0;l<check;l++)
						{
							res+=")";
						}
							res+=ch;
						}
						else
						{
							res+=ch;
						}
						
					}
						
				if(j==(s.length()-1))
				{
					for(int a=0;a<ch1;a++)
					{
						res+=")";
					}
				}
					if(flag==0)
					{
						flag=1;
					
					}
			}
			res1[i]=res;
		}
		for(int i=0;i<t;i++)
		{
			System.out.println("Case #"+(i+1)+": "+res1[i]);
		}
	}
}