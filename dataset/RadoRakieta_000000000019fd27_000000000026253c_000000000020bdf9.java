import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int cases = scanner.nextInt();
		for (int i = 1; i <= cases; ++i) {
			StringBuilder answer = new StringBuilder();
			List<Integer> cameronTaskBegs = new ArrayList<>();
			List<Integer> cameronTaskEnds = new ArrayList<>();
			List<Integer> jamieTaskBegs = new ArrayList<>();
			List<Integer> jamieTaskEnds = new ArrayList<>();
			boolean isPossible = true;
			int tasks = scanner.nextInt();
			for (int j = 1; j <= tasks; j++) {
				int lowerTime = scanner.nextInt();
				int upperTime = scanner.nextInt();
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
				System.out.println("Case #" + i + ": " + answer.toString());
			} else {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			}
		}
		scanner.close();
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