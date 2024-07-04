
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;






public class Solution {

	static int N, K;
	static ArrayList<Integer> arr, ansArr;

	static void indic() {

		StringBuilder sb;

		if (ansArr.contains(K)) {
			System.out.println("POSSIBLE");

			int index = ansArr.indexOf(K)+1;
			int temp;

			for (int j = 0; j < N; j++) {
				sb = new StringBuilder();
				for (int i = 0; i < N; i++) {

					if (index + i > N) {
						temp = index + i - N;
						sb.append(temp + " ");

					} else {
						temp = index + i;
						sb.append(temp + " ");
					}
				}
				index--;
				if (index <= 0) {
					index += N;
				}

				System.out.println(sb.toString());
			}
		} else

		{
			System.out.println("IMPOSSIBLE");
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		int t = 1;
		while (T-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine().trim());

			N = Integer.parseInt(st.nextToken().trim());

			K = Integer.parseInt(st.nextToken().trim());

			arr = new ArrayList<>();
			ansArr = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				arr.add(i + 1);
				ansArr.add((i + 1) * N);
			}

			System.out.print("Case #" + t + ": ");

			indic();

			t++;
		}

	}
}
