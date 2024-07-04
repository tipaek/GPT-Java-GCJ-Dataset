import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class CodeJ {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int n = in.nextInt();
			ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
			
			int r = 0, c = 0, trace = 0;
			
			for (int j = 0; j < n; ++j) {
				matrix.add(new ArrayList<>());
				HashSet<Integer> set = new HashSet<>();
				boolean rowDone = false;
				for (int k = 0; k < n; ++k) {
					matrix.get(j).add(in.nextInt());
					if (!rowDone && !set.add(matrix.get(j).get(k))) {
						++r;
						rowDone = true;
					}
				}
			}
			
			for (int j = 0; j < n; ++j) {
				HashSet<Integer> set = new HashSet<>();
				boolean colDone = false;
				
				for (int k = 0; k < n; ++k) {
					if (!colDone && !set.add(matrix.get(k).get(j))) {
						++c;
						colDone = true;
					}
				}
			}
			
			for (int j = 0; j < n; ++j) {
				trace += matrix.get(j).get(j);
			}
			
			System.out.printf("Case #%d: %d %d %d\n", i + 1, trace, r, c);
		}
	}
}
