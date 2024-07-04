import java.util.Scanner;

public class Solution {

	Scanner		in			= new Scanner(System.in);
	final int	maxQueries	= 150;
	int			query		= 0;
	int			t;
	int			b;
	int			nextInt;
	int[]		bytes;

	void solve() throws Exception {
		for (int i = 0; i < b / 2; i++) {
			query(i);
			query(bytes.length - i - 1);
		}
		System.out.println(bytes);
	}

	void run() throws Exception {
		t		= in.nextInt();
		b		= in.nextInt();
		bytes	= new int[b];
		for (int i = 0; i < t; i++) {
			solve();
			if (in.next().equals("N")) System.exit(-205);
		}
	}

	public static void main(String[] args) throws Exception { new Solution().run(); }

	void query(int index) {
		if (query++ < 150) {
			System.out.println(index + 1);
			System.out.flush();
			String temp = in.next();
			switch (temp) {
				case "N":
					System.exit(-1);
					break;
				default:
					bytes[index] = Integer.valueOf(temp);
					break;
			}
		}
	}

	void reverse() {
		for (int i = 0; i < bytes.length / 2; i++) {
			int temp = bytes[i];
			bytes[i]					= bytes[bytes.length - i - 1];
			bytes[bytes.length - i - 1]	= temp;
		}
	}

	void flip() {
		for (int i = 0; i < bytes.length; i++)
			bytes[i] = 1 - bytes[i];
	}

	void reverseFlip() {
		flip();
		reverse();
	}
}