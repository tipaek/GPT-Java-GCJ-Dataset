import java.util.*;
class Solution {
	public static void main(String[] commands) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int B = in.nextInt();
		in.nextLine();
		for (int t = 1; t <= T; t++) {
			char[] data = new char[B];
			int left = 1;
			int right = B;
			while (left < right) {
				System.out.println(left);
				System.out.flush();
				String a = in.nextLine();
				System.out.println(right);
				System.out.flush();
				String b = in.nextLine();
				if (a.equals(b)) {
					data[left-1] = 'S';
					data[right-1] = 'S';
				} else {
					data[left-1] = 'D';
					data[right-1] = 'D';
				}
				left++;
				right--;
			}
			char firstCurrent = 'X';
			char[] result = new char[B];
			for (int i = B / 2 - 1; i >= 0; i--) {
				System.out.println(i+1);
				System.out.flush();
				String a = in.nextLine();
				char c = a.charAt(0);
				if (c == '0') {
					result[i] = '0';
					if (data[i] == 'S') {
						result[B-i-1] = '0';
					} else {
						result[B-i-1] = '1';
					}
				}
				if (c == '1') {
					result[i] = '1';
					if (data[i] == 'S') {
						result[B-i-1] = '1';
					} else {
						result[B-i-1] = '0';
					}
				}
			}
			System.out.println(new String(result));
			System.out.flush();
			String check = in.nextLine();
		}
		System.exit(0);
	}
}
