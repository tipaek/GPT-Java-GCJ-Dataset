
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.stream.events.EndElement;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfTC = sc.nextInt();

		for (int tcI = 0; tcI < numberOfTC; tcI++) {
			int numOfAct = sc.nextInt();
			boolean isImp = false;
			List<Integer[]> cSlots = new ArrayList<Integer[]>();
			List<Integer[]> jSlots = new ArrayList<Integer[]>();
			String schedule = "";
			for (int aC = 0; aC < numOfAct; aC++) {
				int acStart = sc.nextInt();
				int acEnd = sc.nextInt();

				if (isAvailable(cSlots, acStart, acEnd)) {
					Integer[] slotArr = new Integer[2];
					slotArr[0] = acStart;
					slotArr[1] = acEnd;
					cSlots.add(slotArr);
					schedule += "C";
				} else if (isAvailable(jSlots, acStart, acEnd)) {
					Integer[] slotArr = new Integer[2];
					slotArr[0] = acStart;
					slotArr[1] = acEnd;
					jSlots.add(slotArr);
					schedule += "J";
				} else {
					isImp = true;
				}
			}

			if (isImp) {
				System.out.println(String.format("Case #%d: %s", (tcI + 1), "IMPOSSIBLE"));
			} else {
				System.out.println(String.format("Case #%d: %s", (tcI + 1), schedule));
			}

//			System.out.println(String.format("Case #%d: %s", (tcI + 1), ansStr));

		}
		sc.close();

	}

	private static boolean isAvailable(List<Integer[]> cSlots, int entStart, int entEnd) {
		for (Integer[] slot : cSlots) {

			int start = slot[0];
			int end = slot[1];

//			System.out.println("\n\n" + start + " <=> " + end);
//			System.out.println(entStart + " <=ENT=> " + entEnd);

			if (entStart > start && entStart < end) {
				return false;
			}

			if (entEnd > start && entEnd < end) {
				return false;
			}

			if (start > entStart && start < entStart) {
				return false;
			}

			if (end > entStart && end < entStart) {
				return false;
			}
			
			if(entStart == start && entEnd == end) {
				return false;
			}

		}
		return true;
	}
}