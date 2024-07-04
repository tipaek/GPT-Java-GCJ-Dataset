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
			int[][] col_arr = new int[N+1][N];
			for(int i = 0; i<N; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int[] row_arr = new int[N+1];
				for(int j = 0; j<N; j++){
					int val = Integer.parseInt(st.nextToken());
					if(i == j) trace += val;
					if(row_arr[0] == 0){
						if(row_arr[val] == 0) row_arr[val] = val;
						else {
							row_arr[0] = 1;
							rows++;
						}
					}
					if(col_arr[0][j] == 0){
						if(col_arr[val][j] == 0) col_arr[val][j] = val;
						else{
							col_arr[0][j] = 1;
							cols++;
						}
					}
				}
			}
			System.out.println("Case #"+(cases+1)+": "+trace+" "+rows+" "+cols);
			trace = 0; rows = 0; cols = 0;
		}
	}
}