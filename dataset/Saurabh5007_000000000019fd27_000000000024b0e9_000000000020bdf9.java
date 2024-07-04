import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	
	static int N;
	static int[] startTime;
	static int[] endTime;
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
			String ans="";
			int[] C = new int[24*60 + 1];
			int[] J = new int[24*60 + 1];
			boolean isPossible = true;
			
			outer : for(int i=0;i<N;i++)
			{
				boolean assignToC = false;
				boolean assignToJ = false;
				int start = startTime[i];
				int end = endTime[i];
				for(int m=start;m<end;m++)
				{
					if(C[m]==0)
					{
						C[m]=1;
						assignToC = true;
					}
					else
					{
						//Rollback
						for(int n=m-1;n>=start;n--)
						{
							C[n]=0;
						}
						assignToC = false;
						m=end;
						
						//Assign to J
						for(int k=start;k<end;k++)
						{
							if(J[k]==0)
							{
								J[k]=1;
								assignToJ=true;
							}
							else
							{
								assignToJ = false;
								isPossible = false;
								break outer;
							}
						}
						
						
					}
				}
				
				if(assignToC)
				{
					ans=ans+"C";
				}
				
				if(assignToJ)
				{
					ans=ans+"J";
				}
			}
			/*String ans = "";
			sort(0,N-1);
			char[] assignment=new char[N];
			int assignCounter = 0;
			assignment[0]='C';
			assignCounter++;
			int cend = endTime[0];
			int jend=0;
			for(int i=1;i<N;i++)
			{
				if(startTime[i]>=cend)
				{
					assignment[i]='C';
					assignCounter++;
					cend=endTime[i];
				}
				else
				{
					if(startTime[i]>=jend)
					{
						assignment[i]='J';
						jend = endTime[i];
						assignCounter++;
					}
					
				}
			}
			if(assignCounter==N)
			{
				ans=String.valueOf(assignment);
				
			}
			else
			{
				ans="IMPOSSIBLE";
			}
			*/
			
			if(!isPossible)
			{
				ans= "IMPOSSIBLE";
			}
			
			System.out.println("Case #"+T+": "+ans);

		}

	}
	
	/*public static void sort(int start, int end)
	{
		if(start>=end)
		{
			return;
		}
		int mid=start+(end-start)/2;
		int pivot=startTime[mid];
		
		int i=start;
		int j=end;
		
		while(i<j)
		{
			while(startTime[i]<pivot)
			{
				i++;
			}
			
			while(startTime[j]>pivot)
			{
				j--;
			}
			
			if(i<=j)
			{
				swap(startTime,i,j);
				swap(endTime,i,j);
				i++;
				j--;
			}
		}
		
		if(start<j)
		{
			sort(start, j);
		}
		
		if(end>i)
		{
			sort(i,end);
		}
		
	}
	
	public static void swap(int[] arr, int x, int y)
	{
		int temp = arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
		
	}*/

}
