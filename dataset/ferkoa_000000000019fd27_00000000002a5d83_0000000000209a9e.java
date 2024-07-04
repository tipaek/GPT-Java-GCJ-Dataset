import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

	//////////////////////////////////////////////////
	private static int nextInt(Scanner in) {
		int i = in.nextInt();
		in.nextLine();
		return i;
	}

	//////////////////////////////////////////////////
	private static void println(PrintStream out, int i) {
		out.println(i);
		out.flush();
	}

	//////////////////////////////////////////////////
	private static void println(PrintStream out, String s) {
		out.println(s);
		out.flush();
	}

	//////////////////////////////////////////////////
	private static void solve10(Scanner in, PrintStream out) {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= 10; i++) {
			println(out, i);
			sb.append(nextInt(in));
		}
		println(out, sb.toString());
		String ans = in.nextLine();
		if (!"Y".equals(ans))
			throw new RuntimeException("Wrong answer.");
	}

	//////////////////////////////////////////////////
	private static void solve20(Scanner in, PrintStream out) {
		int[] arr = new int[20];
		for (int i = 1; i <= 5; i++) {
			println(out, i);
			arr[i - 1] = nextInt(in);
			println(out, 21 - i);
			arr[21 - i - 1] = nextInt(in);
		}
		for (int i = 6; i <= 10; i++) {
			println(out, i);
			arr[i - 1] = nextInt(in);
			println(out, 21 - i);
			arr[21 - i - 1] = nextInt(in);
		}
		solveBlock(in, out, arr, 0);
		solveBlock(in, out, arr, 5);
		StringBuffer sb = new StringBuffer();
		for (int i : arr) {
			sb.append(i);
		}
		println(out, sb.toString());
		String ans = in.nextLine();
		if (!"Y".equals(ans))
			throw new RuntimeException("Wrong answer.");
	}

	//////////////////////////////////////////////////
	private static void solveBlock(Scanner in, PrintStream out, int[] arr, int start) {
		int ixSame = -1;
		int ixDistinct = -1;
		for (int i = 0; i < 5 && (ixDistinct == -1 || ixSame == -1); i++) {
			if (arr[start + i] == arr[arr.length - 1 - start - i]) {
				ixSame = start + i;
			} else {
				ixDistinct = start + i;
			}
		}
		if (ixSame == -1 || ixDistinct == -1) {
			// Either all pairs are from same elements (00 or 11)
			// or all pairs are from distinct elements (10 or 01).
			int ix = ixDistinct == -1 ? ixSame : ixDistinct;
			println(out, ix + 1);
			int res = nextInt(in);
			if (arr[ix] == res)
				return;
			complementBlock(arr, start);
			return;
		}
		// We have both pairs from same elements and pairs from distinct
		// elements.
		println(out, ixSame + 1);
		int resSame = nextInt(in);
		boolean eqSame = arr[ixSame] == resSame;
		println(out, ixDistinct + 1);
		int resDistinct = nextInt(in);
		boolean eqDistinct = arr[ixDistinct] == resDistinct;
		if (eqSame) {
			if (eqDistinct) {
				// nothing happened to the array
				return;
			} else {
				// the array is reversed
				reverseBlock(arr, start);
				return;
			}
		} else {
			if (eqDistinct) {
				// complementation and reversal
				reverseBlock(arr, start);
				complementBlock(arr, start);
				return;
			} else {
				// array is complemented
				complementBlock(arr, start);
				return;
			}
		}
	}

	//////////////////////////////////////////////////
	private static void complementBlock(int[] arr, int start) {
		for (int i = 0; i < 5; i++) {
			arr[start + i] ^= 1;
			arr[arr.length - 1 - start - i] ^= 1;
		}
	}

	//////////////////////////////////////////////////
	private static void reverseBlock(int[] arr, int start) {
		for (int i = 0; i < 5; i++) {
			int tmp = arr[start + i];
			arr[start + i] = arr[arr.length - 1 - start - i];
			arr[arr.length - 1 - start - i] = tmp;
		}
	}

	//////////////////////////////////////////////////
	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintStream out = System.out;

		int t = in.nextInt();
		int b = in.nextInt();
		in.nextLine();

		for (int i = 1; i <= t; ++i) {
			if (b == 10) {
				solve10(in, out);
			} else if (b == 20) {
				solve20(in, out);
			}
		}
		in.close();
	}
}