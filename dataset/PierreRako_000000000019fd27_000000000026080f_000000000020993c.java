import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args){
		//System.out.println("in main");
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		//System.out.println("stdin opened");
		int t = in.nextInt();
		//System.out.println("T read");
		for (int caseTest = 1 ; caseTest <= t ; caseTest++) 
		{
			int N = in.nextInt();
			ArrayList<Integer> matrix = new ArrayList<Integer>(N*N);
			for (int i = 0; i<N*N; i++) {
				matrix.add(i, in.nextInt());
			}
			ArrayList<Integer> solution = compute(matrix,N);
			System.out.println( "Case #" + t + ": " + solution.get(0)+ " " + solution.get(1) + " " + solution.get(2));
		}
		
	}

	private static ArrayList<Integer> compute(ArrayList<Integer> matrix, int n) {
		ArrayList<Integer> solution = new ArrayList<Integer>(3);
		ArrayList<Integer> currentLine = new ArrayList<Integer>(n);
		int k = 0;
		int r = 0;
		int c = 0;
		int i = 0;
		ArrayList<Boolean> foundInRows = new ArrayList<Boolean>(n);
		for (int count = 0 ; count < n ; count++) foundInRows.add(false);
		boolean foundInLine = false;
		while (i<n*n) {
			int column = i%n;
			int line = i/n;
			if (line == column) k += matrix.get(i);
			if (column == 0) {
				foundInLine = false;
				currentLine = new ArrayList<Integer>(n);
				currentLine.add(matrix.get(i));
				if (!foundInRows.get(column)) {
					foundInRows.set(column, isInRow(matrix.get(i), column, line, matrix, n));
					if (foundInRows.get(column)) c++;
				}
			}
			
			else {
				currentLine.add(matrix.get(i));
				if (!foundInLine) {
					foundInLine = currentLine.contains(matrix.get(i));
					if (foundInLine) r++;
				}
				if (!foundInRows.get(column)) {
					foundInRows.set(column, isInRow(matrix.get(i), column, line, matrix, n));
					if (foundInRows.get(column)) c++;
				}
			}
			i++;
		}
		solution.add(k);
		solution.add(r);
		solution.add(c);
		return solution;
	}
	
	private static boolean isInRow(int e, int j, int i, ArrayList<Integer> matrix, int size) {
		boolean found = false;
		for (int k = 0; k<i; k++)
		{
			found = (matrix.get(size*k + j) == e);
		}
		return found;
	}

	
}
