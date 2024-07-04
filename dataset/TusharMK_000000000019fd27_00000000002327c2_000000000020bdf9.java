import java.util.*;
public class Solution3 {

	final static int MINUTES = 1441;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int z = 0 ; z < t ; z++ )
		{
			int [] arr = new int[MINUTES];
			int n = sc.nextInt();
			
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
				char [] status = new char[MINUTES];
				for(int i = 0 ; i < MINUTES ; i++ )
					status[i] = 'z';
				String ans = "";
				for(int j = 0 ; j < n ; j++  )
				{
					for(int i = time[0][j] ; i < time[1][j] ; i++)
					{
						if(arr[i] == 1)
						{
							status[i] = 'C';
						}
						else if(arr[i] == 2 && status[i ] == 'C')
							status[i] = 'J';
						else if(arr[i] == 2 && status[i ] == 'J')
							status[i] = 'C';
						else if(arr[i] == 2 && status[i ] == 'z')
						{
							if(status[i-1] != 'z')
								status[i] = status[i-1];
							else
								status[i] = 'J';
						}
						
					}
					ans += status[time[0][j]];
						
				}
				
				System.out.println("Case #" + (z+1) + ": "+ ans);
			}
		}
		sc.close();

	}

}
