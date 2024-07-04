import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N;
	static int[] S, E;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			S = new int[N+1];
			E = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				S[i] = Integer.parseInt(st.nextToken());
				E[i] = Integer.parseInt(st.nextToken());
			}
			solution(testCase);
		}
		br.close();
	}
	
	private static void solution(int testCase) {
		// Impossible check		
		for (int i = 1; i <= N; i++) {
			int tempS = S[i];
			int tempE = E[i];
			int impossibleCount = 0;
			
			for (int j = 1; j <= N; j++) {
				if(i == j) continue;
				if (tempS <= S[j] && E[j] <= tempE) {
					impossibleCount++;
				}
			}
			if (impossibleCount >= 2) {
				System.out.println("Case #" + testCase + ": " + "IMPOSSIBLE");
				return;
			}
		}
		
		boolean[] cameron = new boolean[1441]; // default false
		boolean[] jamie = new boolean[1441]; // default false
		String result = "";
		
		// apply job schedule
		for (int i = 1; i <= N; i++) {
			int tempS = S[i];
			int tempE = E[i];
			
			boolean isEmptyCameron = true;
			for (int j = tempS + 1; j <= tempE - 1; j++) {
				if(cameron[j] == true) {
					isEmptyCameron = false;
					break;
				}
			}
			if (isEmptyCameron) {
				for (int j = tempS; j <= tempE; j++) {
					cameron[j] = true;
				}
				result += "J";
			} else {
				for (int j = tempS; j <= tempE; j++) {
					jamie[j] = true;
				}
				result += "C";
			}
			
		}
		
		
		// Case #1: CJC
		System.out.println("Case #" + testCase + ": " + result);
	}

}
