
import java.util.Arrays;
import java.util.Scanner;

class Solution {
	static class Scheduler {
	int start, end, originalIndex;
	char assigne;
	boolean visited;
}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int caseNo = 1;
		while (t-- > 0) {
			int n = sc.nextInt();

			Scheduler[] arr = new Scheduler[n];

			for (int i = 0; i < n; i++) {
				arr[i] = new Scheduler();
				arr[i].start = sc.nextInt();
				arr[i].end = sc.nextInt();
				arr[i].originalIndex = i;
				arr[i].visited = false;
			}

			Arrays.sort(arr, (s1, s2) -> s1.start - s2.start);

			int cLastEndTime = 0;

			for (int i = 0; i < n; i++) {
				if (i == 0 || arr[i].start >= cLastEndTime) {
					arr[i].assigne = 'C';
					arr[i].visited = true;

					cLastEndTime = arr[i].end;
				}
			}

			int jLastEndTime = 0;

			boolean jPreviouslyAssigned = false;

			for (int j = 1; j < n; j++) {

				if (!jPreviouslyAssigned && !arr[j].visited) {
					arr[j].assigne = 'J';
					arr[j].visited = true;
					jLastEndTime = arr[j].end;
					jPreviouslyAssigned = true;
					
				} else if (!arr[j].visited && arr[j].start >= jLastEndTime) {
					arr[j].assigne = 'J';
					arr[j].visited = true;
					jLastEndTime = arr[j].end;
				} else if (!arr[j].visited) {
					break;
				}
			}
			boolean isSolutionNotPossible = false;

			for (int k = 0; k < n; k++) {
				if (!arr[k].visited) {
					isSolutionNotPossible = true;
					break;
				}
			}

			if (isSolutionNotPossible) {
				System.out.println("Case #" + caseNo++ + ": IMPOSSIBLE");
			} else {
				Arrays.sort(arr, (s1, s2) -> s1.originalIndex - s2.originalIndex);

				System.out.print("Case #" + caseNo++ + ": ");
				for (int k = 0; k < n; k++) {
					System.out.print(arr[k].assigne);
				}
				System.out.println();
			}
		}

	}
}