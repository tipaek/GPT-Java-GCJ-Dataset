
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scan scan = new Scan();
		Print print = new Print();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = scan.scanInt();
		int itr = 1;
		while (t > 0) {

			int r = scan.scanInt();
			int c = scan.scanInt();
			Store arr[][] = new Store[r][c];
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					arr[i][j] = new Store();
					arr[i][j].val = scan.scanInt();
				}
			}
			int d = 0;
			int ans = 0;
			do {
				int currentSum = getSum(arr, r, c);
				ans += currentSum;
				getNbr(arr, r, c);
				d = removeD(arr, r, c);
			//	System.out.println(d);
			} while (d != 0);

			System.out.println("Case #" + itr + ": " + ans);
			itr++;
			t--;

		}
	}

	public static int removeD(Store arr[][], int r, int c) {
		double sum = 0;
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sum = 0;
				if (arr[i][j].val != -1) {
					sum += arr[i][j].left + arr[i][j].right + arr[i][j].down + arr[i][j].up;
					int count = 0;
					if (arr[i][j].left != 0)
						count++;
					if (arr[i][j].up != 0)
						count++;
					if (arr[i][j].down != 0)
						count++;
					if (arr[i][j].right != 0)
						count++;
					sum = sum / count;
				}

				if (arr[i][j].val != -1 && arr[i][j].val < sum) {
					list.add(new int[] { i, j });
				}

			}
		}
		int remd = 0;
		for (int[] x : list) {
			arr[x[0]][x[1]].val = -1;
			remd++;

		}

		list = null;
		return remd;

	}

	public static void getNbr(Store arr[][], int r, int c) {

		for (int i = 0; i < r; i++) {
			int temp = 0;
			for (int j = 1; j < c; j++) {

				if (arr[i][j - 1].val != -1) {
					temp = arr[i][j - 1].val;
				}
				arr[i][j].left = temp;
			}
		}

		for (int i = 0; i < r; i++) {
			int temp = 0;
			for (int j = c - 2; j >= 0; j--) {

				if (arr[i][j + 1].val != -1) {
					temp = arr[i][j + 1].val;
				}
				arr[i][j].right = temp;
			}
		}

		for (int i = 0; i < c; i++) {
			int temp = 0;
			for (int j = 1; j < r; j++) {

				if (arr[j - 1][i].val != -1) {
					temp = arr[j - 1][i].val;
				}
				arr[j][i].up = temp;
			}
		}

		for (int i = 0; i < c; i++) {
			int temp = 0;
			for (int j = r - 2; j >= 0; j--) {

				if (arr[j + 1][i].val != -1) {
					temp = arr[j + 1][i].val;
				}
				arr[j][i].down = temp;
			}
		}
	}

	public static int getSum(Store arr[][], int r, int c) {
		int sum = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j].val != -1) {
					sum += arr[i][j].val;
				}
			}
		}
		return sum;
	}

}

class Store {
	int val;
	int left;
	int right;
	int up;
	int down;

	@Override
	public String toString() {
		return "Store [val=" + val + ", left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
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
