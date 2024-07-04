import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		String tc = br.readLine();
		int testcases = Integer.parseInt(tc);

		for (int j = 0; j < testcases; j++) {
			tc = br.readLine();
			boolean isImpossible = false;
			int activities = Integer.parseInt(tc);
			Map<Integer, Integer> JTime = new HashMap<>();
			Map<Integer, Integer> CTime = new HashMap<>();

			String turns = "";
			for (int k = 0; k < activities; k++) {
				tc = br.readLine();
				boolean problemToJ = false;
				boolean problemToC = false;
				String[] time = tc.split("\\s+");
				int st = Integer.parseInt(time[0]);
				int et = Integer.parseInt(time[1]);

				if (JTime.isEmpty()) {
					JTime.put(st, et);
					turns += "J";
					continue;
				} else {
					for (Integer jStartTime : JTime.keySet()) {
						Integer JEndTime = JTime.get(jStartTime);
						if ((st >= jStartTime && st < JEndTime) || (et > jStartTime && et < JEndTime)) {
							problemToJ = true;
							break;
						}
					}
					if (!problemToJ) {
						JTime.put(st, et);
						turns += "J";
						continue;
					}
				}

				if (CTime.isEmpty()) {
					CTime.put(st, et);
					turns += "C";
					continue;
				} else {
					for (Integer cStartTime : CTime.keySet()) {
						Integer cEndTime = CTime.get(cStartTime);
						if ((st >= cStartTime && st < cEndTime) || (et > cStartTime && et < cEndTime)) {
							problemToC = true;
							break;
						}
					}
					if (!problemToC) {
						CTime.put(st, et);
						turns += "C";
						continue;
					}
				}
				isImpossible = true;
				break;
			}
			if (isImpossible)
				pw.println("Case #" + (j + 1) + ": IMPOSSIBLE");
			else
				pw.println("Case #" + (j + 1) + ": " + turns);
		}
		pw.close();
		br.close();
	}
}
