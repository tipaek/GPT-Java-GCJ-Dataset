import java.util.Scanner;

public class Solution {	static int N;
	static int[] startTime;
	static int[] endTime;
	static int[] C;
	static int[] J;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc=sc.nextInt();
		for(int T=1;T<=tc;T++)
		{
			N=sc.nextInt();
			startTime = new int[N];
			endTime= new int[N];
			for(int i=0;i<N;i++)
			{
				startTime[i]=sc.nextInt();
				endTime[i]=sc.nextInt();		
			}
			
			C = new int[24*60 + 1];
			J = new int[24*60 + 1];
			String ans="";
			
			for(int i=0;i<N;i++)
			{
				int start = startTime[i];
				int end = endTime[i];
				
				if(canAssignToC(start, end))
				{
					ans=ans+'C';
				}
				else if(canAssignToJ(start, end))
				{ 
					ans = ans+'J';		
				}
				else
				{
					ans="IMPOSSIBLE";
					break;
				}
			}			
			System.out.println("Case #"+T+": "+ans);

		}

	}
	
	
	public static boolean canAssignToC(int start, int end)
	{
		for(int i=start;i<end;i++)
		{
			if(C[i]==0)
			{
				C[i]=1;
			}
			else
			{
				for(int k=i-1;k>=start;k--)
				{
					C[k]=0;
				}
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean canAssignToJ(int start, int end)
	{
		for(int i=start;i<end;i++)
		{
			if(J[i]==0)
			{
				J[i]=1;
			}
			else
			{
				for(int k=i-1;k>=start;k--)
				{
					J[k]=0;
				}
				return false;
			}
		}
		
		return true;
	}

}
