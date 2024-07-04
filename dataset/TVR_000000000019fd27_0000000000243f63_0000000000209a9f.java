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
		int i,j,temp,k,num,c=0;
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
				for(j=1;j<=num;j++)
				System.out.print("(");
			System.out.print(num);
			f=9;
			}
			else
				System.out.print(num);
			temp=ch[i+1]-'0';
			k=num-temp;
			int B=0;
			if(k==0) B=9;
				//System.out.print(temp);
			else if(k>=1)
				for(j=1;j<=k;j++)
				System.out.print(")");
			else
			{for(j=0;j<num;j++)
					System.out.print(")");
				for(j=0;j<temp;j++)
					System.out.print("(");
			}
				
			
	
			
			
		}
		int boo=0;
		if(ch.length==1)
		{
			boo=ch[0]-'0';
			
			for(j=0;j<boo;j++)
				System.out.print("(");
		}
		num=ch[i]-'0';
		System.out.print(num);
		for(i=0;i<num;i++)
			System.out.print(")");
		System.out.println();
		hard++;
		t--;
	}
	}
}


