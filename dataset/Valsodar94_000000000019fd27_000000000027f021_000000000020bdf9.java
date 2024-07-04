import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Solution  {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCasesNumber = in.nextInt();
		ArrayList<ArrayList<Task>> testCases = new ArrayList<ArrayList<Task>>();
		for (int i = 0; i < testCasesNumber; i++) {
			ArrayList<Task> testCase = new ArrayList<>();
			int activitiesCount = in.nextInt();
			for(int ind = 0; ind < activitiesCount * 2; ind += 2) {
				Task task = new Task();
				int start = in.nextInt();
				int end = in.nextInt();
				task.startTime = start;
				task.endTime = end;
				testCase.add(task);
			}
			testCases.add(testCase);
		}
		for(ArrayList<Task> tasks: testCases) {
			Collections.sort(tasks);
		}
		int testCaseCounter = 1;
		for(ArrayList<Task> testCase: testCases) {
			int cActivityEnd = 0;
			int jActivityEnd = 0;
			String solution = "";
			boolean possible = true;
			for(int i =0; i < testCase.size(); i++) {
				if(cActivityEnd <= testCase.get(i).startTime) {
					cActivityEnd = testCase.get(i).endTime;
					solution += "C";
				} else {
					if(jActivityEnd <= testCase.get(i).startTime) {
						jActivityEnd = testCase.get(i).endTime;
						solution += "J";
					} else {
						possible = false;
						break;
					}
				}
			}
			if(possible) {
				System.out.println("Case #" + testCaseCounter + ": " + solution);
			} else {
				System.out.println("Case #" + testCaseCounter + ": IMPOSSIBLE");
			}
			testCaseCounter++;
		}
	}
}

class Task implements Comparable<Task>{
	int startTime;
	int endTime;

	@Override
	public int compareTo(Task o) {
		return this.endTime > o.endTime ? 1: this.endTime < o.endTime ? -1 : 0;
	}
}