import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);

		int t = Integer.parseInt(reader.readLine());
		for (int tt = 0; tt < t; tt++) {
			int n = Integer.parseInt(reader.readLine());
			writer.printf("Case #%d:\n", tt + 1);
			if (n == 1) {
				// Degenerate case
				writer.println("1 1");
				continue;
			}
			int base = f(n);
			int base_g = g(n);

			int x = n - base - base_g;
			if (x < 0) {
				// traverse down to base_g - 1th layer and append 1s
				for (int i = 0; i < base_g; i++) {
					writer.printf("%d 1\n", i + 1);
				}
				for (int i = 0; i < base_g - 1; i++) {
					writer.printf("%d %d\n", base_g, i + 2);
				}
				x = n - (base / 2) - (base_g - 1);
				// append 1's
				for (int i = 0; i < x; i++) {
					int y = base_g + i + 1;
					writer.printf("%d %d\n", y, y);
				}
			} else {
				List<String> list = new ArrayList<String>();
				for (int i = 0; i < base_g + 1; i++) {
					list.add(String.format("%d %d", base_g + 1, base_g - i + 1));
				}
				int pow = 1;
				int counter = 1;
				for (int i = 0; i < base_g - 1; i++) {
					pow *= 2;
					counter++;
				}
				boolean forward = true;
				for (int i = 0; i < base_g; i++) {
					if (x >= pow - 1) {
						x -= (pow - 1);
						if (forward) {
							for (int j = 0; j < counter; j++) {
								list.add(String.format("%d %d", counter, j + 1));
							}
						} else {
							for (int j = counter - 1; j >= 0; j--) {
								list.add(String.format("%d %d", counter, j + 1));
							}
						}
						forward = !forward;
					} else {
						if (forward) {
							list.add(String.format("%d 1", counter));
						} else {
							list.add(String.format("%d %d", counter, counter));
						}
					}
					pow /= 2;
					counter--;
				}
				// backwards
				for (int i = list.size() - 1; i >= 0; i--) {
					writer.println(list.get(i));
				}
			}

		}

		reader.close();
		writer.close();
	}
	// log(n)
	public static int f(int x) {
		if (x == 0) {
			return 0;
		}
		int count = 1;
		while (x > 1) {
			x = x / 2;
			count *= 2;
		}
		return count;
	}
	// log(n)
	public static int g(int x) {
		if (x == 0) {
			return 0;
		}
		int count = 0;
		while (x > 1) {
			x = x / 2;
			count++;
		}
		return count;
	}
}
