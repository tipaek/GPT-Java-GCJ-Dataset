import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			int R = in.nextInt();
			int S = in.nextInt();
			int RS = R * S;
			PairInt[] arr = new PairInt[RS];
			PairInt[] swap1 = new PairInt[RS];
			PairInt[] swap2 = new PairInt[RS];
			for (int s = 0; s < S; s++) {
				for (int r = 0; r < R; r++) {
					arr[s * R + r] = new PairInt(r, s);
				}
			}
			List<PairInt> steps = new ArrayList<>();
			for (int nextToSortRank = R - 1;;) {
//				System.err.println(Arrays.toString(arr));
				int iLastNonSortRank = RS - 1;
				while (arr[iLastNonSortRank].a >= nextToSortRank) {
					iLastNonSortRank--;
				}
				int iNextLastSortRank = iLastNonSortRank - 1;
				while (iNextLastSortRank >= 0 && arr[iNextLastSortRank].a != nextToSortRank) {
					iNextLastSortRank--;
				}
				if (iNextLastSortRank < 0) {
					nextToSortRank--;
					if (nextToSortRank == 0) {
						break;
					} else {
						continue;
					}
				}
				int a = iNextLastSortRank + 1;
				int b = iLastNonSortRank + 1 - a;
				System.arraycopy(arr, 0, swap1, 0, a);
				System.arraycopy(arr, a, swap2, 0, b);
				System.arraycopy(swap1, 0, arr, b, a);
				System.arraycopy(swap2, 0, arr, 0, b);
				steps.add(new PairInt(a, b));
//				System.err.println(">" + a + " " + b + " <- found non " + nextToSortRank + " at " + iLastNonSortRank + " found " + nextToSortRank + " at " + iNextLastSortRank);
			}
			System.out.println("CASE #" + (t + 1) + ": " + steps.size());
			for (PairInt step : steps) {
				System.out.println(step.a + " " + step.b);
			}
		}
	}
	public static class PairInt {
		public int a;
		public int b;
		public PairInt(int init) {
			this(init, init);
		}
		public PairInt(int a, int b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public String toString() {
			return "(" + a + "," + b + ")";
		}
	}
}
