import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int b = s.nextInt();
		for (int i = 1; i <= t; i++) {
			solution(s, b);
		}

	}

	private static String solution(Scanner s, int b) {
		char[] bits = new char[b];
		int j = 0;
		int comp = 0;
		int rev = 0;
		int i = 1;
		while (j < b / 2) {
			if (i >= 11 && i % 10 == 1) {
				if (comp == 0) {
					System.out.println(1);
					System.out.flush();
					s.next();
				} else {
					System.out.println(comp);
					System.out.flush();
					char ch = s.next().charAt(0);
					if (ch != bits[comp - 1]) {
						complemented(bits);
					}
				}

				if (rev == 0) {
					System.out.println(1);
					System.out.flush();
					s.next();
				} else {
					System.out.println(rev);
					System.out.flush();
					char ch = s.next().charAt(0);
					if (ch != bits[rev - 1]) {
						reverse(bits);
					}
				}
			} else {
				System.out.println(j + 1);
				System.out.flush();
				char ch = s.next().charAt(0);
				bits[j] = ch;
				
				int k = b - j;
				System.out.println(k);
				System.out.flush();
				ch = s.next().charAt(0);
				bits[k - 1] = ch;
		
				if (bits[j] == bits[k - 1]) {
					comp = j + 1;
				} else {
					rev = j + 1;
				}
				j++;
			}
			i += 2;
		}

		String res = String.valueOf(bits);
		if (isCorrect(res, s)) {
			return res;
		}
		System.exit(0);

		return res;
	}

	private static void reverse(char[] bits) {
		char tmp;
		int mirr = bits.length - 1;
		for (int i = 0; i < bits.length / 2; i++) {
			tmp = bits[i];
			bits[i] = bits[mirr];
			bits[mirr] = tmp;
			mirr--;
		}
	}

	private static void complemented(char[] bits) {
		for (int i = 0; i < bits.length; i++) {
			if (bits[i] == '0') {
				bits[i] = '1';
			} else if (bits[i] == '1') {
				bits[i] = '0';
			}

		}
	}

	static boolean isCorrect(String result, Scanner s) {
		System.out.println(result);
		System.out.flush();
		String ans = s.next();
		return ans.equals("Y");
	}

	
}
