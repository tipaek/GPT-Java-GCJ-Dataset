import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int a = 1; a <= T; a++) {
			System.out.print("Case #" + a + ": ");
			int N = Integer.parseInt(in.readLine());
			int[][] temp = new int[N][N];
			for (int b = 0; b < N; b++) {
				StringTokenizer token = new StringTokenizer(in.readLine());
				for (int c = 0; c < N; c++)
					temp[b][c] = Integer.parseInt(token.nextToken());
			}
			HashSet<Integer>[] set = new HashSet[N];
			for (int b = 0; b < N; b++)
				set[b] = new HashSet<Integer>(N);
			int rans = 0;
			for (int b = 0; b < N; b++) {
				for (int c = 0; c < N; c++)
					set[b].add(temp[b][c]);
				if (set[b].size() != N)
					rans++;
			}
			set = new HashSet[N];
			for (int b = 0; b < N; b++)
				set[b] = new HashSet<Integer>(N);
			int cans = 0;
			for (int b = 0; b < N; b++) {
				for (int c = 0; c < N; c++)
					set[b].add(temp[c][b]);
				if (set[b].size() != N)
					cans++;
			}
			int sum = 0;
			for (int b = 0; b < N; b++)
				sum += temp[b][b];
			System.out.println(sum + " " + rans + " " + cans);
		}
	}
}