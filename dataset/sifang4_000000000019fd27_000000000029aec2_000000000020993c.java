import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws IOException {
	    //System.out.println(6);
	    //System.setIn(new FileInputStream("C:\\0Data\\Eclipse Java Data\\Leetcode Java\\src\\GoogleCodeJam\\case1.txt"));
	    // C:\\0Data\\Eclipse Java Data\\Leetcode Java\\src\\GoogleCodeJam\\case1.txt
	    // String intputFile = "C:\\0Data\\Eclipse Java Data\\Leetcode Java\\src\\LyftAutoCompleteWord\\wordsInput.txt";
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		///System.out.println("t: " + t);
		for (int ii = 1; ii <= 3; ++ii) {
			int n = in.nextInt();
			//System.out.println("n: " + n);
			//System.out.println(15);
			int[][] A = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					A[i][j] = in.nextInt();
				}
			}
            //System.out.println(22);
			int k = 0;
			for (int i = 0; i < n; i++) {
				k += A[i][i];
			}
			int r = 0;
			for (int i = 0; i < n; i++) {
				Set<Integer> set = new HashSet<>();
				for (int j = 0; j < n; j++) {
					if (!set.add(A[i][j])) {
						r++;
						break;
					}
				}
			}

			int c = 0;
			for (int j = 0; j < n; j++) {
				Set<Integer> set = new HashSet<>();
				for (int i = 0; i < n; i++) {
					if (!set.add(A[i][j])) {
						c++;
						break;
					}
				}
			}
			System.out.println("Case #" + ii + ": " + k + " " + r + " " + c);
		}
        in.close();
	}

}