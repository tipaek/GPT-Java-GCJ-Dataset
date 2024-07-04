import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; i++) {
			solve(i, in);
		}
	}

	public static void solve(int t, Scanner in){
		int L = in.nextInt();
		int R = in.nextInt();
		
		int n = 0;
		n = (int) Math.floor(Math.sqrt(2 * Math.abs(L - R) + 0.25) - 0.5);
		if (L >= R){
			L = L - n*(n+1)/2;
		} else {
			R = R - n*(n+1)/2;
		}
		
		int a = 0, b = 0; // a is value do first
		if (L >= R){
			a = (int) Math.floor(Math.sqrt(L + 0.25 * n * n) - 0.5 * n) - 1;
			b = (int) Math.floor(Math.sqrt(R + 0.25 * (n + 1) * (n + 1)) - 0.5 * (n + 1)) - 1;
			L = L - (a + 1) * (n + 1 + a);
			R = R - (b + 1) * (n + 2 + b);
		} else {
			a = (int) Math.floor(Math.sqrt(R + 0.25 * n * n) - 0.5 * n) - 1;
			b = (int) Math.floor(Math.sqrt(L + 0.25 * (n + 1) * (n + 1)) - 0.5 * (n + 1)) - 1;
			R = R - (a + 1) * (n + 1 + a);
			L = L - (b + 1) * (n + 2 + b);
		}
		
		n = Math.max(n + 1 + 2*a, n + 2 + 2*b);
		
		System.out.println("Case #" + t + ": " + n + " " + L + " " + R);
	}
}