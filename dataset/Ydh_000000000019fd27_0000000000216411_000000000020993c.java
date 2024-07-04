
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();

		int tc = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= tc; test_case++) {
			sb.append("Case #");
			sb.append(test_case);
			sb.append(": ");

			int size = Integer.parseInt(bf.readLine());
			int board[][] = new int[size][size];
			int k = 0;
			int r = 0;
			int c = 0;
			for (int i = 0; i < size; i++) {
				st = new StringTokenizer(bf.readLine());

				for (int j = 0; j < size; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}

			}

			for (int i = 0; i < size; i++) {
				k += board[i][i];

				boolean[] checkR = new boolean[size+1];
				boolean[] checkC = new boolean[size+1];

				boolean resultR = false;
				boolean resultC = false;

				for (int j = 0; j < size; j++) {
					if (!checkR[board[i][j]]) {
						checkR[board[i][j]] = true;
					} else {
						resultR = true;
					}
					
					if (!checkC[board[j][i]]) {
						checkC[board[j][i]] = true;
					} else {
						resultC = true;
					}

				}

				if (resultR)
					r++;
				if (resultC)
					c++;

			}

			sb.append(k);
			sb.append(' ');
			sb.append(r);
			sb.append(' ');
			sb.append(c);
			sb.append(' ');
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
