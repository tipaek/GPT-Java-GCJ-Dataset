import java.util.*;
class Solution
{
	public static int CalTrace(int arr[][],int size)
	{
		int sum=0;
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				if(i==j)
					sum=sum+arr[i][j];
			}
		}
		return sum;
	}

	public static int CalRows(int arr[][],int size)
	{
		int ctr=0;
		int chk[]=new int[size];
		int line[]=new int[size];
		for(int i=0;i<size;i++)
		{
			chk[i]=i+1;			
		}
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				line[j]=arr[i][j];				
			}
			Arrays.sort(line);
			for(int j=0;j<size;j++)
			{				
				if(line[j]!=chk[j])
					
				{ctr++;break;}
			}
		}

		return ctr;
	}

	public static int CalColumns(int arr[][],int size)
	{
		int ctr=0;
		int chk[]=new int[size];
		int line[]=new int[size];
		for(int i=0;i<size;i++)
		{
			chk[i]=i+1;			
		}
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				line[j]=arr[j][i];				
			}
			Arrays.sort(line);
			for(int j=0;j<size;j++)
			{				
				if(line[j]!=chk[j])
					
				{ctr++;break;}
			}
		}

		return ctr;
	}

	
	
	public static void main(String[] args) 
	{
		Scanner ob=new Scanner(System.in);
		int tests=ob.nextInt();
		
		for(int t=1;t<=tests;t++)
		{
			int size=ob.nextInt();

		    int arr[][]=new int[size][size];

			for(int i=0;i<size;i++)
			{
				for(int j=0;j<size;j++)
				{
					arr[i][j]=ob.nextInt();
				}
			}

			int trace=CalTrace(arr,size);
			int rows=CalRows(arr,size);
			int columns=CalColumns(arr,size);
			System.out.println("Case #"+t+": "+trace+" "+rows+" "+columns);
		}
	}
}
