import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
        	int N = in.nextInt();
        	int K = in.nextInt();
        	Solution solution = new Solution(N, K);
        	System.out.println("Case #" + i + ": "+ solution.getSolution());
        }
    }
	
	private int[][] matrix;
	private boolean[][] rows;
	private boolean[][] columns;
	private int N;
	private int K;
	
	public Solution(int N, int K) {
		this.N = N; this.K = K;
		
		matrix = new int[N][N];
		solve();
	}
	
	private List<Integer> list = new ArrayList<>();
	private void solve() {
		if(K<N || N*N < K) {
			solution = "IMPOSSIBLE";
			return;
		}
		rows = new boolean[N][N+1];
		columns = new boolean[N][N+1];
		
		if(!dfs(0, 0)) solution = "IMPOSSIBLE";
		else {
			solution = "POSSIBLE\n";
			for(int i = 0; i < N; i++) {
				String joined = Arrays.stream(matrix[i])
						  .mapToObj(String::valueOf)
						  .collect(Collectors.joining(" "));
				solution += joined;
				if(i < N - 1) solution += "\n";
			}
		}
	}
	private int trace = 0;
	
	boolean dfs(int x, int y) {
		if(x == N && y == 0) return trace == K;
		
		int nextX = x, nextY = y + 1;
		if(nextY >= N) {nextX++; nextY=0;}
		
		
		List<Integer> list = getAvailable(x, y);
		if(list.isEmpty()) return false;
		
		for(Integer i: list) {
			if(x == y) trace += i;
			matrix[x][y] = i;
			rows[x][i] = true;
			columns[y][i] = true;
			if(dfs(nextX, nextY)) return true;
			matrix[x][y] = 0;
			rows[x][i] = false;
			columns[y][i] = false;
			if(x == y) trace -= i;
		}
		return false;
	}
	
	List<Integer> getAvailable(int x, int y) {
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= N; i++)
			if(!rows[x][i] && !columns[y][i])
				list.add(i);
		Collections.shuffle(list);
		return list;
	}
	
	public String getSolution() {return solution;}
	private String solution = "";
}
