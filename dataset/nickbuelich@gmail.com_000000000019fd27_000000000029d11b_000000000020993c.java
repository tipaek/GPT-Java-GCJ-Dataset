import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			long trace = 0;
			HashSet<Integer> COL[] = new HashSet[N];
			HashSet<Integer> ROW[] = new HashSet[N];
			for(int a=0;a<N;a++){
				COL[a] = new HashSet<Integer>();
				ROW[a] = new HashSet<Integer>();
			}
			for(int a=0;a<N;a++){
				for(int b=0;b<N;b++){
					int cur = sc.nextInt();
					COL[b].add(cur);
					ROW[a].add(cur);
					if(a==b)trace+=cur;
				}
			}
			int badRow=0,badCol=0;
			for(int a=0;a<N;a++){
				if(COL[a].size()!=N)badCol++;
				if(ROW[a].size()!=N)badRow++;
			}
			System.out.printf("Case #%d: %d %d %d%n", t, trace, badRow, badCol);
		}
	}
}
