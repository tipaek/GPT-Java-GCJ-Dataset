import java.util.*;
		public class Solution {
				public static void main (String [] arg) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		long [][] P = new long [501][501];
		P[1][1] = 1;
		P[2][1] = 1;
		P[2][2] = 1;
		for (int i = 3; i < P.length; ++i)
			for (int j = 1; j<=i; ++j)
				P[i][j] = P[i-1][j-1] + P[i-1][j];


		for (int ii = 1; ii<=T; ++ii) {
			ArrayList<Pair> ans = new ArrayList<Pair>(500);
			ans.add(new Pair(1,1));
			int total = 1;
			//int step = 1;
			int N = sc.nextInt();
			int posr = 1;
			int posc = 0;

			while (total + P[posr+1][posc+1] <= N) {
				posr++;
				posc++;
				ans.add(new Pair(posr, posc));
				total+=P[posr][posc];
			}
			if (total < N) {
				posc++;
				total+=1;
				ans.add(new Pair(posr, posc));
				while (total < N) {
					posr++;
					posc++;
					total++;
					ans.add(new Pair(posr, posc));
				}
			}
			StringBuilder ans2 = new StringBuilder(ans.size() * 7);
			for (Pair p : ans) {
					ans2 = ans2.append(p.i);
					ans2 = ans2.append(' ');
					ans2 = ans2.append(p.j);
					ans2 = ans2.append("\n");
			}
			System.out.printf("Case #%d:\n%s",ii,ans2.toString());
		}
	}
	static class Pair implements Comparable<Pair> {
		int i,j;long L; public Pair(int xx, int yy){i=xx;j=yy;}
		public int compareTo(Pair p) { return (this.L < p.L) ? -1 : (this.L == p.L) ? this.i - p.i : 1;}
	}

}
