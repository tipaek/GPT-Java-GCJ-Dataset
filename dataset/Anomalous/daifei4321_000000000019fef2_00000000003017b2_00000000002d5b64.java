import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		
		for (int t = 0; t < testCases; t++) {
			int rows = scanner.nextInt();
			int columns = scanner.nextInt();
			int totalPairs = rows * columns;
			
			PairInt[] pairs = new PairInt[totalPairs];
			PairInt[] tempSwap1 = new PairInt[totalPairs];
			PairInt[] tempSwap2 = new PairInt[totalPairs];
			
			for (int col = 0; col < columns; col++) {
				for (int row = 0; row < rows; row++) {
					pairs[col * rows + row] = new PairInt(row, col);
				}
			}
			
			List<PairInt> steps = new ArrayList<>();
			int nextRankToSort = rows - 1;
			
			while (true) {
				int lastNonSortedIndex = totalPairs - 1;
				
				while (pairs[lastNonSortedIndex].a >= nextRankToSort) {
					lastNonSortedIndex--;
				}
				
				int nextLastSortedIndex = lastNonSortedIndex - 1;
				
				while (nextLastSortedIndex >= 0 && pairs[nextLastSortedIndex].a != nextRankToSort) {
					nextLastSortedIndex--;
				}
				
				if (nextLastSortedIndex < 0) {
					nextRankToSort--;
					if (nextRankToSort == 0) {
						break;
					} else {
						continue;
					}
				}
				
				int a = nextLastSortedIndex + 1;
				int b = lastNonSortedIndex + 1 - a;
				
				System.arraycopy(pairs, 0, tempSwap1, 0, a);
				System.arraycopy(pairs, a, tempSwap2, 0, b);
				System.arraycopy(tempSwap1, 0, pairs, b, a);
				System.arraycopy(tempSwap2, 0, pairs, 0, b);
				
				steps.add(new PairInt(a, b));
			}
			
			System.out.println("CASE #" + (t + 1) + ": " + steps.size());
			for (PairInt step : steps) {
				System.out.println(step.a + " " + step.b);
			}
		}
		scanner.close();
	}
	
	public static class PairInt {
		public int a;
		public int b;
		
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