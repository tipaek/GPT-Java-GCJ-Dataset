import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	int N;
	int[][] M;
	int trace;
	int ncols;
	int nrows;

	private void readTest() {
		N = scanner.nextInt();
		M = new int[N][N];
		for (int i = 0; i < N ; i++)
			for(int j=0;j<N;j++)
				M[i][j] = scanner.nextInt();
	}


	private void calculate() {
		trace=0;
		for(int i=0;i<N;i++)
			trace+=M[i][i];

		nrows=0;
		for(int i=0;i<N;i++) {
			int[] rows=new int[N+1];
			int addrow=0;
			for(int j=0;j<N;j++) {
				if (rows[M[i][j]]==0)
					rows[M[i][j]]=1;
				else
					addrow=1;
			}
			nrows+=addrow;
		}

		ncols=0;
		for(int i=0;i<N;i++) {
			int[] cols=new int[N+1];
			int addcol=0;
			for(int j=0;j<N;j++) {
				if (cols[M[j][i]]==0)
					cols[M[j][i]]=1;
				else
					addcol=1;
			}
			ncols+=addcol;
		}
				
	}

	private void printResult(int i) {
		StringBuilder sb = new StringBuilder();
		sb.append("Case #" + i + ": ");
		sb.append(trace+" "+nrows+" "+ncols);
		System.out.println(sb.toString());
		
	}

	public static void main(String[] args) {
		new Solution().run();
	}

	public void run() {
		int T = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 1; i <= T; i++) {
			readTest();
			calculate();
			printResult(i);
		}
	}

}
