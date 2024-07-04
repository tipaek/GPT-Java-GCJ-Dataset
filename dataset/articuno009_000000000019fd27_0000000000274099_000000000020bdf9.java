import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);
		String y = in.nextLine();
		int T = Integer.parseInt(y);
		for (int i = 0; i < T; i++) {
			Map<Integer, Integer> map = new TreeMap<>();
			Map<Integer, String> actual = new LinkedHashMap<>();
			String yy = in.nextLine();
			int N = Integer.parseInt(yy);
			for (int j = 0; j < N; j++) {
				String z = in.nextLine();
				String[] zz = z.split(" ");
				map.put(Integer.parseInt(zz[0]), Integer.parseInt(zz[1]));
				actual.put(Integer.parseInt(zz[0]), zz[1]);
			}
			int cs = -1;
			int ce = -1;
			int js = -1;
			int je = -1;
			String r = "";
			for (int k : map.keySet()) {
				if (cs == -1 || k >= ce) {
					ce = map.get(k);
					cs = k;
					actual.put(k, "C");
				} else if (js == -1 || k >= je) {
					je = map.get(k);
					js = k;
					actual.put(k, "J");
				} else {
					r = "IMPOSSIBLE";
					break;
				}
			}
			if (!r.equals("IMPOSSIBLE")) {
				for (int l : actual.keySet()) {
					r += actual.get(l);
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + r);
		}
		in.close();
	}
}
