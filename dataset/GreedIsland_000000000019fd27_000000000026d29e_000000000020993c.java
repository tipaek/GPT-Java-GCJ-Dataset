import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int k = 0;
			int c = 0;
			int r = 0;
			int N = sc.nextInt();
			HashSet[] rowSets = new HashSet[N];
			HashSet[] columnSets = new HashSet[N];
			for(int j = 0; j < N; j++) {
				rowSets[j] = new HashSet<Integer>();
			}
			for(int j = 0; j < N; j++) {
				columnSets[j] = new HashSet<Integer>();
			}
			for(int j = 0; j < N; j++) {
				for(int w = 0; w < N; w++) {
					int val = sc.nextInt();
					rowSets[j].add(val);
					columnSets[w].add(val);
					if(j == w) {
						k += val;
					}
				}
			}
			for(int j = 0; j < N; j++) {
				if(rowSets[j].size() < N)
					r += 1;
			}
			for(int j = 0; j < N; j++) {
				if(columnSets[j].size() < N)
					c += 1;
			}
			System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
		}

	}

}
