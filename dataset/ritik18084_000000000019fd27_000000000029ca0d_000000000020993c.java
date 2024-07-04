import java.io.*;
import java.util.*;

class Solution{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int rows = 0; int cols = 0;
		int trace = 0;
		for(int cases = 0; cases<T; cases++){
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for(int i = 0; i<N; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++){
					int val = Integer.parseInt(st.nextToken());
					arr[i][j] = val;
					if(i == j) trace += val;
				}
			}
			for(int j = 0; j<N; j++) {
				HashMap<Integer,Integer> col_hash = new HashMap<>();
				for(int i = 0; i<N; i++) {
					int val = arr[i][j];
					if(col_hash.get(val) == null) {
						col_hash.put(val, val);
					}
					else { 
						cols++;
						break;
					}
				}
			}
			
			for(int i = 0; i<N; i++) {
				HashMap<Integer,Integer> row_hash = new HashMap<>();
				for(int j = 0; j<N; j++) {
					int val = arr[i][j];
					if(row_hash.get(val) == null) {
						row_hash.put(val, val);
					}
					else { 
						rows++;
						break;
					}
				}
			}
			System.out.println(trace+" "+rows+" "+cols);
			trace = 0; rows = 0; cols = 0;
		}
		System.exit(0);
	}
}