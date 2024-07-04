import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tC; t++) {
			System.out.print("Case #" + t + ": ");

			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int absX = Math.abs(x);
			int absY = Math.abs(y);

			if (absX % 2 == absY % 2) {
				System.out.println("IMPOSSIBLE");
				continue;
			}

			StringBuilder bX = new StringBuilder(Integer.toBinaryString(absX));
			StringBuilder bY = new StringBuilder(Integer.toBinaryString(absY));

			int diff = bX.length() - bY.length();

			if (diff > 0) {
				for (int i = 0; i < diff; i++) {
					bY.insert(0, "0");
				}
			} else if (bY.length() > bX.length()) {
				for (int i = 0; i < -diff; i++) {
					bX.insert(0, "0");
				}
			}

			bX.reverse();
			bY.reverse();
			// System.out.println(bX);
			// System.out.println(bY);
			// can check here if same length

			boolean yes = true;

			for (int i = 1; i < bX.length(); i++) {
				if (bX.charAt(i) == '1' && bY.charAt(i) == '1') {
					if (bX.charAt(i - 1) != '1' && bY.charAt(i - 1) != '1') {
						yes = false;
						break;
					} else if (bX.charAt(i - 1) == '1') {
						bX.setCharAt(i - 1, '-');
						bX.setCharAt(i,'0');
						int index = i + 1;

						while (index < bX.length() && bX.charAt(index) == '1') {
							bX.setCharAt(index, '0');
							index++;
						}
						
						System.out.println(bX);
						System.out.println(bY);
						System.out.println(index);

						if (index == bX.length()) {
							bY.append("0");
							bX.append("1");
						} else {
							bX.setCharAt(index, '1');
						}

					} else {
						bY.setCharAt(i - 1, '-');
						bY.setCharAt(i, '0');
						int index = i + 1;

						while (index < bY.length() && bY.charAt(index) == '1') {
							bY.setCharAt(index, '0');
							index++;
						}

						if (index == bY.length()) {
							bX.append("0");
							bY.append("1");
						} else {
							bY.setCharAt(index, '1');
						}
					}
				}
			}

			if (!yes) {
				System.out.println("IMPOSSIBLE");
				continue;
			}

			for (int i = 1; i < bX.length(); i++) {
				if (bX.charAt(i) == '0' && bY.charAt(i) == '0') {

					if (bX.charAt(i - 1) == '1') {
						bX.setCharAt(i - 1, '-');
						bX.setCharAt(i, '1');
					} else if (bX.charAt(i - 1) == '-') {
						bX.setCharAt(i - 1, '1');
						bX.setCharAt(i, '-');
					} else if (bY.charAt(i - 1) == '-') {
						bY.setCharAt(i - 1, '1');
						bY.setCharAt(i, '-');
					} else {
						bY.setCharAt(i - 1, '-');
						bY.setCharAt(i, '1');
					}

				}
			}

			// bX.reverse();
			// bY.reverse();

			if (x < 0) {
				for (int i = 0; i < bX.length(); i++) {
					if (bX.charAt(i) == '1') {
						bX.setCharAt(i, '-');
					} else if (bX.charAt(i) == '-') {
						bX.setCharAt(i, '1');
					}
				}
			}

			if (y < 0) {
				for (int i = 0; i < bY.length(); i++) {
					if (bY.charAt(i) == '1') {
						bY.setCharAt(i, '-');
					} else if (bY.charAt(i) == '-') {
						bY.setCharAt(i, '1');
					}
				}
			}

			for (int i = 0; i < bX.length(); i++) {
				if (bX.charAt(i) == '1') {
					System.out.print("E");
				} else if (bX.charAt(i) == '-') {
					System.out.print("W");
				} else if (bY.charAt(i) == '1') {
					System.out.print("N");
				} else {
					System.out.print("S");
				}
			}

			System.out.println(" " + x + " " + y);
		}
	}
}
