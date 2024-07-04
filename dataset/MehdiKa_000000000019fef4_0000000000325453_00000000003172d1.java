import java.util.*;
import java.util.stream.Stream;
import java.io.*;
import java.math.BigInteger;
public class Solution {

	static int solve(int n, int d, BigInteger[] a) {
		int result = 0;
		Arrays.sort(a);
		if (d == 2) {
			for (int i=0; i<n-1; i++) {
				if (a[i].compareTo(a[i+1]) == 0) return 0;
			}
			return 1;
		}
		if (d == 3) {
			for (int i=0; i<n-2; i++) {
				if ((a[i].compareTo(a[i+1]) == 0) && (a[i].compareTo(a[i+2]) == 0)) return 0;
			}
			for (int i=0; i<n-1; i++) {
				for (int k=i+1; k<n; k++) {
					if (a[i].add(a[i]).compareTo(a[k]) == 0) return 1;
				}
			}
			return 2;
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner in;
		try {
			in = new Scanner(new BufferedReader(new FileReader("bin/myinput.txt")));
		} catch (IOException e) {
			// e.printStackTrace();
			 in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));			
		}
		
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int d = in.nextInt();
			BigInteger[] a = new BigInteger[n];
			for (int k = 0; k < n; ++k) {
				a[k] = in.nextBigInteger();
			}
			int result = solve(n, d, a);
			System.out.println("Case #" + i + ": " + result);
		}
		in.close();
	}

}
