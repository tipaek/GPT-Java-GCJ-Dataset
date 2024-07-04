import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args)
	{
	Scanner in=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T=in.nextInt();
		for(int i=1;i<=T;i++)
		{
			int N=in.nextInt();
			String[][] schd=new String[N][24*60+1];
			String op="";
			int impossibleflag=0;
			for(int j=0;j<N;j++)
			{
				int starttime=in.nextInt();
				int endtime=in.nextInt();
				int Cflag=0,Jflag=0;
				for(int k=starttime;k<endtime;k++)
				{
					for(int m=0;m<j;m++)
					{
						if(schd[m][k]=="C")
							Cflag=1;
						if(schd[m][k]=="J")
							Jflag=1;
					}						
				}
				

				if(Cflag==0)
				{
					for(int k=starttime;k<endtime;k++)
					{
						schd[j][k]="C";
					}
				}					
				else if(Jflag==0)
				{
					for(int k=starttime;k<endtime;k++)
					{
						schd[j][k]="J";
					}
				}					
				else
					impossibleflag=1;
			}
			
			for(int j=0;j<N;j++)
			{
				for(int k=0;k<24*60+1;k++)
				{
					if(schd[j][k]=="C" ||schd[j][k]=="J")
					{
						op+=schd[j][k];
						break;
					}			
						
				}
			}
			if(impossibleflag==1)
				System.out.println("Case #" + i + ": IMPOSSIBLE"  );
			else
				System.out.println("Case #" + i + ": "  +op);
			}
			
	}			
}