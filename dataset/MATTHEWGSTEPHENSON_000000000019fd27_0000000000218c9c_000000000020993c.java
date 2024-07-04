import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int testsSets;
		int currentCase = 0;
		testsSets = scan.nextInt();
		
		
		while(testsSets > currentCase) {
			int n = scan.nextInt();
			int diag = 0;
			int rowTotal = 0;
			int colTotal = 0;
			boolean colFlags[] = new boolean[n];
			
			for(int count = 0; count < n; count++) {
				colFlags[count] = false;
			}
			
			ArrayList<HashSet<Integer>> col = new ArrayList<HashSet<Integer>>();
			
			for(int i = 0; i < n; i++) {
				boolean rowFlag = false;
								
				HashSet<Integer> row = new HashSet<Integer>();
				for(int j = 0; j < n; j++) {
					int current = scan.nextInt();
					if(row.contains(current) && !rowFlag) {
						rowFlag = true;
						rowTotal++;
					}
					row.add(current);
					if(i == j) {
						diag += current;
					}
					
					if(col.size() <= j) {
						col.add(new HashSet<Integer>());
					}
					
					if(col.get(j).contains(current) && !colFlags[j]) {
						colFlags[j] = true;
						colTotal++;
					}
					col.get(j).add(current);
					
				}
			}
			System.out.printf("Case #%d: %d %d %d\n", currentCase + 1, diag, rowTotal, colTotal);
			currentCase++;
		}
	}

}
