import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Vestigium {
	public static int colRepeat(String[][] a) {
		int q = 0;
		for (int i = 0; i < a.length; i++)
			for (int r = 0; r < a.length; r++) {
				for (int c = r + 1; c < a.length; c++)
					if (a[r][i].equals(a[c][i])) {
						q++;
						c = a.length;
						r = a.length;
					}
			}
		return q;
	}

	public static int rowRepeat(String[][] a) {
		int q = 0;
		for (int i = 0; i < a.length; i++)
			for (int r = 0; r < a.length; r++) {
				for (int c = r + 1; c < a.length; c++)
					if (a[i][r].equals(a[i][c])) {
						q++;
						c = a.length;
						r = a.length;
					}
			}
		return q;
	}

	public static int trace(String[][] a) {
		int t = 0;
		for (int r = 0; r < a.length; r++)
			t += Integer.parseInt(a[r][r]);
		return t;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		for (int i = 1; i <= T; i++) {
			int r = 0;
			int c = 0;
			int t = 0;
			int n = Integer.parseInt(reader.readLine());
			String[][] x = new String[n][n];
			for (int q = 0; q < n; q++)
				x[q] = reader.readLine().split(" ");
			c = colRepeat(x);
			r = rowRepeat(x);
			t = trace(x);
			System.out.println("Case #" + i + ": " + t + " " + r + " " + c);
		}
	}
}
