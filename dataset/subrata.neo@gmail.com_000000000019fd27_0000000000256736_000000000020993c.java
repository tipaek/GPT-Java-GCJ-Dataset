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
			int[][] tmp=new int[N+1][N+1];
			int[][] tracerow=new int[N+1][N+1];
			int[][] tracecol=new int[N+1][N+1];
			int total_val=0;
			for(int j=1;j<=N;j++)
			{
			    for(int k=1;k<=N;k++)
			    {
			        tmp[j][k]=in.nextInt();
			        if(tracerow[j][tmp[j][k]]==0)
			            tracerow[j][tmp[j][k]]=1;
			        else
			            tracerow[j][0]=1;
			        if(tracecol[k][tmp[j][k]]==0)
			            tracecol[k][tmp[j][k]]=1;
			        else
			            tracecol[k][0]=1;
			        if(j==k)
			            total_val+=tmp[j][k];
			    }
			}
			int rowcnt=0,colcnt=0;
			for(int j=1;j<=N;j++)
			{
			    if(tracecol[j][0]==1)
			        colcnt++;
			    if(tracerow[j][0]==1)
			        rowcnt++;
			}
			System.out.println("Case #" + i + ": " + total_val + " " +rowcnt+ " " +colcnt);
			
		}

	}
}