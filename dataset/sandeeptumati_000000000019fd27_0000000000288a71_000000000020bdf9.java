public class Solution {

	private void work() throws IOException {
		Scanner sc = new Scanner(new BufferedReader(new FileReader("B-small-attempt0.in")));
		PrintWriter pw = new PrintWriter(new FileWriter("B-small-attempt0.out"));

		int nc = sc.nextInt();
		for (int tc = 1; tc <= nc; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			int[] x = new int[a + b];
			int[] y = new int[a + b];
			for (int i = 0; i < a + b; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}

			int res = 2;
			if (a == 2 || b == 2) {
				int d1 = (1440 + y[0] - x[1]) % 1440;
				int d2 = (1440 + y[1] - x[0]) % 1440;
				if (d1 > 720 && d2 > 720)
					res = 4;
			}

			pw.printf("Case #%d: %s\n", tc, res);
		}
		pw.close();
		sc.close();
	}

	public static void main(String[] args) throws IOException {
		new Solution().work();
	}

}