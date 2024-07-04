import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N;
	static int[][] M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			M = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					M[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			solution(testCase);
		}
		br.close();
		
	}
	
	private static void solution(int testCase) {
		int k = 0, r = 0, c = 0;
		int maxR = 0, maxC = 0;
		int[] tempR;
		int[] tempC;
		
		for (int x = 0; x < N; x++) {
			tempR = new int[N+1];
			tempC = new int[N+1];
			for (int y = 0; y < N; y++) {
				// k 
				if (x == y) {
					k += M[x][y];
				}
				
				// r
				tempR[M[x][y]]++;
				
				// c
				tempC[M[y][x]]++;
				
			}
			
			boolean isPlusR = false, isPlusC = false;
			for (int i = 0; i <= N; i++) {
				if(tempR[i] >= 2) {
					isPlusR = true;
				}
				if(tempC[i] >= 2) {
					isPlusC = true;
				}
			}
			maxR = isPlusR ? maxR+1 : maxR;
			maxC = isPlusC ? maxC+1 : maxC;
		}
		
		r = maxR;
		c = maxC;
		System.out.println("Case #" + testCase + ": " + k + " " + r + " " + c);
	}

}
