import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			int trace = 0;
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(i == j) {
						trace += arr[i][j];
					}
				}
			}
			int row = 0;
			int col = 0;
			outer:
			for(int i = 0; i<N; i++) {
				int[] visit = new int[N+1];
				for(int j = 0; j<N; j++) {
					if(++visit[arr[i][j]] != 1) {
						row++;
						continue outer;
					}
				}
			}
			outer:
			for(int j = 0; j<N; j++) {
				int[] visit = new int[N+1];
				for(int i = 0; i<N; i++) {
					if(++visit[arr[i][j]] != 1) {
						col++;
						continue outer;
					}
				}
			}
			
			bw.write("Case #" + t + ": " + trace + " " + row + " " + col + "\n");
			
		}
		
		
		bw.flush();
		br.close();
		bw.close();
	}

}
