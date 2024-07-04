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
				arr[i] = new Job(s, e, i);
			}
			
			StartTimeComp comparator = new StartTimeComp();
			Arrays.sort(arr, comparator);
			
			int Jstart = arr[0].start;
			int Jend = arr[0].end;
			arr[0].worker = 'J';
			int Cstart = 0;
			int Cend = 0;
			String x = "";
			
			
			for (int i = 1; i < arr.length; i++) {
				
				char worker = arr[i - 1].worker;
				
				if (arr[i - 1].end <= arr[i].start) {
					
					if (worker == 'J') {
						arr[i].worker = 'J';
						Jstart = arr[i].start;
						Jend = arr[i].end;
					} else {
						arr[i].worker = 'C';
						Cstart = arr[i].start;
						Cend = arr[i].end;
					}
				} else if (arr[i - 1].end > arr[i].start) {
					
					if (worker == 'J') {
						if (Cend <= arr[i].start) {
							arr[i].worker = 'C';
							Cstart = arr[i].start;
							Cend = arr[i].end;
						} else {
							x = "IMPOSSIBLE";
							break;
						}
					} else {
						if (Jend <= arr[i].start) {
							worker = 'J';
							arr[i].worker = 'J';
							Jstart = arr[i].start;
							Jend = arr[i].end;

						} else {
							x = "IMPOSSIBLE";
							break;
						}

					}
				}
			}

			IndexComp comparator1 = new IndexComp();
			Arrays.sort(arr, comparator1);
			
			if (x != "IMPOSSIBLE") {
				for(int i=0;i<n;i++) {
					x = x + arr[i].worker;
				}
			}
			
			System.out.println("Case #" + (a + 1) + ": " + x);
			a = a + 1;

		}

	}
}
class Job {
	int start;
	int end;
	char worker;
	int index;

	Job(int start, int end, int index) {
		this.start = start;
		this.end = end;
		this.index = index;
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

class IndexComp implements Comparator<Job> {
	@Override
	public int compare(Job o1, Job o2) {
		if (o1.index <= o2.index) {
			return -1;
		} else {
			return 1;
		}
	}
}