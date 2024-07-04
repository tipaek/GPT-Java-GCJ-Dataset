package GoogleCodeJam;

import java.util.*;
import java.io.*;
import java.io.FileInputStream;

class Solution {
	public static void main(String[] args) throws IOException {
	    //System.out.println("hello");
	    System.setIn(new FileInputStream("C:\\0Data\\Eclipse Java Data\\Leetcode Java\\src\\GoogleCodeJam\\q3case1.txt"));
	    
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		
		
		
		for (int ii = 1; ii <= t; ++ii) {
			int n = in.nextInt();
			int[][] A = new int[n][4];
			for (int i = 0; i < n; i++) {
				A[i][0] = in.nextInt(); // start
				A[i][1] = in.nextInt(); // end
				A[i][3] = i;
			}
		
			Arrays.sort(A, (a, b) -> a[0] - b[0]);
			//System.out.println("A: " + Arrays.deepToString(A));
			int c = -1, j = -1;
			int min = -1, max = -1;
			char minC = 'C', maxC = 'J';
			StringBuilder sb = new StringBuilder();
			for (int[] a : A) {
				if (c < j) {
					min = c;
					max = j;
					minC = 'C';
					maxC = 'J';
				} else {
					min = c;
					max = j;
					minC = 'C';
					maxC = 'J';
				}
				//System.out.println("c: " + c + " j: " + j + "minC: " + minC + "maxC: " + maxC);
				if (a[0] >= max) {
					if (maxC == 'C') {
						sb.append('C');
						a[2] = 0;
						c = a[1];
					} else {
						sb.append('J');
						a[2] = 1;
						j = a[1];
					}
				} else if (a[0] >= min) {
					if (minC == 'C') {
						sb.append('C');
						a[2] = 0;
						c = a[1];
					} else {
						sb.append('J');
						a[2] = 1;
						j = a[1];
					}
				} else {
					sb = new StringBuilder();
					sb.append("IMPOSSIBLE");
					break;
				}
			}
			
			
			if (!sb.toString().equals("IMPOSSIBLE")) {
				
				sb = new StringBuilder();
				Arrays.sort(A, (a, b) -> a[3] - b[3]);
				//System.out.println("A: " + Arrays.deepToString(A));
				for (int[] a : A) {
					if (a[2] == 0) {
						sb.append('C');
					} else {
						sb.append('J');
					}
				}
			}
			
			System.out.println("Case #" + ii + ": " + sb.toString());
		}
        in.close();
	}

}


/*
A: [[1, 100, 1], [2, 5, 3], [99, 150, 0], [100, 301, 2], [150, 250, 4]]

301  250

A: [[1, 100, 1], [2, 5, 3], [99, 150, 0], [100, 301, 2], [150, 250, 4]]
c: -1 j: -1minC: CmaxC: J
c: -1 j: 100minC: CmaxC: J
c: 5 j: 100minC: CmaxC: J
c: 150 j: 100minC: CmaxC: J
c: 150 j: 301minC: CmaxC: J
Case #1: JCCJC


*/