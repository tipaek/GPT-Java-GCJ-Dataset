

import java.util.Scanner;


class time
{
	int t1=-3,t2=-1;
}
public class Solution {
public static void main(String[] args)
{
	int ctc = 0,ctj=0;
	Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	int T = sc.nextInt();
	for(int i=1;i<=T;i++)
	{
		int N = sc.nextInt();
		int c=0,j1=0;
		char sol[] = new char[N];
		time Time[] = new time[N];
		time C[] = new time[N];
		time J[] = new time[N];
		for(int j=0;j<N;j++)
		{
			//System.out.println("Enter "+(j+1)+"time");
			Time[j] = new time();
			Time[j].t1 = sc.nextInt();
			Time[j].t2 = sc.nextInt();
		}
		
		for(int j=0;j<N;j++)
		{
			C[j] = new time();
			J[j] = new time();
		}
		int b = 0;
		for(int j=0;j<N;j++)
		{
			b = 0;
			if(C[0].t1==-3)
			{
				C[c].t1 = Time[j].t1;
				C[c].t2 = Time[j].t2;
				c++;
				sol[j] = 'C';
			}
			else if(J[0].t1==-3)
			{
				J[j1].t1 = Time[j].t1;
				J[j1].t2 = Time[j].t2;
				j1++;
				sol[j] = 'J';
			}
			else 
			{
				ctc = 0;
				ctj = 0;
				for(int g=0;g<N;g++)
				{
					if((Time[j].t1<C[g].t2 && Time[j].t1>C[g].t1) || (Time[j].t2<C[g].t2 && Time[j].t2>C[g].t1))
					{
						//System.out.println(" g:"+g+"C[g].t1: "+C[g].t1+" Time[j].t1: "+Time[j].t1+" C[g].t2: "+C[g].t2+" Time[j].t2"+Time[j].t2);
						ctc = -1;
					}
					if((Time[j].t1<J[g].t2 && Time[j].t1>J[g].t1) || (Time[j].t2<J[g].t2 && Time[j].t2>J[g].t1))
					{
						//System.out.println(" g:"+g+"J[g].t1: "+J[g].t1+" Time[j].t1: "+Time[j].t1+" J[g].t2: "+J[g].t2+" Time[j].t2"+Time[j].t2);
						ctj = -1;
					}
				}
				//System.out.println(ctc+" "+ctj);
				if(ctc == 0)
				{
					C[c].t1 = Time[j].t1;
					C[c].t2 = Time[j].t2;
					c++;
					sol[j] = 'C';
				}
				else if(ctj == 0)
				{
					J[j1].t1 = Time[j].t1;
					J[j1].t2 = Time[j].t2;
					j1++;
					sol[j] = 'J';
				}
				else if(ctc==-1&&ctj==-1)
				{
					System.out.println("Case #"+i+": IMPOSSIBLE");
					b++;
					break;
				}
			}
				
		}
		if(b==0)
		{
		String str = new String(sol);
		System.out.println("Case #"+i+": "+str);
		}
	}
}
}
