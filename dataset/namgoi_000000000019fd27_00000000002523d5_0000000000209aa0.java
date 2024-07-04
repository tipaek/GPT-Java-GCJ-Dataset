import java.util.*;
import java.io.*;

public class Solution {
	private static boolean ispossible;
	private static int N;
	private static int[][] map;
	private static boolean[][] col;
	private static boolean[][] row;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int testcase = 1; testcase <=T; testcase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int WANT = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			col = new boolean[N][N+1];
			row = new boolean[N][N+1];
			ispossible = false;
			if(WANT%N==0) {
				int val = WANT/N;
				for (int i = 0; i < N; i++) {
					map[i][i]=val;
					row[i][val]=true;
					col[i][val]=true;
				}
				go(1);
			}else if(WANT==(N*N)-1 || WANT==N+1){
				ispossible = false;
			}else {
				int val = N;
				for (int i = N; i > 0; i--) {
					if(WANT>i*N) break;
					val = i;
				}
				int gap = val*N-WANT;
				if(val-1>0) {
					if(gap==1) {
						map[0][0]=val+1;
						row[0][val+1]=true;
						col[0][val+1]=true;
						for (int i = 1; i < N-2; i++) {
							map[i][i]=val;
							row[i][val]=true;
							col[i][val]=true;
						}
						for (int i = N-2; i < N; i++) {
							map[i][i]=val-1;
							row[i][val-1]=true;
							col[i][val-1]=true;
						}
					}else {
						for (int i = 0; i < N-gap; i++) {
							map[i][i]=val;
							row[i][val]=true;
							col[i][val]=true;
						}
						for (int i = N-gap; i < N; i++) {
							map[i][i]=val-1;
							row[i][val-1]=true;
							col[i][val-1]=true;
						}
					}
					go(1);
				}else {
					ispossible=false;
				}
			}
			if(ispossible) {
				System.out.println("Case #"+testcase+": POSSIBLE");
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						System.out.print(map[i][j] + " ");
					}
					System.out.println();
				}
			}else {
				System.out.println("Case #"+testcase+": IMPOSSIBLE");
			}
		}
	}
	private static void go(int cur) {
		if(cur==N*N) {
			ispossible=true;
			return;
		}
		int cur_row = (cur/N);
		int cur_col = (cur%N);
		if(map[cur_row][cur_col]!=0) {
			go(cur+1);
		}else {
			for (int i = 1; i <=N; i++) {
				if(row[cur_row][i]) continue;
				if(col[cur_col][i]) continue;
				row[cur_row][i]=true;
				col[cur_col][i]=true;
				map[cur_row][cur_col]=i;
				go(cur+1);
				if(ispossible) return;
				map[cur_row][cur_col]=0;
				row[cur_row][i]=false;
				col[cur_col][i]=false;
			}
		}
	}
}

