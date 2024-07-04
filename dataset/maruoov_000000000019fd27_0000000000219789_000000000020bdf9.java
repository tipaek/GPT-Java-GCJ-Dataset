import java.util.*;
class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int cn = 1;
		while(T > 0) {
			T--;

			int N = sc.nextInt();

            int[][] schedule = new int[N][2];
            boolean[] C = new boolean[1441];
            boolean[] J = new boolean[1441];
            for (int i = 0; i < N; i++) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                schedule[i][0] = n;
                schedule[i][1] = m;
            }    
            
            // StringBuilder sb = new StringBuilder();
            String res = "";
            for (int i = 0; i < N; i++) {
                int n = schedule[i][0];
                int m = schedule[i][1];
                
                boolean canC = true;
                for (int j = n + 1; j <= m; j++) {
                    if (C[j]) {
                        canC = false;
                        break;
                    }
                }
                
                if (canC) {
                    for (int j = n; j <= m; j++) {
                        C[j] = true;
                    }
                    
                    res += 'C';
                    continue;
                }
                
                boolean canJ = true;
                for (int j = n + 1; j <= m; j++) {
                    if (J[j]) {
                        canJ = false;
                        break;
                    }
                }
                
                if (canJ) {
                    for (int j = n; j <= m; j++) {
                        J[j] = true;
                    }
                    
                    res += 'J';
                    continue;
                }
               
               res = "IMPOSSIBLE";
               break;
                // if (!canC && !canJ) {
                //     res = "IMPOSSIBLE";
                //     break;
                // }
            }
            
            
			System.out.printf("Case #%d: %s%n",cn, res);
			cn++;

		}
	}
}