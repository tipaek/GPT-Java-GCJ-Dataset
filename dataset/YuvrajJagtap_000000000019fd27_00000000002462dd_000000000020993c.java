import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



public class Solution {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int numberOfTestCases = Integer.parseInt(s);
		int size;
		String numberLine;
		Integer[][] elementArray;
		String[] elements;
		Map<Integer, Integer[][]> noOfItems = new HashMap<Integer, Integer[][]>();
		for (int i = 0 ; i < numberOfTestCases ; i++) {
			size = Integer.parseInt(in.nextLine());
			elementArray = new Integer[size][size];
			for (int j = 0; j < size ; j++) {
				numberLine = in.nextLine();
				elements = numberLine.split(" ");
				for (int k =0 ; k < elements.length ; k++) {
					elementArray[j][k] = Integer.parseInt(elements[k]);
				}
			}
			noOfItems.put(i, elementArray);
		}
		Set<Integer> rowSet,colSet;
		int repeatedRows = 0;
		int repeatedCols = 0;
		int trace = 0;
		Integer[][] input;
		boolean notALatinSquare = false;
		for (Integer key : noOfItems.keySet()) {
			input = noOfItems.get(key);
			repeatedRows = 0;
			repeatedCols = 0;
			trace = 0;
			notALatinSquare = false;
			for (int i = 0 ; i < input.length ; i++) {
				rowSet = new HashSet<Integer>();
				colSet = new HashSet<Integer>();
				trace = trace + input[i][i];
				for (int j = 0 ; j < input.length ; j++) {
					rowSet.add(input[i][j]);
					colSet.add(input[j][i]);
					if (input[i][j] > input.length || (input[i][j] <= 0)) {
						notALatinSquare = true;
					}
				}
				if (rowSet.size() < input.length) {
					repeatedRows = repeatedRows + 1;
				}
				if (colSet.size() < input.length) {
					repeatedCols = repeatedCols + 1;
				}
			}
			if (!notALatinSquare) {
				System.out.println("Case #" + (key + 1) + ": " + trace + " " + repeatedRows + " " + repeatedCols);
			}
		}
	}
	
}
