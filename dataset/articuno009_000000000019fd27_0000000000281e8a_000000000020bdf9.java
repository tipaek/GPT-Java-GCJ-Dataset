import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Interval {
	private int start;
	private int end;

	public Interval() {
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}

public class Solution {

	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);
		String y = in.nextLine();
		int T = Integer.parseInt(y);
		for (int i = 0; i < T; i++) {
			List<Interval> l = new ArrayList<>();
			Map<String, String> actualOrder = new LinkedHashMap<>();
			String yy = in.nextLine();
			int N = Integer.parseInt(yy);
			for (int j = 0; j < N; j++) {
				String z = in.nextLine();
				String[] zz = z.split(" ");
				Interval interval = new Interval();
				interval.setEnd(Integer.parseInt(zz[1]));
				interval.setStart(Integer.parseInt(zz[0]));
				l.add(interval);
				actualOrder.put(zz[0] + zz[1], zz[1]);
			}
			int cs = -1;
			int ce = -1;
			int js = -1;
			int je = -1;
			String r = "";

			l.sort(Comparator.comparing(Interval::getStart));

			for (Interval k : l) {
				if (cs == -1 || k.getStart() >= ce) {
					ce = k.getEnd();
					cs = k.getStart();
					String key = String.valueOf(cs) + String.valueOf(ce);
					actualOrder.put(key, "C");
				} else if (js == -1 || k.getStart() >= je) {
					je = k.getEnd();
					js = k.getStart();
					String key = String.valueOf(js) + String.valueOf(je);
					actualOrder.put(key, "J");
				} else {
					r = "IMPOSSIBLE";
					break;
				}
			}
			if (!r.equals("IMPOSSIBLE")) {
				for (String ll : actualOrder.keySet()) {
					r += actualOrder.get(ll);
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + r);
		}
		in.close();
	}
}
