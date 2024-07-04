import java.io.*;
import java.util.Scanner;

class Solution
{	
	public static void main(String[] args) 
	{
		int cases=1;
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		while(t!=0)
		{
			int n =sc.nextInt();
			String s1="";
			int a[][] = new int[n][2];
			for(int i=0 ;i<n; i++)
			{
				for(int j=0;j<2;j++)
				{
					a[i][j] = sc.nextInt();
				}
			}
						int etc=0,etj=0,nst=0,stc=0,stj=0;
			for(int i=0 ;i<n; i++)
			{
				if(i==0)
				{
					stc=a[i][0];
					etc=a[i][1];
					s1="C";
				}
				else if(i==1)
				{
					nst=a[i][0];
					if(nst== etc)
					{
						stc=a[i][0];
						etc=a[i][1];
						s1+="C";
					}
					else
					{
						stj=a[i][0];
						etj=a[i][1];
						s1+="J";
					}
					
				}
				else
				{
					nst = a[i][0];
					if(nst-etc >=0 || nst < stc)
					{
						s1+="C";
						etc = a[i][1];
						stc=a[i][0];
					}
					else if(nst-etj >= 0 || nst < stj)
					{
						s1+="J";
						etj = a[i][1];
						stj=a[i][0];
					}
					else
					{
						s1="IMPOSSIBLE";
						break;
					}
				}
			}
			
			System.out.println("Case #"+cases+": "+s1);
			t--;
			cases++;
		}
		

	}

}
