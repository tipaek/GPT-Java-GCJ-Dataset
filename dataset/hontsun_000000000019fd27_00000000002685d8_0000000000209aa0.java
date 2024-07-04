
import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int N,K;
	static int[][] M,arr;
	static int[] tra;
	static boolean can;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = in.nextInt();
		for(int test=1;test<=tests;test++) {
			N = in.nextInt();
			K = in.nextInt();
			M = new int[N][N];
			arr = new int[2*N][N+1];
			tra = new int[N];
			can = false;
			mTra(0);
			if(can) {
				System.out.printf("Case #%d: %s\n",test,"POSSIBLE");
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						System.out.printf("%d%c",M[i][j],j+1==N?'\n':' ');
					}
				}
			}else {
				System.out.printf("Case #%d: %s\n",test,"IMPOSSIBLE");
			}
		}
	}
	static void mTra(int j) {
		if(j==N) {
			return;
		}
		if(j==N-1) {
			tra[j] = K;
			mTra(j+1);
			return;
		}
		for(int i=Math.max(1, K-(N-j-1)*N);i<=Math.min(K-(N-j-1),N);i++) {
			tra[j] = i;
			K -= i;
			mTra(j+1);
			init();
			if(dfs(0,0)) {
				can = true;
				return;
			}
			K += i;
		}
		return;
	}
	static void init() {
		for(int i=0;i<N;i++) {
			arr[i][tra[i]]--;
			arr[N+i][tra[i]]--;
			M[i][i] = tra[i];
		}
	}
	static boolean dfs(int i,int j) {
		if(j==N) {
			return dfs(i+1,0);
		}
		if(i==N) {
			return true;
		}
		if(M[i][j]!=0) {
			return dfs(i,j+1);
		}
		LinkedList<Integer> could = new LinkedList<>();
		for(int k=1;k<=N;k++) {
			if(arr[i][k]==0&&arr[N+j][k]==0) could.add(k);
		}
		if (could.size()==0) {
			return false;
		}
		for(int k=0;k<could.size();k++) {
			M[i][j] = could.get(k);
			arr[i][could.get(k)]--;
			arr[N+j][could.get(k)]--;
			if(dfs(i,j+1)) {
				return true;
			}else {
				M[i][j] = 0;
				arr[i][could.get(k)]++;
				arr[N+j][could.get(k)]++;
			}
		}
		return false;
	}

}
