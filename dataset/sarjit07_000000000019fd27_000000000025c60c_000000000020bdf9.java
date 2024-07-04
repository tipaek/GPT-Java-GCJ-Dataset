import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int a = 0;
		while (a < t) {

			int n = in.nextInt();
			int s;
			int e;
			Job arr[] = new Job[n];
			for (int i = 0; i < n; i++) {
				s = in.nextInt();
				e = in.nextInt();
				arr[i] = new Job(s, e);
			}

			StartTimeComp comparator = new StartTimeComp();
			Arrays.sort(arr, comparator);
			String newStr = "J";
			int Jstart = arr[0].start;
			int Jend = arr[0].end;
			int Cstart = 0;
			int Cend = 0;

			for (int i = 1; i < arr.length; i++) {
				if (arr[i - 1].end <= arr[i].start) {
					char worker = newStr.charAt(newStr.length() - 1);
					newStr = newStr + worker;
					if (worker == 'J') {
						Jstart = arr[i].start;
						Jend = arr[i].end;
					} else {
						Cstart = arr[i].start;
						Cend = arr[i].end;
					}
				} else if (arr[i - 1].end > arr[i].start) {
					char worker = newStr.charAt(newStr.length() - 1);
					if (worker == 'J') {
						if (Cend <= arr[i].start) {
							worker = 'C';
							Cstart = arr[i].start;
							Cend = arr[i].end;
							// newStr = newStr + 'C';
						} else {
							newStr = "IMPOSSIBLE";
							break;
						}
					} else {
						if (Jend <= arr[i].start) {
							worker = 'J';
							Jstart = arr[i].start;
							Jend = arr[i].end;
							// newStr = newStr + 'J';

						} else {
							newStr = "IMPOSSIBLE";
							break;
						}

					}
					newStr = newStr + worker;
					if (worker == 'J') {
						Jstart = arr[i].start;
						Jend = arr[i].end;
					} else {
						Cstart = arr[i].start;
						Cend = arr[i].end;
					}
				}
			}

			System.out.println("Case #" + (a + 1) + ": " + newStr);
			a = a + 1;

		}

	}
}
class Job {
	int start;
	int end;

	Job(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

class StartTimeComp implements Comparator<Job> {
	@Override
	public int compare(Job o1, Job o2) {
		if (o1.start <= o2.start) {
			return -1;
		} else {
			return 1;
		}
	}
}