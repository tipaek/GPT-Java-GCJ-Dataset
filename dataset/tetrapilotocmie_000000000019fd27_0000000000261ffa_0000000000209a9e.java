import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	static class Judge {
		public Bit query(int position) {
			System.out.println(position+1);
			System.out.flush();
			int response = scanner.nextInt();
			return Bit.of((char) ('0' + response));
		}

		public void answer(String response) {
			System.out.println(response);
			System.out.flush();
			scanner.nextLine();
			String result = scanner.nextLine();
			if (result.equals("N"))
				System.exit(1);
		}
	}
	void solve(int B) {
		Data b = new Data(B);

		int l = 0;
		int r = B-1;
		int ecp = -1;
		int dcp = -1;

		Judge judge = new Judge();

		int query = 0;
		while (query < 250) {
			if (query >= 10 && (query+1)%10 == 1){
				if (ecp == -1 && dcp != -1) {
					Bit kdl = b.get(dcp);
					Bit kdr = b.get(B - dcp - 1);

					Bit dl = judge.query(dcp); query++;
					Bit dr = judge.query(B - dcp - 1); query++;

					if (dl != kdl && dr != kdr) { // complemented
						b.complement();
					} else if (dl != kdl && dr != kdr) { // flipped
						b.flip();
					}
				} else if (ecp != -1 && dcp == -1) {
					Bit kel = b.get(ecp);
					Bit ker = b.get(B - ecp - 1);

					Bit el = judge.query(ecp); query++;
					Bit er = judge.query(B - ecp - 1); query++;

					if (el != kel && er != ker) { // complemented
						b.complement();
					} else if (el == kel && er == ker) { // flipped
						b.flip();
					} else if (el != kel && er != ker) { // flipped + complemented
						b.flip();
						b.complement();
					}
				} else {
					Bit kel = b.get(ecp);
					Bit ker = b.get(B - ecp - 1);
					Bit kdl = b.get(dcp);
					Bit kdr = b.get(B - dcp - 1);

					Bit el = judge.query(ecp); query++;
					Bit er = judge.query(B - ecp - 1); query++;
					Bit dl = judge.query(dcp); query++;
					Bit dr = judge.query(B - dcp - 1); query++;

					if (el != kel && er != ker && dl != kdl && dr != kdr) { // complemented
						b.complement();
					} else if (el == kel && er == ker && dl != kdl && dr != kdr) { // flipped
						b.flip();
					} else if (el != kel && er != ker && dl == kdl && dr == kdr) { // flipped + complemented
						b.flip();
						b.complement();
					}
				}
			}

			if (l > r) {
				judge.answer(b.toString());
				return;
			}
			Bit left = judge.query(l); query++;
			Bit right = judge.query(r); query++;

			b.set(l, left);
			b.set(r, right);
			if (left == right && ecp == -1) {
				ecp = l;
			}
			else
			if (left != right && dcp == -1) {
				dcp = l;
			}
			l++;r--;


		}
	}

	static class Data {
		Bit[] data;
		private int length;

		public Data(int length) {
			data = new Bit[length];
			this.length = length;
			for (int i = 0; i < length; i++) {
				data[i] = Bit.UNKNOWN;
			}
		}

		public boolean is(Data that) {
			for (int i = 0; i < data.length; i++) {
				if (data[i] != that.get(i)) {
					return false;
				}
			}
			return true;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < length; i++) {
				sb.append(get(i).getValue());
			}
			return sb.toString();
		}

		public void set(int i, Bit bit) {
			data[i] = bit;
		}

		private void flip() {
			for (int i = 0; i < length/2; i++) {
				Bit a = data[i];
				data[i] = data[length-i-1];
				data[length-i-1] = a;
			}
		}

		private void complement() {
			for (int i = 0; i < length; i++) {
				data[i] = data[i].not();
			}
		}

		private Bit get(int i) {
			return data[i];
		}
	}

	enum Bit {
		UNKNOWN('U'),
		ZERO('0'),
		ONE('1');

		private char value;

		Bit(char value) {
			this.value = value;
		}

		public static Bit of(char c) {
			for (Bit bit : Bit.values()) {
				if (bit.getValue() == c)
					return bit;
			}
			throw new IllegalArgumentException("Invalid bit: " + c);
		}


		public char getValue() {
			return value;
		}

		public Bit not() {
			if (this == UNKNOWN) return UNKNOWN;
			return this == ZERO ? ONE : ZERO;
		}
	}

	private static Scanner scanner;
	public static void main(String[] args) {
		scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = scanner.nextInt();
		int B = scanner.nextInt();
		for (int i = 1; i <= testCases; i++) {
			new Solution().solve(B);
		}
	}
}