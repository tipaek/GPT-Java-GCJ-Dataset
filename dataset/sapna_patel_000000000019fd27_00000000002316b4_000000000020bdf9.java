import java.util.Scanner;
class codejam
{
	public static void main(String[] args) {
		int testcase;
		codejam cj=new codejam();
		Scanner sc=new Scanner(System.in);
		testcase=sc.nextInt();
		for(int i=0;i<testcase;i++)
		{
			cj.Calc(sc,i);
		}
	}
	public void Calc(Scanner sc,int k)
	{
		int cid=-1,jid=-1;
		int event;
		String out="";
		boolean possible=true;
		event=sc.nextInt();
		int a[][]=new int[event][2];
		for(int i=0;i<event;i++)
		{
			for(int j=0;j<2;j++)
			{
				a[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<event;i++)
		{
			int cur=a[i][0];
			if(cid==-1 || a[cid][1]<=cur)
			{
				out+="C";
				cid=i;
			}
			else if(jid==-1 || a[jid][1]<=cur)
			{
				out+="J";
				jid=i;
			}
			else
			{
				possible=false;
				break;
			}
		}
		if(possible)
		{
			System.out.println("Case #"+ ( k+1 ) +":"+out);
		}
		else
		{
			System.out.println("Case #"+ ( k+1 ) +":IMPOSSIBLE");
		}
	}
}