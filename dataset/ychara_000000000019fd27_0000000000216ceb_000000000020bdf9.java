import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int[][] m = new int[N][2];
			for (int j = 0; j < N; j++) {
				for (int h = 0; h < 2; h++) {
					m[j][h] = sc.nextInt();
				}

			}
			sortByStart(m, N);
			String ret ="";
			int endJ = -1; 
			int endC = -1;
			for(int j=0; j<N; j++) {
				int s = m[j][0];
				int e = m[j][1];
				//System.out.println(">>> "+s+", "+e+"    endJ="+endJ+" endC="+endC);
				if(endJ <= s) {
					ret += "J";
					endJ=e;
				} else if(endC <=s) {
					ret+= "C";
					endC=e;
				} else {
					ret= "IMPOSSIBLE";
					break;
				}
			}

			System.out.println("Case #" + i + ": "+ret);
		}
	}

	private static void sortByStart(int[][] m, int N) {
		for(int i =0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(m[i][0]>m[j][0]) {
					int[] tmp = m[i] ;
					m[i] =m[j] ;
					m[j] =tmp;
				}
			}
		}

	}
}
