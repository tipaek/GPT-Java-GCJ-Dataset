import java.util.Scanner;
class Solution
{
	public static void main(String[] args)
	{
	  Scanner scan=new Scanner(System.in);
	int t,n,i;
	t=scan.nextInt();
	for(i=1;i<=t;++i)
		{
		n=scan.nextInt();
		System.out.println("Case #"+i+":");
		if(n==1)
			System.out.println("1 1");
		else if(n==2)
			{
			System.out.println("1 1");
			System.out.println("2 2");
			}
		else if(n==3)
			{
			System.out.println("1 1");
			System.out.println("2 2");
			System.out.println("3 3");
			}
		else if(n==4)
			{
			System.out.println("1 1");
			System.out.println("2 2");
			System.out.println("3 3");
			System.out.println("4 4");
			}
		else 
			{
			System.out.println("1 1");
			System.out.println("2 2");
			System.out.println("3 2");
			System.out.println("3 3");
			n-=5;
			int temp=4;
			for(int j=1;j<=n;++j,++temp)
				System.out.println(temp+" "+temp);
			}
		}	
	}
}