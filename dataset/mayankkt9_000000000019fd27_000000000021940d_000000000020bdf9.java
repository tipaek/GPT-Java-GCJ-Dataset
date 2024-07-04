
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scan scan = new Scan();
		Print print = new Print();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = scan.scanInt();
		int itr = 1;
		while (t > 0) {
			int n = scan.scanInt();

			int interval[][] = new int[n][2];
			PriorityQueue<Store> pq = new PriorityQueue<Store>();
			for (int i = 0; i < n; i++) {
				interval[i][0] = scan.scanInt();
				interval[i][1] = scan.scanInt();
				pq.add(new Store(i, interval[i][0], interval[i][1], 'x'));
			}
			int cend = -1;
			boolean flag = false;
			int jend = -1;
			Map<Integer, Store> mp = new HashMap<>();
			while (!pq.isEmpty()) {
				Store s = pq.poll();
				mp.put(s.index, s);
				if (s.start >= cend) {
					s.ch = 'C';
					cend = s.end;
				} else if (s.start >= jend) {
					s.ch = 'J';
					jend = s.end;
				} else {
					flag = true;
					break;
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				sb.append(mp.get(i).ch);
			}
			if (flag)
				System.out.println("Case #" + itr + ": IMPOSSIBLE");
			else
				System.out.println("Case #" + itr + ": " + sb.toString());
			itr++;
			t--;
			mp = null;
			pq = null;
		}
	}
}

class Store implements Comparable<Store> {
	int index;
	int start;
	int end;
	char ch;

	public Store(int i, int s, int e, char c) {
		index = i;
		start = s;
		end = e;
		ch = c;
	}

	@Override
	public int compareTo(Store o) {
		// TODO Auto-generated method stub

		if (start != o.start)
			return start - o.start;
		return end - o.end;

	}

	public String toString() {
		return index + " " + start + " " + end + " " + ch;
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
