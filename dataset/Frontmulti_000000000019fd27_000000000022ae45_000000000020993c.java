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
		int maxR = 0, maxC = 0, tempR = 0, tempC = 0;
		int tempRcnt = 0, tempCcnt = 0;
		
		for (int x = 0; x < N; x++) {
			tempRcnt = 0;
			tempR =  0;
			for (int y = 0; y < N; y++) {
				// k 
				if (x == y) {
					k += M[x][y];
				}
				
				// r
				if (tempR == M[x][y]) {
					tempRcnt++;
					if (maxR < tempRcnt) {
						maxR = tempRcnt;
					}
				} else {
					tempRcnt = 0;
				}
				tempR = M[x][y];
			}
		}
		
		for (int y = 0; y < N; y++) {
			tempCcnt = 0;
			tempC = 0;
			for (int x = 0; x < N; x++) {
				// c
				if (tempC == M[x][y]) {
					tempCcnt++;
					if (maxC < tempCcnt) {
						maxC = tempCcnt;
					}
				} else {
					tempCcnt = 0;
				}
				tempC = M[x][y];
			}
		}
		
		r = maxR == 0 ? 0 : maxR + 1;
		c = maxC == 0 ? 0 : maxC + 1;
		System.out.println("Case #" + testCase + ": " + k + " " + r + " " + c);
	}

}
