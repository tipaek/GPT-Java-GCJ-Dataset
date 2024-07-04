import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	/** 
	 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051706/0000000000122838
	 */

	public static void main(String[] args){
		// beforeClass();
		try(Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))){
			int t = Integer.parseInt(in.nextLine());			
			int rowCount;
			int traceValue = 0;
			
			// Dataset
		    for (int i = 1; i <= t; ++i) {
				rowCount = Integer.parseInt(in.nextLine());
				
				Set<Integer> rowDupes = new HashSet<>();
				Set<Integer> colDupes = new HashSet<>();

				Map<Integer, Set<Integer>> colValues = new HashMap<>();

				int[][] square = new int[rowCount][rowCount];

				// Row iterator
				for (int row = 0; row < rowCount; row++) {
					Set<Integer> rowValues = new HashSet<>();

					square[row] = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

					traceValue += square[row][row];

					// Value iterator
					for (int x = 0; x < square[row].length; x++) {
						if (rowValues.contains(square[row][x])) {
							rowDupes.add(row);
						}
						rowValues.add(square[row][x]);

						if (colValues.containsKey(x)) {
							if (colValues.get(x).contains(square[row][x])) {
								colDupes.add(x);
							}
						} else {
							colValues.put(x, new HashSet<>());
						} 
						colValues.get(x).add(square[row][x]);
					}
				}				

				System.out.println("Case #" + i + ": " + traceValue + " " + rowDupes.size() + " " + colDupes.size());
				traceValue = 0;
		    }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * only for testing
	 */
	private static void beforeClass(){
		try {
			System.setIn(new FileInputStream("D:/workspace/java/sample.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
