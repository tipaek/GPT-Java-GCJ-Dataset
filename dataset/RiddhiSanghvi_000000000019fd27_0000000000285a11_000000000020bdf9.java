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
			/*for(int i =0 ;i<n; i++)
			{
				for(int j=0;j<2;j++)
					System.out.print(a[i][j]+ " ");
				System.out.println();
			}*/
			
			//int status[] = new int[2];
			int etc=0,etj=0,nst=0,stc=0,stj=0;
			for(int i=0 ;i<n; i++)
			{
				if(i==0)
				{
					stc=a[i][0];
					etc=a[i][1];
					s1="C";
					/*System.out.println("ETC : "+etc);
					System.out.println(s1);*/
				}
				else if(i==1)
				{
					stj=a[i][0];
					etj=a[i][1];
					s1+="J";
					/*System.out.println("ETJ : "+etj);
					System.out.println(s1);*/
				}
				else
				{
					nst = a[i][0];
					/*System.out.println("NST : "+nst);
					System.out.println("ETC : "+etc);
					System.out.println("ETJ : "+etj);*/
					if(nst-etc >=0 || nst < stc)
					{
						s1+="C";
						etc = a[i][1];
						stc=a[i][0];
						/*System.out.println("ETC : "+etc);
						System.out.println(s1);*/
					}
					else if(nst-etj >= 0 || nst < stj)
					{
						s1+="J";
						etj = a[i][1];
						stj=a[i][0];
						/*System.out.println("ETJ : "+etj);
						System.out.println(s1);*/
					}
					else
					{
						s1="IMPOSSIBLE";
						//System.out.println(s1);
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
