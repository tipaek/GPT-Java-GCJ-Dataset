import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Activity {
	public int start, end;

	public Activity(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Activity [start=" + start + ", end=" + end + "]";
	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			ArrayList<String> output = new ArrayList<String>();
			List<Activity> al = new ArrayList<Activity>();
			int n, s, e, c_start, c_end, j_start, j_end;

			c_start = c_end = j_start = j_end = 200000;
			int t = sc.nextInt();
			String sb = "";

			if (t >= 1 && t <= 100) {

				for (int ca = 1; ca <= t; ca++) {

					sb = "";
					c_start = c_end = j_start = j_end = 200000;
					al.clear();

					n = sc.nextInt();
					if (2 <= n && n <= 10) {
						for (int i = 0; i < n; i++) {
							s = sc.nextInt();
							e = sc.nextInt();
							al.add(new Activity(s, e));
						}
						Activity ac = al.get(0);
						c_start = ac.start;
						c_end = ac.end;
						sb += "C";
						ac = al.get(1);
						if (!((ac.start >= c_start && ac.start < c_end) || (ac.end >= c_start && ac.end < c_end))) {
							c_start = ac.start;
							c_end = ac.end;
							sb += "C";
						} else {
							j_start = ac.start;
							j_end = ac.end;
							sb += "J";
						}
						for (int i = 2; i < al.size(); i++) {
							ac = al.get(i);
							if (!((ac.start >= c_start && ac.start < c_end) || (ac.end >= c_start && ac.end < c_end))) {
								c_start = ac.start;
								c_end = ac.end;
								sb += "C";
							} else if (!((ac.start >= j_start && ac.start < j_end)
									|| (ac.end >= j_start && ac.end < j_end))) {
								j_start = ac.start;
								j_end = ac.end;
								sb += "J";
							} else {
								sb = "IMPOSSIBLE";
								break;
							}
						}
//						System.out.println("Case #"+ca+": " + sb);
						output.add("Case #" + ca + ": " + sb);
					} else {
						output.add("Case #" + ca + ": IMPOSSIBLE" );
						// System.out.println("XXXXXX N OUT OF RANGE");
					}
				} // case loop

				for (String o : output) {
					System.out.println(o);
				}
			}
		} catch (Exception e) {

		} finally {
			sc.close();
		}

	}

}
