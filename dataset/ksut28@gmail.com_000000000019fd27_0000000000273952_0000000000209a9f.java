
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scan s = new Scan();
		int testCases = s.scanInt();

		for (int test = 1; test <= testCases; test++) {

			System.out.print("Case #" + test + ": ");
			String input = s.scanString();
			String result = "";
			long len = input.length();
			int num, temp;
			for (int i = 0; i < len; i++) {
				num = input.charAt(i) - '0';
				temp = num;
				for (int j = 0; j < num; j++) {
					if (result.length() > 0) {
						while (!Character.isDigit(result.charAt(result.length() - 1)) && temp > 0) {
							result = result.substring(0, result.length() - 1);
							--temp;
						}
					}
				}
				for (int j = 0; j < temp; ++j) {
					result += "(";
				}
				result += String.valueOf(input.charAt(i));

				for (int j = 0; j < num; ++j)
					result += ")";
			}
			System.out.println(result);
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
}
