import java.util.Scanner;
class Solution
{
	public static void main(String[] args)
	{
	Scanner scan=new Scanner(System.in);
	int t,u,i,j;
	long[] q=new long[10000];
	String[] str=new String[10000];
	t=scan.nextInt();
	for(i=1;i<=t;++i)
		{
		char[] ch=new char[10];
		u=scan.nextInt();
		for(j=0;j<10000;++j)
			{
			q[j]=scan.nextLong();
			str[j]=scan.next();
			if(q[j]!=-1)
				{
				String temp=String.valueOf(q[j]);
				for(int k=0;k<temp.length();++k)
					ch[temp.charAt(k)-'0']=str[j].charAt(k);
				}
			}
		System.out.println("Case #"+i+": "+String.valueOf(ch));
		}
	}
}