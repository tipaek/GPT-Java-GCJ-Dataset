import java.util.*;
class Solution {
	public static void main(String[] commands) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int B = in.nextInt();
		in.nextLine();
		for (int t = 1; t <= T; t++) {
			char[] data = new char[B];
			char[] state = new char[B];
			int left = 1;
			int right = B;
			while (left < right) {
				System.out.println(left);
				System.out.flush();
				char a = in.nextLine().charAt(0);
				System.out.println(right);
				System.out.flush();
				char b = in.nextLine().charAt(0);
				if (a == b) {
					data[left-1] = 'S';
					data[right-1] = 'S';
				} else {
					data[left-1] = 'D';
					data[right-1] = 'D';
				}
				state[left-1] = a;
				state[right-1] = b;
				left++;
				right--;
			}

			String result = null;
			if (B <= 10) {
				result = new String(state);
			} else {
				String[] candidate = { new String(state), "", "", ""};
				for (char c : state) { candidate[1] += c == '0' ? '1' : '0'; }
				for (int i = state.length - 1; i >= 0; i--) { candidate[2] += state[i]; }
				for (int i = state.length - 1; i >= 0; i--) { candidate[3] += state[i] == '0' ? '1': '0'; }
				for (int i = 0; i < 4; i++) {
					for (int j = i + 1; j < 4; j++) {
						if (candidate[i].equals(candidate[j])) {
							candidate[j] = candidate[j].replace('0', 'x').replace('1', 'y');
						}
					}
				}
				// for (int i = 0; i < 4; i++) { System.out.println(candidate[i]); }
				for (int i = 0; i < B / 20; i++) {
					int [] score = new int[4];
					for (int j = 0; j < 10; j++) {
						// int k = ((i*10) + j) % B + 1;
						int k = j + 1;
						System.out.println(k);
						System.out.flush();
						char r = in.nextLine().charAt(0);
						for (int e = 0; e < 4; e++) {
							if (candidate[e].charAt(k-1) == r) {
								score[e]++;
							}
						}
					}
					/*
					int fullCount = 0;
					for (int e = 0; e < 4; e++) {
						if (score[e] == 10) {
							fullCount++;
						}
					}
					if (fullCount == 1) {
						for (int e = 0; e < 4; e++) {
							if (score[e] == 10) {
								result = candidate[e];
							}
						}
					}
					*/
					for (int e = 0; e < 4; e++) {
						if (score[e] == 10) {
							result = candidate[e];
						}
					}
					if (result != null) {
						break;
					}
				}
			}
			System.out.println(result);
			System.out.flush();
			String check = in.nextLine();
		}
		System.exit(0);
	}
}
