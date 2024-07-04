import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(scan.readLine());

		for (int i = 1; i <= t; i++) {
			SortedMap<Integer, Integer> sMap = new TreeMap<>();

			int n = Integer.parseInt(scan.readLine());

			while(n > 0) {
				String[] activities = scan.readLine().split(" ");
				sMap.put(Integer.parseInt(activities[0]), Integer.parseInt(activities[1]));
				n--;
			}

			StringBuilder sb = new StringBuilder();
			boolean imp = false;

			Map<String, Integer[]> JCMap = new HashMap<>();

			for(Map.Entry<Integer, Integer> entry : sMap.entrySet()) {
				int s = entry.getKey();
				int e = entry.getValue();

				if(JCMap.containsKey("J")) {
					Integer[] sej = JCMap.get("J");
					if(sej[0] < s && s < sej[1]) {
						if(JCMap.containsKey("C")) {
							Integer[] sec = JCMap.get("C");
							if(sec[0] < s && s < sec[1]) {
								imp = true;
								break;
							} else {
								sec[0] = s;
								sec[1] = e;
								JCMap.put("C",sec);
								sb.append("C");
							}
						} else {
							Integer[] sec = new Integer[2];
							sec[0] = s;
							sec[1] = e;
							JCMap.put("C",sec);
							sb.append("C");
						}
					} else {
						sej[0] = s;
						sej[1] = e;
						JCMap.put("J",sej);
						sb.append("J");
					}
				} else {
					Integer[] sej = new Integer[2];
					sej[0] = s;
					sej[1] = e;
					JCMap.put("J",sej);
					sb.append("J");
				}
			}

			if(imp) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + i + ": " + sb.toString());
			}
		}
	}
}
