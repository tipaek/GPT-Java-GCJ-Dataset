import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		loop: for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			String[][] ps = new String[N][2];
			ArrayList<String> starts = new ArrayList<String>();
			ArrayList<String> ends = new ArrayList<String>();
			for (int j = 0; j < N; j++) {
				ps[j] = br.readLine().split("\\*");
				starts.add(ps[j][0]);
				if (ps[j].length > 1) {
					ends.add(ps[j][1]);
				}
			}

			starts.sort(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return -Integer.compare(o1.length(), o2.length());
				}

			});
			ends.sort(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return -Integer.compare(o1.length(), o2.length());
				}

			});
			//System.out.println(Arrays.deepToString(ps));
			// check starts
			String bigstart = starts.get(0);
			for (int j = 1; j < starts.size(); j++) {
				if (bigstart.startsWith(starts.get(j))) {
					continue;
				} else {
					System.out.println("Case #" + (i+1)+": *");
					continue loop;
				}
			}
			String bigend = ends.get(0);
			for (int j = 1; j < ends.size(); j++) {
				if (bigend.endsWith(ends.get(j))) {
					continue;
				} else {
					System.out.println("Case #" + (i+1)+": *");
					continue loop;
				}
			}
			System.out.println("Case #"+(i+1)+": "+(bigstart+bigend));
		}
	}

}
