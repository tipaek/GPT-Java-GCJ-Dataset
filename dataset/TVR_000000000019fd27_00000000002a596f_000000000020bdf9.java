import java.util.*;
public class Solution
{
	public static void main(String arrr[])
	{
	Scanner p=new Scanner(System.in);
		int t=p.nextInt();
		int yyy=1;
		while(t>=1)
		{
			int n,i,temp;
			n=p.nextInt();
			int a[]=new int[n];
			int b[]=new int[n];
			for(i=0;i<n;i++)
			{
				a[i]=p.nextInt();
				b[i]=p.nextInt();
			}
			StringBuilder par=new StringBuilder();
			int c=0,j=0,cc,jj=0;
			
			par.append("C");
			cc=0;
			for(i=1;i<n;i++)
			{
			if(a[i]<=a[cc]&&b[i]<=a[cc])
				{
					cc=i;
					
					par.append("C");
				}
				else if(a[i]>=b[cc]&&b[i]>=b[cc])
				{
					cc=i;
					
					par.append("C");
				}
				else if(c==0)
				{
					c=2;
					jj=i;
					par.append("J");
					
				}
				else if(a[i]<=a[jj]&&b[i]<=a[jj]||a[i]>=b[jj]&&b[i]>=b[jj])
				{
					par.append("J");
					jj=i;
				}
				else 
				{
					
					par=new StringBuilder("IMPOSSIBLE");
					break;
					
				}
			}
			
			System.out.print("Case #"+yyy+": "+par);
			yyy++;
			System.out.println();
			t--;
		}
		
	}
}