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
		int B = in.nextInt();

		for (int t = 1; t <= nbTests; t++) {

			int[] arr = new int[B + 1];

			int c = 1;
			int q = 1;

			while (c <= B / 2) {
				int n0 = -1;
				int n1 = -1;

				if (q % 10 != 1 || q == 1) {
					out.println(c);
					out.flush();

					String resp = getResponse("N");
					arr[c] = Integer.valueOf(resp);

					out.println(B + 1 - c);
					out.flush();

					resp = getResponse("N");
					arr[B + 1 - c] = Integer.valueOf(resp);

					c++;
					q += 2;

				} else {

					int v0 = -1;
					int v1 = -1;

					for (int i = 1; i < c; i++) {
						if (n0 < 0 && arr[i] == arr[B + 1 - i]) {
							n0 = i;
							out.println(i);
							out.flush();

							String resp = getResponse("N");
							v0 = Integer.valueOf(resp);

							q++;
						} else if (n1 < 0 && arr[i] != arr[B + 1 - i]) {
							n1 = i;
							out.println(i);
							out.flush();

							String resp = getResponse("N");
							v1 = Integer.valueOf(resp);

							q++;
						}

						if (n0 > 0 && n1 > 0) {
							break;
						}
					}

					if (n0 < 0 || n1 < 0) {
						out.println(1);
						out.flush();
						getResponse("N");

						q++;
					}

					if (n0 > 0 && n1 > 0) {
						if (arr[n0] != v0 && arr[n1] != v1) {
							for (int i = 1; i < B + 1; i++) {
								arr[i] = arr[i] == 0 ? 1 : 0;
							}
						} else if (arr[n0] == v0 && arr[n1] != v1) {
							for (int i = 1; i <= (B + 1) / 2; i++) {
								int tmp = arr[i];
								arr[i] = arr[B + 1 - i];
								arr[B + 1 - i] = tmp;
							}
						} else if (arr[n0] != v0 && arr[n1] == v1) {
							for (int i = 1; i <= (B + 1) / 2; i++) {
								int tmp = arr[i];
								arr[i] = arr[B + 1 - i];
								arr[B + 1 - i] = tmp;
							}
							for (int i = 1; i < B + 1; i++) {
								arr[i] = arr[i] == 0 ? 1 : 0;
							}
						}
					} else if (n1 < 0) {
						if (arr[n0] != v0) {
							for (int i = 1; i < B + 1; i++) {
								arr[i] = arr[i] == 0 ? 1 : 0;
							}
						}
					} else if (n0 < 0) {
						if (arr[n1] != v1) {
							for (int i = 1; i < B + 1; i++) {
								arr[i] = arr[i] == 0 ? 1 : 0;
							}
						}
					}
				}
			}

			StringBuilder res = new StringBuilder();
			for (int i = 1; i < B + 1; i++) {
				res.append(arr[i]);
			}
			out.println(res);
			out.flush();

			getResponse("N");
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
