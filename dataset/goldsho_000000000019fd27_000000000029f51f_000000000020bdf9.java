import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(scan.readLine());

		for (int i = 1; i <= t; i++) {
			boolean imp = false;
			StringBuilder sb = new StringBuilder();
			Map<String, int[]> jcMap = new HashMap<>();

			int n = Integer.parseInt(scan.readLine());
			while (n > 0) {
				n--;
				String[] act = scan.readLine().split(" ");

				int s = Integer.parseInt(act[0]);
				int e = Integer.parseInt(act[1]);

				if(jcMap.containsKey("J")) {
					int[] _sej = jcMap.get("J");
					if((_sej[0] <= s && s < _sej[1]) || (_sej[0] <= e && e < _sej[1])) {
						if(jcMap.containsKey("C")) {
							int[] _sec = jcMap.get("C");
							if((_sec[0] <= s && s < _sec[1]) || (_sec[0] <= e && e < _sec[1])) {
								imp = true;
							}else{
								int[] sec = new int[2];
								sec[0] = s;
								sec[1] = e;
								jcMap.put("C",sec);
								sb.append("C");
							}
						} else {
							int[] sec = new int[2];
							sec[0] = s;
							sec[1] = e;
							jcMap.put("C",sec);
							sb.append("C");
						}
					} else {
						int[] sej = new int[2];
						sej[0] = s;
						sej[1] = e;
						jcMap.put("J",sej);
						sb.append("J");
					}
				} else {
					int[] sej = new int[2];
					sej[0] = s;
					sej[1] = e;
					jcMap.put("J",sej);
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
