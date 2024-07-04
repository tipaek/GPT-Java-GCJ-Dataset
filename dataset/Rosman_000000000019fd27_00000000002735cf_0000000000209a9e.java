import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {

	public static void main(final String[] args) {
		new Solution(false).start();
	}

	private InputStream in;
	private PrintStream out;

	public Solution(final boolean local) {
		if (local) {
			Process p;
			try {
				p = Runtime.getRuntime().exec("python -i local_testing_tool.py 0");
				in = p.getInputStream();
				out = new PrintStream(p.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			in = System.in;
			out = System.out;
		}
	}

	public void start() {
		Scanner sc = new Scanner(in);
		int t = sc.nextInt();
		int b = sc.nextInt();
		sc.nextLine();

		System.err.println(t + " " + b);

		boolean work = true;

		while (work) {
			BitSet bc;
			if (b == 10) {
				System.err.println("C10");
				bc = new BitSet(b + 1);
				for (int i = 1; i < 11; i++) {
					read(sc, bc, i);
				}
			} else {
				BitSet bp = new BitSet(b + 1);
				bc = new BitSet(b + 1);

				int index = 0;

				for (int i = index; i < (index + 10); i++) {
					read(sc, bc, i);
					read(sc, bc, b - i);
				}
			}

			write(bs2String(bc, 10));
			sc.nextLine();
			String result = sc.nextLine();
			System.err.println("R:" + result);
			if (result.equals("Y")) {
				work = true;
				t--;
				if (t == 0) {
					work = false;
				}
			} else {
				work = false;
			}
		}
	}

	private void read(final Scanner sc, final BitSet bc, final int pos) {
		int v;
		write(pos);
		v = sc.nextInt();
		System.err.println(pos + " > " + v);
		bc.set(pos, v == 1);
	}

	private String bs2String(final BitSet bs, final int l) {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= l; i++) {
			sb.append(bs.get(i) ? "1" : "0");
		}
		return sb.toString();
	}

	private void write(final String data) {
		System.err.println(">>" + data);
		out.println(data);
		out.flush();
	}

	private void write(final int v) {
		String data = Integer.toString(v);
		System.err.println(">>" + data);
		out.println(data);
		out.flush();
	}
}
