import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int[][] m = new int[N][4];
			for (int j = 0; j < N; j++) {
				for (int h = 0; h < 2; h++) {
					m[j][h] = sc.nextInt();
				}
				m[j][2]=j;
				m[j][3]=-1;

			}
			sortByStart(m, N); 
			int endJ = -1; 
			int endC = -1;
			for(int j=0; j<N; j++) {
				int s = m[j][0];
				int e = m[j][1]; 
				if(endC <= s) { 
					m[j][3]='C';
					endC=e;
				} else if(endJ <=s) {
					m[j][3]='J';
					endJ=e;
				} else { 
					break;
				}
			}
			sortBack(m, N);
			String ret = "";
			for(int j=0; j<N; j++) { 
				int x = m[j][3];
				if(x<0) {
					ret="IMPOSSIBLE";
					break;
				}
				ret +=(char) x;
			}
			System.out.println("Case #" + i + ": "+ret);
		}
	}

	private static void sortBack(int[][] m, int N) {
		for(int i =0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(m[i][2]>m[j][2]) {
					int[] tmp = m[i] ;
					m[i] =m[j] ;
					m[j] =tmp;
				}
			}
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
