import java.util.*;

public class Solution {//Code Jam quals 2020, Vestigium
	Scanner sc;
	public void computeAll(int N, int[][] M) {
	  int res=0;
	  for (int i=0; i<N; i++) res=res+M[i][i];
	  System.out.print(res+" ");
	  res=0;
	  for (int i=0; i<N; i++) {
		  HashSet<Integer> intList = new HashSet<>();
		  for (int j=0; j<N; j++) intList.add(M[i][j]);
		  if (intList.size()<N) res++;
	  }
	  System.out.print(res+" ");
	  res=0;
	  for (int i=0; i<N; i++) {
		  HashSet<Integer> intList = new HashSet<>();
		  for (int j=0; j<N; j++) intList.add(M[j][i]);
		  if (intList.size()<N) res++;
	  }
	  System.out.println(res);
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.sc = new Scanner(System.in);
		int T=sol.sc.nextInt();
		sol.sc.nextLine();
		for (int t=1; t<=T; t++) {
			int N=sol.sc.nextInt();
			sol.sc.nextLine();
			int[][] M = new int[N][N];
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) M[i][j]=sol.sc.nextInt();
				sol.sc.nextLine();
			}
			System.out.print("Case #"+t+": ");
			sol.computeAll(N,M);
		}
		
		 
	}
}
