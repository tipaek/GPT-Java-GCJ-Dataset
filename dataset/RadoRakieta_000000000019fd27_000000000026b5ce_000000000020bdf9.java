import java.io.*;
import java.util.*;

public class Solution {

	public static final void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String firstLine = br.readLine();
		List<String> solutions = new ArrayList<>();
		if(firstLine != null && !firstLine.isEmpty()) {
			int cases = Integer.valueOf(firstLine);
			for (int i = 1; i <= cases; ++i) {
				StringBuilder answer = new StringBuilder();
				List<Integer> cameronTaskBegs = new ArrayList<>();
				List<Integer> cameronTaskEnds = new ArrayList<>();
				List<Integer> jamieTaskBegs = new ArrayList<>();
				List<Integer> jamieTaskEnds = new ArrayList<>();
				boolean isPossible = true;
				int tasks = Integer.valueOf(br.readLine());
				for (int j = 1; j <= tasks; j++) {
					String line = br.readLine();
					String[] times = line.split(" ");
					int lowerTime = Integer.valueOf(times[0]);
					int upperTime = Integer.valueOf(times[1]);
					boolean isAssignToCameron = isAssignToPerson(cameronTaskBegs, cameronTaskEnds, lowerTime, upperTime);
					if (isAssignToCameron) {
						answer.append('C');
						continue;
					}
					boolean isAssignToJamie = isAssignToPerson(jamieTaskBegs, jamieTaskEnds, lowerTime, upperTime);
					if (isAssignToJamie) {
						answer.append('J');
						continue;
					}
					isPossible = false;
					break;
				}
				if (isPossible) {
					solutions.add(answer.toString());
				} else {
					solutions.add("IMPOSSIBLE");
				}
			}
		}
		br.close();
		for (int i = 1; i <= solutions.size(); i++) {
			System.out.print("Case #" + i + ": " + solutions.get((i-1)));
			if(i != solutions.size()) {
				System.out.println();
			}
		}
	}

	private static boolean isAssignToPerson(List<Integer> personTaskBegs, List<Integer> personTaskEnds, int lowerTime,
			int upperTime) {
		boolean isAssign = true;
		for (int i = 0; i < personTaskBegs.size(); i++) {
			int a1 = personTaskBegs.get(i);
			int b1 = personTaskEnds.get(i);
			if (areOverlapping(a1, b1, lowerTime, upperTime)) {
				return false;
			}
		}
		personTaskBegs.add(lowerTime);
		personTaskEnds.add(upperTime);
		return isAssign;
	}

	private static boolean areOverlapping(int a1, int b1, int a2, int b2) {
		if ((Math.max(b1, b2) - Math.min(a1, a2)) < ((b1 - a1) + (b2 - a2))) {
			return true;
		}
		return false;
	}
}