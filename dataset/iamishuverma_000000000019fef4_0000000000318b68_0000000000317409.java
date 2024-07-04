import java.util.Scanner;
class Solution
{
	public static void main(String[] args)
	{
	Scanner scan=new Scanner(System.in);
	int t,i,x,y,j;
	String str;
	t=scan.nextInt();
	for(i=1;i<=t;++i)
		{
		int ans=-1;
		x=scan.nextInt();
		y=scan.nextInt();
		str=scan.next();
		for(j=0;j<str.length();++j)
			{
			if(str.charAt(j)=='N')
				++y;
			else if(str.charAt(j)=='S')
				--y;
			else if(str.charAt(j)=='E')
				++x;
			else
				--x;
			if(Math.abs(x)+Math.abs(y)<=(j+1))
				{
				ans=j+1;
				break;
				}
			}
		System.out.print("Case #"+i+": ");
		if(ans==-1)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(ans);
		}
	}
}