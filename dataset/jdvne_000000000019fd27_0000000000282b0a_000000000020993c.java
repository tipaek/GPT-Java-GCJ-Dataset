import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int caseCount = scan.nextInt();
		
		for(int i = 1; i <= caseCount; i++) {
			int trace = 0;

			int row_repeats = 0;
			int col_repeats = 0;
			
			int n = scan.nextInt();
			
			ArrayList<HashSet<Integer>> rows = new ArrayList<HashSet<Integer>>();
			ArrayList<HashSet<Integer>> cols = new ArrayList<HashSet<Integer>>();
			for(int j =0; j < n; j++) {
				rows.add(new HashSet<Integer>());
				cols.add(new HashSet<Integer>());
			}
						
			for(int j = 0; j < n; j++) {				
				for(int k = 0; k < n; k++) {
					int x = scan.nextInt();
					rows.get(j).add(x); 
					cols.get(k).add(x);
					
					if(j == k) { trace += x; }
				}
				scan.nextLine();
			}
			
			for(HashSet<Integer> row : rows) {
				if (row.size() != n) row_repeats++;
			}
			
			for(HashSet<Integer> col : cols) {
				if (col.size() != n) col_repeats++;
			}
			
			System.out.println("Case #" + i + ": " + trace + " " + row_repeats + " " + col_repeats);
		}
	}
}
