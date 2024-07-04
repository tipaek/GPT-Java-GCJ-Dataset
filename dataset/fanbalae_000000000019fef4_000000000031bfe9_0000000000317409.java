import java.util.Arrays;
import java.util.Scanner;
 class Solution
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in);
		int i;
		int t=sc.nextInt();
		int p=t;
		while(t>0)
		{
			t--;
			int x=sc.nextInt();
			int y=sc.nextInt();
			String m=sc.next();
			int n=m.length();
			int min=Integer.MAX_VALUE;
			int v=0;
			int c=0;
			for(i=0;i<n;i++)
			{
				
				if(m.charAt(i)=='S')
					y-=1;
				else if(m.charAt(i)=='W')
					x-=1;
				else if(m.charAt(i)=='N')
					y+=1;
				else if(m.charAt(i)=='E')
					x+=1;
				v=Math.abs(x)+Math.abs(y);
				c++;
				if(c>=v)
				{
					min=c;
					break;
				}
			}
			if(v>n)
				System.out.println("Case #"+(p-t)+": IMPOSSIBLE");
			else
				System.out.println("Case #"+(p-t)+": "+c);
		}
		
	 }
} 