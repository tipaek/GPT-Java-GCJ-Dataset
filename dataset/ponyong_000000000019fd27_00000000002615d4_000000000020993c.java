import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			int[][] col_map = new int[N][N];
			int sum = 0;
			int[][] row = new int[N][N];
			int[][] col = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = col_map[j][i] = Integer.parseInt(str.nextToken());
					
					if( i == j ) {
						sum += map[i][j];
					}
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					row[i][map[i][j]- 1]++;
					col[i][col_map[i][j]- 1]++;
				}
			}
			int row_cnt = 0;
			int col_cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(row[i][j] > 1) {
						row_cnt++;
						break;
					}
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(col[i][j] > 1) {
						col_cnt++;
						break;
					}
				}
			}
			System.out.println("Case #" + tc + ": " + sum + " " + row_cnt + " " + col_cnt);
		}
	}
}
