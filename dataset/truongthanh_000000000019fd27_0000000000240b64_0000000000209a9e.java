import java.util.*;
import java.io.*;
public class Solution {
	static boolean debug = false;
	static Integer[] result;
	static Boolean[] isSameArray;
	static Integer lastSamePair, lastDiffPair;
	static Scanner input;
	static int b, idx;	// idx is from 0 - 49 / 0 - 4
	static int testNumber = 1;
	static int T;

	public static void main(String args[]) {
		input = new Scanner(System.in);
		T = input.nextInt();
		b = input.nextInt();
		for (int ks = 1; ks <= T; ks++) {
			testNumber = ks;
			solve();
		}
	}

	public static void solve() {
		result = new Integer[b];
		isSameArray = new Boolean[b/2];
		lastSamePair = null;
		lastDiffPair = null;
		idx = 0;
		solve(1);
	}

	public static void solve(int number) {
		print("result: " + Arrays.toString(result));
		print("isSameArray: " + Arrays.toString(isSameArray));
		print("call solve " + number + ", idx = " + idx);
		if (idx == b / 2) {	// all positions are found
			StringBuilder sb = new StringBuilder();
			for (Integer i : result) {
				sb.append((int) i);
			}
			print("---------> RESULT = " + sb.toString());
			System.out.println(sb.toString());
			input.nextLine();
			print("------------> " + input.nextLine());
		} else if (number == 1) { // Judge change array after this query -> change result & isSameArray
			print("	 number == 1");
			if (lastSamePair != null) {
				print("		|| lastSamePair = " + lastSamePair);
				int newVal = check(lastSamePair + 1);
				if (result[lastSamePair] != newVal) {	// same pairs flip (complemented / C + R)
					for (int i = 0; i <= lastSamePair; i++) {
						if (isSameArray[i]) {	// flip other same pairs
							flip(result, i);
							flip(result, b - i - 1);
						}
					}
					print("------------- FLIPPED SAME ----------------");
					print("result: " + Arrays.toString(result));
					print("isSameArray: " + Arrays.toString(isSameArray));
					print("--------------------------------------");
				} else {
					print(" 	--> same pairs remains");
				}
				// don't do anything for same pairs (reversed or none)
			} else {
				print("		same IS null");
				check(1); // dummy check
			}

			if (lastDiffPair != null) {
				print("		|| lastDiffPair = " + lastDiffPair);
				int newVal = check(lastDiffPair + 1);
				if (result[lastDiffPair] != newVal) {	// diff pairs flip (complemented / reversed)
					for (int i = 0; i <= lastDiffPair; i++) {
						if (!isSameArray[i]) {	// flip other diff pairs
							flip(result, i);
							flip(result, b - i - 1);
						}
					}
					print("------------- FLIPPED DIFF ----------------");
					print("result: " + Arrays.toString(result));
					print("isSameArray: " + Arrays.toString(isSameArray));
					print("--------------------------------------");
				} else {
					print(" 	--> diff pairs remains");
				}
				// else don't do anything for same pairs (C + R or none)
			} else {
				print("		diff IS null");
				check(1); // dummy check
			}
			solve((number + 2) % 10);
		} else {	// normal
			int left = check(idx + 1);	// idx is 0-based, curPos is 1-based
			int right = check(b - idx);
			result[idx] = left;
			result[b - idx - 1] = right;
			if (left == right) {
				print("			-> same");
				isSameArray[idx] = true;
				lastSamePair = idx;
			} else {
				print("			-> diff");
				isSameArray[idx] = false;
				lastDiffPair = idx;
			}
			idx++;
			solve((number + 2) % 10);
		}
	}

	public static int check(int i) {
		print("-- check " + i);
		System.out.println(i);
		int response = input.nextInt();
		return response;
	}

	public static void flip(Integer[] result, int i) {
		int tmp = result[i];
		if (result[i] == 1) {
			result[i] = 0;
		} else {
			result[i] = 1;
		}
		print("----> flip " + i + " from " + tmp + " => " + result[i]);
	}

	public static void print(String s) {
		if (debug) {
			System.err.println(s);
		}
	}
}