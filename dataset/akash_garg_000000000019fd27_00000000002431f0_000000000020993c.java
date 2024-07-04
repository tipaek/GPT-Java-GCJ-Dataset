
// you can also use imports, for example:
import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int test_cases = in.nextInt();
		for(int q = 1; q <= test_cases; q++) {
			int num = in.nextInt();
			int[][] arr = new int[num][num];
			long sum = 0, row = 0, col = 0;
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < num; j++) {
					arr[i][j] = in.nextInt();
				}
			}
			for(int x = 0; x < num; x++) {
				sum += arr[x][x];
			}
			
			for (int i = 0; i < num; i++) {
				boolean[] dp = new boolean[num + 1];
				boolean flag = true;
				for (int j = 0; j < num; j++) {
					if(dp[arr[i][j]] == true)
					{
						flag = false;
						break;
					}
					else
						dp[arr[i][j]] = true;
				}
				if(!flag)
					row++;
				flag = true;
				dp = new boolean[num + 1];
				for (int j = 0; j < num; j++) {
					if(dp[arr[j][i]] == true)
					{
						flag = false;
						break;
					}
					else
						dp[arr[j][i]] = true;
				}
				if(!flag)
					col++;
			}
			System.out.println("Case #"+ q +": "+sum+" "+row+" "+col);
		}
	}
}
