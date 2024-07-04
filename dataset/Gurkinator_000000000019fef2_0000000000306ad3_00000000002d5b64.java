import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private Scanner scanner = new Scanner(System.in);

	private String solve() throws Exception {
		int				r			= scanner.nextInt();
		int				s			= scanner.nextInt();
		List<Integer>	c			= new ArrayList<Integer>();
		int				cnt			= 0;
		int				x			= r - 1;
		int				y			= (r * s) - r;
		int				a	= s - 1;
		while (true) {
			if (x == 1 && y < s) break;
			c.add(y);
			c.add(x);
			cnt++;
			if (a > 0 && s != 2) {
				a--;
				y--;
				continue;
			}
			if (x > 1) x--;
			if (y > 1) y--;
		}
		String out = "";
		out += cnt;
		for (int i = 0; i < c.size() - 1; i += 2) {
			out += "\n" + c.get(i) + " " + c.get(i + 1);
		}
		return out;
	}

	private void run() throws Exception {
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.printf("Case #%d: %s%n", i + 1, solve());
		}
	}

	public static void main(String[] args) throws Exception { new Solution().run(); }
}
