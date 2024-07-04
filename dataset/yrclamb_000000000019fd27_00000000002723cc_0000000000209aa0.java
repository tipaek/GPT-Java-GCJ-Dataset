import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public List<String> solve(int N, int K) {
		List<String> ans = new ArrayList<>();
		if(K == N*N - 1 || K == N+1) {
			ans.add("IMPOSSIBLE");
			return ans;
		}
		if(N == 3 && K == 5) {
			ans.add("IMPOSSIBLE");
			return ans;
		}
		if(N == 3 && K == 7) {
			ans.add("IMPOSSIBLE");
			return ans;
		}
		
		int[][] M = new int[N][N];
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			M[i][i] = K / (N-i);
			K -= M[i][i];
			
			map.put(M[i][i], map.getOrDefault(M[i][i], 0)+1);
		}
		
		if(map.size() == 2) {
			//System.out.println(map);
			int i = 0;
			int[][] count = new int[2][2];
			for(int k : map.keySet()) {
				count[i][0] = k;
				count[i][1] = map.get(k);
				i++;
			}
			if(count[0][1] == 1) {
				if(count[1][0] == N || count[1][0] == 1) {
					ans.add("IMPOSSIBLE");
					return ans;
				}
				boolean ok = false;
				for(i = 0; i < N; i++) {
					if(!ok && M[i][i] == count[1][0]) {
						ok = true;
						M[i][i]--;
					}
					else if(ok && M[i][i] == count[1][0]) {
						M[i][i]++;
						break;
					}
				}
			}
			else if(count[1][1] == 1) {
				if(count[0][0] == N || count[0][0] == 1) {
					ans.add("IMPOSSIBLE");
					return ans;
				}
				boolean ok = false;
				for(i = 0; i < N; i++) {
					if(!ok && M[i][i] == count[0][0]) {
						ok = true;
						M[i][i]--;
					}
					else if(ok && M[i][i] == count[0][0]) {
						M[i][i]++;
						break;
					}
				}
			}
		}
		
		int[] diag = new int[N];
		for(int i = 0; i < N; i++) {
			diag[i] = M[i][i];
		}
		Arrays.sort(diag);
		for(int i = 0; i < N; i++) {
			M[i][i] = diag[N-i-1];
		}
		sub(N, M);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(M[i][j] == 0) {
					M = new int[N][N];
					for(int ii = 0; ii < N; ii++) {
						M[ii][ii] = diag[ii];
					}
					sub(N, M);
				}
			}
		}
		
		ans.add("POSSIBLE");
		for(int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder("");
			for(int j = 0; j < N; j++) {
				sb.append(M[i][j] + " ");
			}
			sb.deleteCharAt(sb.length() - 1);
			ans.add(sb.toString());
			//System.out.println(Arrays.toString(M[i]));
		}
		
		return ans;
	}
	
	private void sub(int N, int[][] M) {
		List<Set<Integer>> rows = new ArrayList<>();
		List<Set<Integer>> columns = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			Set<Integer> set = new HashSet<>();
			for(int j = 1; j <= N; j++) set.add(j);
			rows.add(set);
		}
		for(int i = 0; i < N; i++) {
			Set<Integer> set = new HashSet<>();
			for(int j = 1; j <= N; j++) set.add(j);
			columns.add(set);
		}
		
		for(int i = 0; i < N; i++) {
			rows.get(i).remove(M[i][i]);
			columns.get(i).remove(M[i][i]);
		}
		
		for(int i = 0; i < N*N; i++) {
			int candidate = 99999999;
			int canX = -1;
			int canY = -1;
			
			for(int ii = 0; ii < N; ii++) {
				for(int jj = 0; jj < N; jj++) {
					if(M[ii][jj] != 0) continue;
					
					int cnt = 0;
					for(int n : rows.get(ii)) {
						if(columns.get(jj).contains(n)) cnt++;
					}
					
					if(cnt < candidate) {
						candidate = cnt;
						canX = ii;
						canY = jj;
					}
					
				}
			}
			if(canX == -1) break;
			
			for(int n : rows.get(canX)) {
				if(columns.get(canY).contains(n)){
					M[canX][canY] = n;
					rows.get(canX).remove(n);
					columns.get(canY).remove(n);
					break;
				}
			}
			
			/*
			for(int ii = 0; ii < N; ii++) {
				System.out.println(Arrays.toString(M[ii]));
			}
			System.out.println("");
			*/
		}
	}
	
	public static void mainX(String[] args) {
		Solution Q = new Solution();
		System.out.println(Q.solve(4,11));
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Solution Q = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			int N = in.nextInt();
			int K = in.nextInt();
			List<String> ans = Q.solve(N, K);
			System.out.println("Case #" + i + ": " + ans.get(0));
			for(int j = 1; j < ans.size(); j++)
				System.out.println(ans.get(j));
			System.out.flush();
		}
	}

}
