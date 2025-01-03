import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
	int counter = s.nextInt();
	for (int count = 0; count < counter; count++) {
		int t = s.nextInt();
		int repeatedCol = 0;
		int repeatedRow = 0;
		int[][] matrix = new int[t][t];
		List tempCol = new ArrayList();
		List tempRow = new ArrayList();
		int sum = 0;
		for (int i = 0; i <= t; i++) {
			String row = s.nextLine();
			row = row.replaceAll(" ", "");
			int n = row.length();
			if (n > 0) {
				for (int j = 0; j < n; j++) {
					char ss = row.charAt(j);
					int value = Integer.parseInt(String.valueOf(ss));
					matrix[i - 1][j] = value;
					if (j + 1 == i) {
						sum += value;
					}
					for (int rr = 0; rr < n; rr++) {

						if (rr != j && ss == row.charAt(rr)) {
							tempRow.add(ss);
						}
					}
				}
				if (tempRow.size() > 0) {
					repeatedRow++;
					tempRow = new ArrayList();
				}
			}
		}
		String cols = "";
		for (int rr = 0; rr < matrix.length; rr++) {
			for (int rc = 0; rc < matrix.length; rc++) {
				cols += matrix[rc][rr];
			}
			for (int jj = 0; jj < cols.length(); jj++) {
				char sst = cols.charAt(jj);
				for (int c = 0; c < cols.length(); c++) {
					if (c != jj && sst == cols.charAt(c)) {
						tempCol.add(sst);
					}
				}
			}
			if (tempCol.size() > 0) {
				repeatedCol++;
				tempCol = new ArrayList();
			}
			cols = "";
		}
		int k=count+1;
		System.out.println("Case #" + k + ": " + sum + " " + repeatedRow + " " + repeatedCol);
	}
       }
    }