import java.util.HashSet;
import java.util.Scanner;

public class Solution{

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for(int t=0;t<test;t++) {
			int n = scn.nextInt();
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = scn.nextInt();
				}
			}
			int countr = 0, countc = 0;
			A: for (int i = 0; i < n; i++) {
				HashSet<Integer> st = new HashSet<>();
				for (int j = 0; j < n; j++) {
					if (st.contains(arr[i][j])) {
						countr++;
						continue A;
					} else {
						st.add(arr[i][j]);
					}
				}
			}
			for (int c = 0; c < n; c++) {
				HashSet<Integer> st = new HashSet<>();
				for (int i = 0; i < n; i++) {
					if (st.contains(arr[i][c])) {
						countc++;
					} else {
						st.add(arr[i][c]);
					}
				}

				
			}
			int v=0;
			for(int i=0;i<n;i++){
				v+=arr[i][i];
			}
			System.out.println("Case #"+(t+1)+": "+v+" "+countr+" "+countc);
		}
	}

}
