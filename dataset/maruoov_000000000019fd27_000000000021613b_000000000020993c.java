import java.util.*;
class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int cn = 1;
		while(T > 0) {
			T--;
			
			int N = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
			    for (int j = 0; j < N; j++) {
			        int c = sc.nextInt();
			        map[i][j] = c;
			    }
			}
			
			int row = 0;
			int col = 0;
			int k = 0;
			
			for (int i = 0; i < N; i++) {
			    Map<Integer, Integer> trace = new HashMap<>();
			    for (int j = 0; j < N; j++) {
			        if (trace.get(map[i][j]) != null) {
			            row++;
			            break;
			        }
			        trace.put(map[i][j], map[i][j]);
			    }
			    
			    trace.clear();
			    for (int j = 0; j < N; j++) {
			        if (trace.get(map[j][i]) != null) {
			            col++;
			            break;
			        }
			        
			        trace.put(map[j][i], map[j][i]);
			    }
			}
			
			for (int i = 0; i < N; i++) {
			    for (int j = 0; j < N; j++) {
			        if (i == j) k += map[i][j];
			    }
			}
	
			System.out.printf("Case #%d: %d %d %d%n",cn, k,row,col);
			cn++;

		}
	}
}
