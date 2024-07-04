import java.util.*;
import java.io.*;

public class Solution {
	static int T, N, k, r, c;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			k = 0;
			r = 0;
			c = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				if(isOverlapR(arr, i)) r++;
				if(isOverlapC(arr, i)) c++;
				for(int j=0; j<N; j++) {
					if(i==j) k += arr[i][j];
				}
			}
			
			System.out.println("Case #"+t+": "+k+" "+r+" "+c);
		}
	}
	
	static boolean isOverlapR(int[][] arr, int lc) {
		boolean[] tmp = new boolean[N+1];
		Arrays.fill(tmp, false);
		
		for(int i=0; i<N; i++) {
			if(tmp[arr[lc][i]]) return true;
			else tmp[arr[lc][i]] = true;
		}		
		
		return false;
	}
	
	static boolean isOverlapC(int[][] arr, int lc) {
		boolean[] tmp = new boolean[N+1];
		Arrays.fill(tmp, false);
		
		for(int i=0; i<N; i++) {
			if(tmp[arr[i][lc]]) return true;
			else tmp[arr[i][lc]] = true;
		}		
		
		return false;
	}

}
