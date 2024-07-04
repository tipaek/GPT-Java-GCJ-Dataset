import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static long x;
	static long y;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			x = Long.parseLong(st.nextToken());
			y = Long.parseLong(st.nextToken());

			boolean possible = true;
			StringBuilder solution = new StringBuilder();
			int pow = 1;

			while (pow < 4) {
				double pow2 = Math.pow(2, pow);
				double pow2Next = Math.pow(2, pow + 1);
				double pow2Prev = Math.pow(2, pow - 1);

				if (x % pow2 == 0) {
					if (y % pow2 == 0) {
						possible = false;
						break;
					} else {
						if (x == 0 && Math.abs(y) - pow2Prev == 0) {
							if (y > 0) {
								y -= pow2Prev;
								solution.append('N');
							} else {
								y += pow2Prev;
								solution.append('S');
							}
						} else if (x % pow2Next == 0) {
							if ((y + pow2Prev) % pow2Next != 0) {
								y += pow2Prev;
								solution.append('S');
							} else {
								y -= pow2Prev;
								solution.append('N');
							}
						} else {
							if ((y + pow2Prev) % pow2Next == 0) {
								y += pow2Prev;
								solution.append('S');
							} else {
								y -= pow2Prev;
								solution.append('N');
							}
						}
					}
				} else {
					if (y % pow2 != 0) {
						possible = false;
						break;
					} else {
						if (y == 0 && Math.abs(x) - pow2Prev == 0) {
							if (x > 0) {
								x -= pow2Prev;
								solution.append('E');
							} else {
								x += pow2Prev;
								solution.append('W');
							}
						} else if (y % pow2Next == 0) {
							if ((x + pow2Prev) % pow2Next != 0) {
								x += pow2Prev;
								solution.append('W');
							} else {
								x -= pow2Prev;
								solution.append('E');
							}
						} else {
							if ((x + pow2Prev) % pow2Next == 0) {
								x += pow2Prev;
								solution.append('W');
							} else {
								x -= pow2Prev;
								solution.append('E');
							}
						}
					}
				}

				if (x == 0 && y == 0) {
					break;
				}
				pow++;
			}

			System.out.print("Case #" + (i + 1) + ": ");
			if (!possible) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(solution);
			}
		}

		reader.close();
	}
}