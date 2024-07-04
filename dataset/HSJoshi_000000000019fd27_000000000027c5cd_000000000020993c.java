import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	private static final Scanner scanner = new Scanner(System.in);

	static Map<Integer,Set<Integer>> rows = new HashMap<Integer,Set<Integer>>();
	static Map<Integer,Set<Integer>> cols = new HashMap<Integer,Set<Integer>>();

	public static void main(String[] args) throws IOException {
		int t = scanner.nextInt();
		for (int qItr = 0; qItr < t; qItr++) {
			int n = scanner.nextInt();
			
			rows.clear();
			cols.clear();
			
			int k = 0, r = 0, c = 0;
			int []rowArr = new int[n];
			int []colArr = new int[n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int val = scanner.nextInt();
					if (rowArr[i] != 1 && rows.get(i) != null && rows.get(i).contains(val)) {
						r++;
						rowArr[i] = 1;
					}
					if(colArr[j] != 1 && cols.get(j) != null && cols.get(j).contains(val)) {
						c++;
						colArr[j] = 1;
					}
					if(i == j)
						k+=val;
					
					Set<Integer> rowSet;
					Set<Integer> colSet;
					
					if(rows.get(i) == null)
						rowSet = new HashSet<Integer>();
					else
						rowSet = rows.get(i);
					
					if(cols.get(j) == null)
						colSet = new HashSet<Integer>();
					else
						colSet = cols.get(j);
					
					rowSet.add(val);
					colSet.add(val);
					
					rows.put(i,rowSet);
					cols.put(j,colSet);
				}
			}

			System.out.println("Case #" + (qItr + 1) + ": " + k + " " + r + " " + c);
		}

		scanner.close();
	}

}
