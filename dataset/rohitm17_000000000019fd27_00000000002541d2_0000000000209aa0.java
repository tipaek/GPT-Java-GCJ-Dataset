import java.util.*;
class Main
{
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++)
		{
			int a=s.nextInt();
			int b=s.nextInt();
			double d=b/a;
			int d1=b/a;
			int m=b/a;

			double d2=(double)d1;
			if(d1<=b/2 && d2==d)
			{
				System.out.println("Case #"+i+1+":"+" POSSIBLE");
				for(int i1=1;i1<=a;i1++)
				{System.out.println();
					d1=m;
					for(int i2=1;i2<=a;i2++)
					{
							if(i2==a){m=d1;}
							System.out.print(d1+" ");
							d1=d1-1;
							if(d1==0)
							{
								d1=a;
							}
							

					}

				}
			}
			else
			{
				System.out.println("Case #"+i+1+":"+" IMPOSSIBLE");
			}
		}
	}
}