import java.util.*;
public class Solution
{
	public static void main(String arrr[])
	{
	Scanner p=new Scanner(System.in);	
	int t=p.nextInt();
	int hard=1;
	while(t>=1)
	{
		int i,j,temp=0,k,num,c=0;
		String s=p.next();
		char ch[]=s.toCharArray();
		int open=0,close=0;
				int f=0;
				System.out.print("Case #"+hard+": ");
		for(i=0;i<ch.length-1;i++)
		{
			num=ch[i]-'0';
			
			if(f==0)
			{
			for(j=0;j<num;j++)
			{
				System.out.print("(");
				
			}f=9;
			System.out.print(num);
			}
			temp=ch[i+1]-'0';
			k=num-temp;
			if(k<0)
			{
				for(j=0;j>k;j--)
					System.out.print("(");
				System.out.print(temp);
			}
				else if(k>0)
				{
					for(j=0;j<k;j++)
						System.out.print(")");
					System.out.print(temp);
				}
				else
				{
					System.out.print(temp);
					
				}
			
			
		}
		int boo=ch[i]-'0';
		if(ch.length==1)
		{
		for(j=0;j<boo;j++)
			System.out.print("(");
		System.out.print(boo);
		}
		for(j=0;j<boo;j++)
			System.out.print(")");
		System.out.println();
		hard++;
		t--;
	}
	}
}


