import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Solution {

	private Scanner in;
	private PrintWriter out;

	public static void main(String[] args) throws IOException {
		Solution solver = new Solution();
		solver.solve();
	}

	public Solution() {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
	}

	public void solve() {
		int nbTests = in.nextInt();
		int A = in.nextInt();
		int B = in.nextInt();

		for (int t = 1; t <= nbTests; t++) {

			int X = 1_000_000_000 / 2;
			int Y = 1_000_000_000 / 2;

			int x = X;
			int y = Y;

			out.println(x + " " + y);
			out.flush();
			String res = getResponse("WRONG");

			if (res.equals("MISS")) {
				x = X;
				y = -Y;
				out.println(x + " " + y);
				out.flush();
				res = getResponse("WRONG");

				if (res.equals("MISS")) {
					x = -X;
					y = Y;
					out.println(x + " " + y);
					out.flush();
					res = getResponse("WRONG");

					if (res.equals("MISS")) {
						x = -X;
						y = -Y;
						out.println(x + " " + y);
						out.flush();
						res = getResponse("WRONG");
					}
				}
			}

			int l = -1_000_000_000;
			int r = x + 1_000_000_000 / 2;
			int xl = (l + r) / 2;

			while (l < r) {
				out.println(xl + " " + y);
				out.flush();
				res = getResponse("WRONG");

				if (res.equals("CENTER")) {
					break;
				} else if (res.equals("HIT")) {
					xl = (l + r) / 2;
					r = xl;
				} else {
					xl = (l + r) / 2;
					l = xl;
				}
			}
			if (res.equals("CENTER")) {
				continue;
			}

			l = x - 1_000_000_000 / 2;
			r = 1_000_000_000;
			int xr = (l + r) / 2;

			while (l < r) {
				out.println(xr + " " + y);
				out.flush();
				res = getResponse("WRONG");

				if (res.equals("CENTER")) {
					break;
				} else if (res.equals("HIT")) {
					xr = (l + r) / 2;
					l = xr;
				} else {
					xr = (l + r) / 2;
					r = xr;
				}
			}
			if (res.equals("CENTER")) {
				continue;
			}

			////////////////////////////////////// :

			int b = -1_000_000_000;
			int u = y + 1_000_000_000 / 2;
			int yb = (b + u) / 2;

			while (b < u) {
				out.println(x + " " + yb);
				out.flush();
				res = getResponse("WRONG");

				if (res.equals("CENTER")) {
					break;
				} else if (res.equals("HIT")) {
					yb = (b + u) / 2;
					u = yb;
				} else {
					yb = (b + u) / 2;
					b = yb;
				}
			}
			if (res.equals("CENTER")) {
				continue;
			}

			b = y - 1_000_000_000 / 2;
			u = 1_000_000_000;
			int yu = (b + u) / 2;

			while (b < u) {
				out.println(x + " " + yu);
				out.flush();
				res = getResponse("WRONG");

				if (res.equals("CENTER")) {
					break;
				} else if (res.equals("HIT")) {
					yu = (b + u) / 2;
					b = yu;
				} else {
					yu = (b + u) / 2;
					u = yu;
				}
			}
			if (res.equals("CENTER")) {
				continue;
			}

			out.println((xl + xr) / 2 + " " + (yb + yu) / 2);
			out.flush();
			res = getResponse("WRONG");
		}
	}

	private String getResponse(String responseError) {
		String resp = in.next();
		if (resp.equals(responseError)) {
			System.out.println("ERROR: received " + resp);
			while (in.hasNextLine()) {
				System.out.println(in.nextLine());
			}
			throw new RuntimeException();
		}

		return resp;
	}

	private int getResponse(int responseError) {
		String resp = in.next();
		if (resp.equals(String.valueOf(responseError))) {
			System.out.println("ERROR: received " + resp);
			while (in.hasNextLine()) {
				System.out.println(in.nextLine());
			}
			throw new RuntimeException();
		}

		return Integer.valueOf(resp);
	}
}
