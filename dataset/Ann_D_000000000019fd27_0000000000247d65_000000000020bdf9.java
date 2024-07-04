import java.util.*;
class activity
{
	int s;
	int e;
	int index;
}

class person
{
	char name;
	activity a = new activity();
	person(char m)
	{
		m=name;
	}
}

public class Solution {

	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int t=sc.nextInt();
		
		for(int i=0;i<t;i++)
		{
			int n=sc.nextInt();
			int s[] =  new int[n];
			int e[] =new int[n];
			activity a[] = new activity[n];
			person c =new person('C');
			person J =new person('J');
			for(int j=0;j<n;j++)
			{
				a[j]=new activity();
				a[j].s=sc.nextInt();
				a[j].e=sc.nextInt();
				a[j].index=j;
			}
			
			activity temp;
			for(int j=0;j<n;j++)
			{
				for(int k=1;k<n-j;k++)
				{
					if(a[k-1].s>a[k].s)
					{
						temp=a[k-1];
						a[k-1]=a[k];
						a[k]=temp;
					}
				}
			}
			char[] allot = new char[n];
			allot[0]='C';
			c.a=a[0];
			J.a=a[1];
			allot[1]='J';
			int count=2;
			for(int j=2;j<n;j++)
			{
				System.out.println(a[j].s);
				if(a[j].s>=c.a.e)
				{
					c.a=a[j];
					allot[j]='C';
					count++;
				}
				else
					if(a[j].s>=J.a.e)
					{
						J.a=a[j];
						allot[j]='J';
						count++;
					}
			}
			String res="";
			for(int j=0;j<n;j++)
			{
				if(allot[a[j].index]!=' ')
					res=res+allot[a[j].index];
			}
			
			if(count==n)
			{
				System.out.println("Case #"+(i+1)+": "+res);
			}
			else
			{
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
			}
		}
	}
}
