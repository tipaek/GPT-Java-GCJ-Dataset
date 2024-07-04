import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();

		for (int i = 0; i < t; ++i) {
			int r = in.nextInt(), s = in.nextInt();
			ArrayList<ArrayList<Integer>> moves = new ArrayList<ArrayList<Integer>>();
			
			while (r > 1) {
				int lower = 0;
				while (lower < s - 1) {
					moves.add(new ArrayList<>());
					moves.get(moves.size() - 1).add(r * (s - 1) - lower);
					moves.get(moves.size() - 1).add(r - 1);
					lower++;
				}
				r--;
			}
			System.out.println("Case #" + (i + 1) + ": " + moves.size());
			for (ArrayList<Integer> ab : moves) {
				System.out.println(ab.get(0) + " " + ab.get(1));
			}
		}
	}
}