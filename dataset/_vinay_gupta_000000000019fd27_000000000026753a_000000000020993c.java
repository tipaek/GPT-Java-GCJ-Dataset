import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(sc.readLine());
		int k=1;
		while(t-->0)
		{
			
			int n=Integer.parseInt(sc.readLine());
			int [][] arr=new int[n][n];
			for(int i=0;i<n;i++)
			{
				String[] numbers=sc.readLine().split(" ");
				for(int j=0;j<n;j++)
				{
					arr[i][j]=Integer.parseInt(numbers[j]);
				}
			}
			System.out.println("Case #"+k+": "+trace(arr,n)+" "+countRowsHavingDuplicate(arr,n)+" "+countColumnHavingDuplicate(arr,n));
			k++;
		}
	}

	public static int countRowsHavingDuplicate(int[][] arr, int n) {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=0;i<n;i++)
		{
			int[] temp=new int[n+1];
			int j;
			for(j=0;j<n;j++)
			{
				if(temp[arr[i][j]]!=0)
					break;
				temp[arr[i][j]]++;
			}
			if(j!=n)
				count++;
		}
		return count;
	}

	public static int countColumnHavingDuplicate(int[][] arr, int n) {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=0;i<n;i++)
		{
			int[] temp=new int[n+1];
			int j;
			for(j=0;j<n;j++)
			{
				if(temp[arr[j][i]]!=0)
					break;
				temp[arr[j][i]]++;
			}
			if(j!=n)
				count++;
		}
		return count;
	}

	public static int trace(int[][] arr, int n) {
		// TODO Auto-generated method stub
		int trace=0;
		for(int i=0;i<n;i++)
		{
			trace+=arr[i][i];
		}
		return trace;
	}

}
