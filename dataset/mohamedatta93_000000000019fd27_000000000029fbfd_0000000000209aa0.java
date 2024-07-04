
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	 static public List<List<Integer>> generatePerm(List<Integer> original) {
	     if (original.isEmpty()) {
	       List<List<Integer>> result = new ArrayList<>(); 
	       result.add(new ArrayList<>()); 
	       return result; 
	     }
	     Integer firstElement = original.remove(0);
	     List<List<Integer>> returnValue = new ArrayList<>();
	     List<List<Integer>> permutations = generatePerm(original);
	     for (List<Integer> smallerPermutated : permutations) {
	       for (int index=0; index <= smallerPermutated.size(); index++) {
	         List<Integer> temp = new ArrayList<>(smallerPermutated);
	         temp.add(index, firstElement);
	         returnValue.add(temp);
	       }
	     }
	     return returnValue;
	   }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			List<Integer> uniqueNumbers = new ArrayList<Integer>();
			for (int j = 1; j <=n; j++) {
				uniqueNumbers.add(j);
			}
			int key = in.nextInt();
			int[][] matrix = new int[n][n];
			Random random = new Random();
			boolean found = false;
			List<Set<Integer>> rowsNumbers = new ArrayList<Set<Integer>>();
			List<Set<Integer>> columnsNumbers = new ArrayList<Set<Integer>>();
			for (int j = 0; j < n; j++)
				rowsNumbers.add(new HashSet<Integer>());
			for (int j = 0; j < n; j++)
				columnsNumbers.add(new HashSet<Integer>());

			List<List<Integer>> allPossibles = generatePerm(uniqueNumbers);
			for (int trySol = 0; trySol < allPossibles.size(); trySol++) {
				uniqueNumbers = allPossibles.get(trySol);
				
				for (int j = 0; j < n; j++)
					rowsNumbers.get(j).clear();
				for (int j = 0; j < n; j++)
					columnsNumbers.get(j).clear();
				
				
				int sum = 0;
				for (int j = 0; j < n; j++)
					for (int k = 0; k < n; k++) {
						matrix[j][k] = uniqueNumbers.get((k+j)%n);
						rowsNumbers.get(j).add(matrix[j][k]);
						columnsNumbers.get(k).add(matrix[j][k]);
						if (k == j)
							sum += matrix[j][k];
					}
				int nRows = 0;
				int nColumns = 0;
				for (int j = 0; j < n; j++) {
					if (rowsNumbers.get(j).size() != n)
						nRows++;
					if (columnsNumbers.get(j).size() != n)
						nColumns++;

				}
				if(sum==key&&nRows==0&&nColumns==0) {
				System.out.println("Case #" + i + ": POSSIBLE");
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						System.out.print(matrix[j][k]+" ");
					}
					System.out.println();}
				found = true;
				break;
				}
				
						
			}
			if(found==false)
				System.out.println("Case #" + i + ": IMPOSSIBLE");
		}
	}

}
