import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

















public class Solution {

	static int num[];

	static String nest() {

		StringBuilder st = new StringBuilder();

		int save = 0;
		int nest = 0;

		for (int i : num) {


			if (save < i && i != 0) {


				for (int j = i - nest; j > 0; j--) {
					st.append("(");
					nest++;
				}

				st.append(i);


				if (i > save)
					save = i;

			}


			else if (save > i) {

				for (int j = save - i; j > 0; j--) {
					st.append(")");
					nest--;
				}

				st.append(i);
				save = 0;
			} else {

				st.append(i);
			}
		}


		for (int j = nest; j > 0; j--) {
			st.append(")");
		}

		return st.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		int t = 1;
		while (T-- > 0) {
			String tempStr = br.readLine().trim();

			num = new int[tempStr.length()];

			for (int i = 0; i < tempStr.length(); i++) {
				num[i] = tempStr.charAt(i) - '0';
			}

			System.out.println("Case #" + t + ": " + nest());
			t++;
		}
	}
}
