import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static int getTrace(int[][] M){
		int trace = 0;
		for(int i = 0 ; i < M.length ; ++i){
			trace += M[i][i];
		}
		return trace;
	}
	static int calcRepeatedRowNumber(int[][] M){
		int repeated = 0;
		for(int i = 0 ; i < M.length ; ++i){
			Set<Integer> seen = new HashSet<Integer>();
			for(int j = 0 ; j < M.length ; ++j){
				int m = M[i][j];
				if(seen.contains(m)){
					repeated++;
					break;
				}
				seen.add(m);
			}
		}
		return repeated;
	}
	static int calcRepeatedColumnNumber(int[][] M){
		int repeated = 0;
		for(int i = 0 ; i < M.length ; ++i){
			Set<Integer> seen = new HashSet<Integer>();
			for(int j = 0 ; j < M.length ; ++j){
				int m = M[j][i];
				if(seen.contains(m)){
					repeated++;
					break;
				}
				seen.add(m);
			}
		}
		return repeated;
	}

	static void solve(int[][] M ,int case_no){
		System.out.printf("Case #%d: %d %d %d\n" , case_no , getTrace(M) , calcRepeatedRowNumber(M) , calcRepeatedColumnNumber(M));	
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; ++t){
			int N = sc.nextInt();
			int M[][] = new int[N][N];
			for(int i = 0 ; i < N ; ++i){
				for(int j = 0 ; j < N ; ++j){
					M[i][j] = sc.nextInt();
				}
			}
			solve(M, t);
		}
	}
}
