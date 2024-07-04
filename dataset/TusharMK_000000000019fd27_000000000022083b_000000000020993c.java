import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int z = 0 ; z < t ; z++ )
		{
			int n = sc.nextInt();
			long arr[][] = new long[n][n];
			for(int i = 0 ; i < n ; i++ )
			{
				for(int j = 0 ; j < n ; j++ )
				{
					arr[i][j] = sc.nextLong();
				}
			}
			long k = findTrace(arr, n);
			int r = 0 ;
			int c = 0 ;
			Set<Long> set = new HashSet<Long>();
			for(int i = 0 ; i < n ; i++ )
			{
				set.clear();
				for(int j = 0 ; j < n ; j++ )
				{
					set.add(arr[i][j]);
				}
				if(set.size() != n )
				{
					r++;
				}
				
			}
			for(int i = 0 ; i < n ; i++ )
			{
				set.clear();
				for(int j = 0 ; j < n ; j++ )
				{
					set.add(arr[j][i]);
				}
				if(set.size() != n )
				{
					c++;
				}
				
			}
			System.out.println("Case #" + (z+1) + ": "+ k + " " + r + " "+c);
			
			
		}
		sc.close();
	}
	public static long findTrace(long mat[][], int n) 
	{ 
	    long sum = 0; 
	    for (int i=0; i<n; i++) 
	        sum += mat[i][i]; 
	    return sum; 
	} 

}
