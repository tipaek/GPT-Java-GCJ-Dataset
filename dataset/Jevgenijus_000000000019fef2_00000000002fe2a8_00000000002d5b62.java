import java.util.Scanner;

public class Solution {
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int T = reader.nextInt();
		for (int t = 0; t < T; t++) {
			int X = reader.nextInt();
			int Y = reader.nextInt();

			int XX = Math.abs(X);
			int YY = Math.abs(Y);
			boolean changed = false;
//			if (YY > XX) {
//				int temp = YY;
//				YY = XX;
//				XX = temp;
//				changed = true;
//			}
			int power = 1;
			int max = Math.max(XX, YY);
			while (power <= max)
				power *= 2;

			int diff = XX ^ YY;
			if (power - diff != YY && diff != power - 1 && !(diff== XX || diff ==YY)) {
				System.out.printf("Case #%d: %s\n", t + 1, "IMPOSSIBLE");
				continue;
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 32; i++) {
				if (((XX >> i) & 1) == 1) {
					sb.append("E");
				} else if (((YY >> i) & 1) == 1) {
					sb.append("S");
				}
			}
			if (diff != power - 1 && !(diff== XX || diff ==YY)) {
				sb.append('N');
			}
			StringBuilder res = new StringBuilder();
			for (char c : sb.toString().toCharArray()) {
				if (c == 'E' && X < 0) {
					res.append('W');
				} else if (c == 'S' && Y < 0) {
					res.append('N');

				} else if (c == 'N' && Y < 0) {
					res.append('S');

				} else {
					res.append(c);
				}
			}
			if (changed) {
				sb = res;
				res = new StringBuilder();
				for (char c : sb.toString().toCharArray()) {
					if (c == 'E') {
						res.append('S');
					} else if (c == 'S') {
						res.append('E');

					} else if (c == 'N') {
						res.append('W');

					} else {
						res.append('W');
					}
				}
			}

			System.out.printf("Case #%d: %s\n", t + 1, res.toString());
		}
	}
}
