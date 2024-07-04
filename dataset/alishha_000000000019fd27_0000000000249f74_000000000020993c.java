import java.util.*;
class Main {
	public static void main(String[] args)
	{
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for(int x=1; x<=t; x++)
		{   
			int sumd =0;
			int cntr =0;  // count row
			int cntc=0;  //count col
			int n =scn.nextInt();
			int [][]arr= new int[n][n];
			for( int i =0 ; i<arr.length;i++)
			{
				for( int j =0;j<arr.length;j++)
				{
					arr[i][j] = scn.nextInt();
					if(i==j)
					{                            // diag summ
						sumd+= arr[i][j]; 
					}
				}
			}
			//ROWS
			for(int k=0; k<arr.length; k++) // k is for no of rows
			{
				for( int i =0 ; i<arr.length-1;i++)
				{
					int cnt=0;
					for( int j=i+1;j<arr.length;j++)
					{
						if(arr[k][i]==arr[k][j])
						{
							cnt++;
						} 
						if(cnt>0)
						{
							cntr+=1;
						}
					}
				}
			}
			
			// columns
			for(int k=0; k<arr.length; k++) // k is for no of col
			{
				for( int i =0 ; i<arr.length-1;i++)
				{
					int cnt=0;
					for( int j=i+1;j<arr.length;j++)
					{
						if(arr[i][k]==arr[j][k])
						{
							cnt++;
						} 
						if(cnt>0)
						{
							cntc+=1;
						}
					}
				}
			}
			
			System.out.println("Case #"+x + ": "+sumd +" "+cntr +" "+cntc);
			
		}
	}

}
