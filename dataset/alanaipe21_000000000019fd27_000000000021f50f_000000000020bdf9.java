import java.util.Scanner;
import java.util.Arrays;
class Task {
	int id,start,end;
	String worker;
	public Task(int idno, int starttime, int endtime) {
		id = idno;
		start = starttime;
		end = endtime;
		worker = null;
	}
	public void assignWorker(String workerId) {
		worker = workerId;
	}
	public void print() {
		System.out.println("Start : "+ start + ", End :" + end); 
	}
}
public class Solution {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testcase = in.nextInt();
		in.nextLine();
		for (int i = 0; i < testcase; i++) {
			int n = in.nextInt();
			in.nextLine();
			String output = "";
			Task[] tasks = new Task[n];
			for (int j = 0; j < n; j++) {
				tasks[j] = new Task(j, in.nextInt(), in.nextInt());
				in.nextLine();
			}
			Arrays.sort(tasks, (first, second) -> {
				return first.start - second.start;
			});
			boolean isCWorking = false, isJWorking = false;
			int endTimeC = -1, endTimeJ = -1;
			for (Task t: tasks) {
				if (!isCWorking && !isJWorking) {
					isCWorking = true;
					endTimeC = t.end;
					t.assignWorker("C");
				} else if (isCWorking && isJWorking) {
					String nextWorker = (endTimeC <= t.start)? "C" : ((endTimeJ <= t.start)? "J" : null);
					if (nextWorker != null) {
						if(nextWorker.equals("C")) {
							endTimeC = t.end;
							t.assignWorker("C");
						} else {
							endTimeJ = t.end;
							t.assignWorker("J");;
						}
					} else {
						output = "IMPOSSIBLE";
						break;
					}
				} else if (isCWorking) {
					isJWorking = true;
					endTimeJ = t.end;
					t.assignWorker("J");;
				} else {
					isCWorking = true;
					endTimeC = t.end;
					t.assignWorker("C");
				}

			}
			Arrays.sort(tasks, (first, second) -> {
				return first.id - second.id;
			});
			if (!output.equals("IMPOSSIBLE")) {
				for (Task t: tasks) {
					output += t.worker;
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + output);
		}
	}
}