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
	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintStream out = System.out;

		int t = in.nextInt();
		int b = in.nextInt();
		in.nextLine();

		for (int i = 1; i <= t; ++i) {
			if (b == 10) {
				solve10(in, out);
			}
		}
		in.close();
	}
}