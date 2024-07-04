
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			int n = 0, s = 0, e = 0;
			String data[] = null;
			StringBuilder result = new StringBuilder();
			boolean cameron[] = null, jamie[] = null, isjamieTried = false;
			for (int i = 1; i <= t; i++) {
				cameron = new boolean[1450];
				jamie = new boolean[1450];
				n = Integer.parseInt(br.readLine());
				result = result.delete(0, result.capacity());
				for (int j = 0; j < n; j++) {
					data = br.readLine().split(" ");
					s = Integer.parseInt(data[0]);
					e = Integer.parseInt(data[1]);
					isjamieTried = false;
					for (int k = s; k <= e; k++) {
						if (result.toString().equals("IMPOSSIBLE")) {
							break;
						}
						if (!cameron[k]) {
							cameron[k] = true;
						}
						if (cameron[k] && cameron[k + 1]) {
							for (int m = s; m <= k; m++) {
								cameron[m] = false;
							}

							isjamieTried = true;
							for (int l = s; l <= e; l++) {
								if (result.toString().equals("IMPOSSIBLE")) {
									break;
								}
								if (!jamie[l]) {
									jamie[l] = true;
								}
								if (jamie[l] && jamie[l + 1]) {
									result = result.delete(0, result.capacity());
									result.append("IMPOSSIBLE");
								}
							}
							if (result.toString().equals("IMPOSSIBLE")) {
								break;
							}
							if (!result.toString().equals("IMPOSSIBLE")) {
								result.append("J");
								break;
							}

						}
					}
					if (!isjamieTried) {
						result.append("C");
					}
				}
				System.out.println("Case #" + i + ": " + result.toString());
				result = result.delete(0, result.capacity());
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
