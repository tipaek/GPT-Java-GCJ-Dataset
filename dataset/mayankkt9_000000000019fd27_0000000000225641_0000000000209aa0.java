
import java.awt.List;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scan scan = new Scan();
		Print print = new Print();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = scan.scanInt();
		int itr = 1;
		while (t > 0) {
			int n = scan.scanInt();
			int k = scan.scanInt();

			Task obj = new Task(n);
			obj.backtrack(0, 0, n, k);

			int[][] res = obj.soln;
			if (res[0][0] == -1)
				System.out.println("Case #" + itr + ": IMPOSSIBLE");
			else {
				System.out.println("Case #" + itr + ": POSSIBLE");
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						System.out.print(res[i][j] + " ");
					}
					System.out.println();
				}
			}

			itr++;
			t--;

		}
	}

	public static void addOpen(StringBuilder sb, int x) {
		for (int i = 1; i <= x; i++)
			sb.append("(");
	}

	public static void addClose(StringBuilder sb, int x) {
		for (int i = 1; i <= x; i++)
			sb.append(")");
	}
}

class Task {

	ArrayList<HashSet<Integer>> rowList;
	ArrayList<HashSet<Integer>> colList;
	int res[][];
	int n;
	int sum;
	int soln[][];

	public Task(int size) {
		rowList = new ArrayList<HashSet<Integer>>();
		colList = new ArrayList<HashSet<Integer>>();
		n = size;
		sum = 0;
		for (int i = 0; i < n; i++) {
			rowList.add(new HashSet<Integer>());
			colList.add(new HashSet<Integer>());
		}
		res = new int[n][n];
		soln = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				res[i][j] = -1;
				soln[i][j] = -1;
			}
		}
	}

	public void backtrack(int x, int y, int n, int k) {
		if (x == n || y == n)
			return;
		if (res[x][y] != -1)
			return;

		for (int i = 1; i <= n; i++) {
			if (!rowList.get(x).contains(i) && !colList.get(y).contains(i)) {
				res[x][y] = i;
				rowList.get(x).add(i);
				colList.get(y).add(i);
				if (x == y)
					sum += i;
				if (sum > k) {
					res[x][y] = -1;
					rowList.get(x).remove(i);
					colList.get(y).remove(i);
					sum -= i;
					continue;
				}
				if (sum == k && x == n - 1 && y + 1 == n) {
					//System.out.println(Arrays.deepToString(res));
					for (int p = 0; p < n; p++)
						soln[p] = res[p].clone();
					return;
				}
				if (x == n - 1 && y + 1 == n) {
					// System.out.println(Arrays.deepToString(res));
					res[x][y] = -1;
					rowList.get(x).remove(i);
					colList.get(y).remove(i);
					sum -= i;
					continue;
				}
				if (y + 1 != n) {
					backtrack(x, y + 1, n, k);
				} else {
					backtrack(x + 1, 0, n, k);
				}
				if (x == y)
					sum -= i;
				if (x < n && y < n)
					res[x][y] = -1;
				rowList.get(x).remove(i);
				colList.get(y).remove(i);
			}
		}

	}
}

class Scan {
	private byte[] buf = new byte[1024];
	private int index;
	private InputStream in;
	private int total;

	public Scan() {
		in = System.in;
	}

	public int scan() throws IOException {
		if (total < 0)
			throw new InputMismatchException();
		if (index >= total) {
			index = 0;
			total = in.read(buf);
			if (total <= 0)
				return -1;
		}
		return buf[index++];
	}

	public int scanInt() throws IOException {
		int integer = 0;
		int n = scan();
		while (isWhiteSpace(n))
			n = scan();
		int neg = 1;
		if (n == '-') {
			neg = -1;
			n = scan();
		}
		while (!isWhiteSpace(n)) {
			if (n >= '0' && n <= '9') {
				integer *= 10;
				integer += n - '0';
				n = scan();
			} else
				throw new InputMismatchException();
		}
		return neg * integer;
	}

	public long scanLong() throws IOException {
		long integer = 0;
		long n = scan();
		while (isWhiteSpace(n))
			n = scan();
		int neg = 1;
		if (n == '-') {
			neg = -1;
			n = scan();
		}
		while (!isWhiteSpace(n)) {
			if (n >= '0' && n <= '9') {
				integer *= 10;
				integer += n - '0';
				n = scan();
			} else
				throw new InputMismatchException();
		}
		return neg * integer;
	}

	public double scanDouble() throws IOException {
		double doub = 0;
		int n = scan();
		while (isWhiteSpace(n))
			n = scan();
		int neg = 1;
		if (n == '-') {
			neg = -1;
			n = scan();
		}
		while (!isWhiteSpace(n) && n != '.') {
			if (n >= '0' && n <= '9') {
				doub *= 10;
				doub += n - '0';
				n = scan();
			} else
				throw new InputMismatchException();
		}
		if (n == '.') {
			n = scan();
			double temp = 1;
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					temp /= 10;
					doub += (n - '0') * temp;
					n = scan();
				} else
					throw new InputMismatchException();
			}
		}
		return doub * neg;
	}

	public String scanString() throws IOException {
		StringBuilder sb = new StringBuilder();
		int n = scan();
		while (isWhiteSpace(n))
			n = scan();
		while (!isWhiteSpace(n)) {
			sb.append((char) n);
			n = scan();
		}
		return sb.toString();
	}

	private boolean isWhiteSpace(int n) {
		if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
			return true;
		return false;
	}

	private boolean isWhiteSpace(long n) {
		if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
			return true;
		return false;
	}
}

class Print {
	private final OutputStream out;

	/*
	 * public Print(OutputStream outputStream) { writer=new PrintWriter(new
	 * BufferedWriter(new OutputStreamWriter(outputStream))); }
	 */
	public Print() {
		this.out = System.out;
	}

	public void print(String str) throws IOException {
		// buf=str.getBytes();
		for (int i = 0; i < str.length(); i++) {
			/*
			 * if (i != 0) out.write(' ');
			 */
			out.write(str.charAt(i));
		}
	}

	public void printLine(String str) throws IOException {
		print(str);
		out.write('\n');
	}

	public void close() throws IOException {
		out.close();
	}
}