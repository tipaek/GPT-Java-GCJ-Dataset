import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

public class Solution {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
				PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
			for (int testCases = in.nextInt(), testCase = 1; testCase <= testCases; testCase++) {
			    List<int[]> ans = solve(in.nextInt());
				out.println("Case #" + testCase + ":");
				for (int[] a : ans) {
				    out.println(a[0] + " " + a[1]);
				}
			}
		}
	}

	private static List<int[]> solve(int n) {
	    List<int[]> ans = new LinkedList<>();
	    ans.add(new int[] {1, 1});
	    if (n == 1) {
	        return ans;
	    }
	    int r = 2;
	    ans.add(new int[] {r, 2});
	    n -= 2;
	    while (n > 500 - ans.size()) {
	        n -= r;
	        r++;
	        ans.add(new int[] {r, 2});
	    }
	    for (int i = 0; i < n; i++) {
	        ans.add(new int[] {r, 1});
	        r++;
	    }
		return ans;
	}

}
