import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		int t = 1;
		while (t <= T) {
			int N = scn.nextInt();
			int[][] arr = new int[N][N];
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					arr[row][col] = scn.nextInt();
				}
			}

			int trace = 0;
			for (int i = 0; i < N; i++) {
				trace += arr[i][i];
			}

			int r = 0;
			int []freq=new int[N+1];
			int sumelements = 0;
			for (int i = 0; i < N; i++) {
				
				for (int j = 0; j < N; j++) {
					freq[arr[i][j]]+=1;
					if(freq[arr[i][j]]>=2)
					{
						r++;
						break;
					}
				}
				for(int in=1;in<freq.length;in++)
				{
					freq[in]=0;
				}
			}
			int c = 0;
			for (int j = 0; j < N; j++) {
				
				for (int i = 0; i < N; i++) {
					freq[arr[i][j]]+=1;
					if(freq[arr[i][j]]>=2)
					{
						c++;
						break;
					}
				}
				for(int in=1;in<freq.length;in++)
				{
					freq[in]=0;
				}
				
			}

			System.out.println("Case #" + t + ": " + trace + " " + r + " " + c);
			t++;
		}

	}

}
