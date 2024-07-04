import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int t = in.nextInt();
			StringBuilder r = null;
			final String IMPOSSIBLE = "IMPOSSIBLE";
			for (int i = 1; i <= t; ++i) {
				r = new StringBuilder();
				int n = in.nextInt();
				int s, e;
				ArrayList<Integer> js = new ArrayList<Integer>();
				ArrayList<Integer> je = new ArrayList<Integer>();
				ArrayList<Integer> cs = new ArrayList<Integer>();
				ArrayList<Integer> ce = new ArrayList<Integer>();
				for (int j = 0; j < n; ++j) {
					s = in.nextInt();
					e = in.nextInt();
					boolean jFree = true;
					boolean cFree = true;
					if (!js.isEmpty()) {
						for (int v = 0; v < js.size(); v++) {
							if ((js.get(v) < s && s < je.get(v)) || (js.get(v) < e && e < je.get(v))) {
								jFree = false;
							}
						}
						for (int vs = 0; vs < cs.size(); vs++) {
							if ((cs.get(vs) < s && s < ce.get(vs)) || (cs.get(vs) < e && e < ce.get(vs))) {
								cFree = false;
							}
						}
					}
					if (jFree) {
						js.add(s);
						je.add(e);
						r.append("J");
					} else if (cFree) {
						cs.add(s);
						ce.add(e);
						r.append("C");
					} else {
						r = new StringBuilder(IMPOSSIBLE);
					}
				}
				System.out.println("Case #" + i + ": " + r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}