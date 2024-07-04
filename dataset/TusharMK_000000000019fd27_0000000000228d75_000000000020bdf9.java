import java.util.*;
public class Solution {

	final static int MINUTES = 1441;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int z = 0 ; z < t ; z++ )
		{
			int [] arr = new int[MINUTES];
			int n = sc.nextInt();
			String ans = "";
			int [][]time = new int[2][n];
			for(int i = 0 ; i < n ; i++ )
			{
				arr[time[0][i] =sc.nextInt()] += 1;
				arr[time[1][i]= sc.nextInt()] += -1;
			}
			boolean flag = true;
			for(int i = 1 ; i < MINUTES ; i++ )
			{
				arr[i] += arr[i-1]; 
				if(arr[i] > 2)
				{
					System.out.println("Case #" + (z+1) + ": IMPOSSIBLE");
					flag = false;
					break;
				}
			}
			if(flag)
			{
				for(int i = 0 ; i < n ; i++  )
				{
					if(arr[time[0][i]] == 1 )
					{
						ans += 'C';
					}
					else if(arr[time[0][i]] == 2 && arr[time[0][i] -1 ] == 1  )
					{
						ans+= 'J';
					}
					else if(arr[time[0][i]] == 2 && arr[time[0][i] -1 ] == 2  )
					{
						ans+= 'C';
					}
				}
				System.out.println("Case #" + (z+1) + ": "+ ans);
			}
		}
		sc.close();

	}

}