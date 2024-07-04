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
			int n,i,temp,j=0;
			n=p.nextInt();
			int a[]=new int[n];
			int b[]=new int[n];
			int aa[]=new int[n];
			int bb[]=new int[n];
			for(i=0;i<n;i++)
			{
				a[i]=p.nextInt();
				b[i]=p.nextInt();
			}
			aa=a;
			bb=b;
			
			for(i=0;i<n-1;i++)
			{
				for(j=0;j<n-i-1;j++)
				{
					if(aa[j]>aa[j+1])
					{
						temp=aa[j];
						aa[j]=aa[j+1];
						aa[j+1]=temp;
						temp=b[j];
						b[j]=b[j+1];
						b[j+1]=temp;
					}
				}
			}
			/*for(i=0;i<n;i++)
				System.out.println(aa[i]+"  "+bb[i]);*/
			a=aa;
			b=bb;
			System.out.println();
			StringBuilder par=new StringBuilder();
			int c=0,cc,jj=0;
			
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
			
			System.out.print("Case #"+yyy+": "+par.toString());
			yyy++;
			System.out.println();
			t--;
		}
		
	}
}