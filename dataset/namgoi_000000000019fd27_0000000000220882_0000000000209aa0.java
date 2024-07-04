import java.util.*;
import java.io.*;

public class Solution {
	static boolean ispossible;
	private static int WANT;
	private static int N;
	private static int sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int testcase = 1; testcase <=T; testcase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			WANT = Integer.parseInt(st.nextToken());
			int[][] x = new int[N][N];
			for (int i = 0; i <N; i++) {
				for (int j = 0; j < N; j++) {
					x[j][(j+i)%N]=i+1;					
				}
			}
			ispossible=false;
			sum=N;
			perm(x, 0);
			if(ispossible) {
				System.out.println("Case #"+testcase+": POSSIBLE");
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						System.out.print(x[i][j] + " ");
					}
					System.out.println();
				}
			}else {
				System.out.println("Case #"+testcase+": IMPOSSIBLE");
			}
		}
	}
	public static void perm(int[][] arr, int depth) {
		if (depth == N) return;
		for (int i = depth; i < N; i++) {
			swap(arr, i, depth);
			if (sum==WANT) {
				ispossible=true;
				return;
			}
			perm(arr, depth + 1);
			if(ispossible) return;
			swap(arr, i, depth); 
		}
	}
	public static void swap(int[][] arr, int i, int j) {
		sum-=arr[i][i];
		sum-=arr[j][j];
		int[] temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		sum+=arr[i][i];
		sum+=arr[j][j];
	}
}

