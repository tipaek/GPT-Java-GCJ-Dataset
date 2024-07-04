import java.util.*;
class activity
{
	int s;
	int e;
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
			}
			char[] allot = new char[n];
			allot[0]='C';
			c.a=a[0];
			J.a=a[1];
			allot[1]='J';
			int count=2;
			for(int j=2;j<n;j++)
			{
				if(a[j].s>=c.a.e||a[j].e<=c.a.s)
				{
					c.a=a[j];
					allot[j]='C';
					count++;
				}
				else
					if(a[j].s>=J.a.e ||a[j].e<=J.a.s)
					{
						J.a=a[j];
						allot[j]='J';
						count++;
					}
			}
			String res="";
			for(int j=0;j<allot.length;j++)
			{
				if(allot[j]!=' ')
					res=res+allot[j];
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
