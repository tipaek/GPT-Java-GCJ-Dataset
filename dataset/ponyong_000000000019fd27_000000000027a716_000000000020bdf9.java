import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int[][] times = new int[N][3];
			StringTokenizer str;
			for (int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine());
				times[i][0] = Integer.parseInt(str.nextToken());
				times[i][1] = Integer.parseInt(str.nextToken());
				times[i][2] = i;
			}

			Arrays.sort(times, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] <= o2[0] ? -1 : 1;
				}
			});
			ArrayList<int[]> list = new ArrayList<int[]>();
			int roomCnt = 0;
			int[] result = new int[N];
			list.add(new int[] { times[0][1], times[0][2], ++roomCnt });
			for (int i = 1; i < times.length; i++) {
				boolean flag = false;
				for (int j = 0; j < list.size(); j++) { // ํ์ฌ ์๋ ๋ฐฉ๋ค ๋ณด๋ฉด์ ๋ค์ด๊ฐ ์ ์๋์ง
					if (list.get(j)[0] <= times[i][0]) { // ๋ค์ด๊ฐ ์ ์์
						int idx = list.get(j)[1];
						int roomNumber = list.get(j)[2];
						result[idx] = roomNumber;
						list.set(j, new int[] { times[i][1], times[i][2], roomNumber }); // ๊ธฐ์กด ๋ฐฉ์ ์๋ก์ด ๋ฐ์ดํฐ ๋ค์ง์ด์์
						flag = true;
						break;
					}
				}
				if (!flag) { // ์๋ฌด ๊ณณ๋ ๋ค์ด๊ฐ ์ ์์ผ๋ ์๋ก์ด ๋ฐฉ ๋ง๋ค๊ธฐ
					list.add(new int[] { times[i][1], times[i][2], ++roomCnt });
				}
			}
			for (int j = 0; j < list.size(); j++) {
				int IDX = list.get(j)[1]; // ํ์ฌ ๋ฐฉ์ ์๋ ์ ์ ์๋ INDEX
				int roomNumber = list.get(j)[2];
				result[IDX] = roomNumber;
			}
			if (list.size() > 2)
				System.out.println("Case #" + tc + ": " + "IMPOSSIBLE");
			else {
				System.out.print("Case #" + tc + ": ");
				for (int i = 0; i < N; i++) {
					if (result[i] == 1)
						System.out.print("J");
					else
						System.out.print("C");
				}
				System.out.println();
			}

		}

	}
}
