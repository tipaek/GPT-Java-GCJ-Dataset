
import java.util.*;
class Solution
{
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int r=0;r<t;r++)
		{
			int n = scan.nextInt();
			long arr[][] = new long[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					arr[i][j] = scan.nextLong();
			int rows=0,cols=0;
			int sum=0;
			for(int i=0;i<n;i++)
			{
				if(checkRepeat(arr[i]))rows++;
				if(checkRepeat(getColumn(arr,i)))cols++;	
				sum+=arr[i][i];
			}
			System.out.println("Case #"+(r+1)+": " + sum + " " + rows + " " + cols);	
		}

	}
	static boolean checkRepeat(long arr[])
	{
		//for(long x:arr)System.out.print(x + " ");
		//System.out.println();
		long arr2[] = arr.clone();
		Arrays.parallelSort(arr2);
		for(int i=0;i<arr2.length-1;i++)
		{
			if(arr2[i] == arr2[i+1])
			{
				return true;
			}
		}
		if(arr2[arr2.length-1] == arr2[arr2.length-2]) return true;
		return false;
	}
	public static long[] getColumn(long array[][], int index)
	{
		/*for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}*/
	    long[] column = new long[array[0].length]; 
	    for(int i=0; i<column.length; i++)
	    {
	       column[i] = array[i][index];
	    }
	  //  for(long x:column)System.out.print(x + " ");
	//	System.out.println();
	    return column;
	}

}
