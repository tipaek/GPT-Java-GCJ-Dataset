import java.util.*;
public class Solution
{
	public static void main(String[]args)
	{
		Scanner in=new Scanner(System.in);
		int a,b,c,d,e,f,g,h,i,j,k;
		String s, t,u,v;
		a=in.nextInt();
		for(b=1;b<=a;b++)
		{
			c=in.nextInt();
			d=in.nextInt();
			s=in.next();
			e=s.length();
			g=0;i=0;
			for(f=0;f<e;f++)
			{
				if(s.charAt(f)=='S')
					d--;
				else if(s.charAt(f)=='N')
					d++;
				else if(s.charAt(f)=='E')
					c++;
				else
					c--;
				h=c<0?-c:c;
				h+=d<0?-d:d;
				if(h<=(f+1))
				{
					if(i==0)
					{	
						
					i=1;g=f+1;break;
					}
				}
			}
			if(i==1)
			System.out.println("Case #"+b+": "+g);
			else
				System.out.println("Case #"+b+": IMPOSSIBLE");
		}
	}
}