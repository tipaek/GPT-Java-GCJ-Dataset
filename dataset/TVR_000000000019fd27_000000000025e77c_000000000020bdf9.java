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
			int iron=0;
			int n,i,temp,cap=0;
			n=p.nextInt();
			int a[]=new int[n];
			int b[]=new int[n];
			int drum=0,stark=0;
			for(i=0;i<n;i++)
			{
				a[i]=p.nextInt();
				b[i]=p.nextInt();
				if(a[i]>b[i])
					drum=9;
				if(a[i]==b[i]&&stark==a[i])
				{
					iron++;
					stark=a[i];
				}
			}
			StringBuilder par=new StringBuilder();
			int c=0,j=0,cc,jj=0;
			
			par.append("C");
			cc=0;
			if(a[0]==b[0])
					cap=1;
			for(i=1;i<n;i++)
			{
				
				
			if(a[i]<=a[cc]&&b[i]<=a[cc]&&cap==0)
				{
					cc=i;
					
					par.append("C");
				}
				else if(a[i]>=b[cc]&&b[i]>=b[cc]&&cap==0)
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
				if(a[i]==b[i])
					cap=1;
			}
			if(drum==9)
				par=new StringBuilder("IMPOSSIBLE");
			if(iron==3)
				par=new StringBuilder("IMPOSSIBLE");
			
			System.out.print("Case #"+yyy+": "+par.toString());
			yyy++;
			System.out.println();
			t--;
		}
		
	}
}