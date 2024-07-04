import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int testCasesNumber = in.nextInt();
		in.nextLine();

		for (int i = 1; i <= testCasesNumber; i++) {
			int activitiesNumber = in.nextInt();
			int arraySize = activitiesNumber * 2;
			int[] tasks = new int[arraySize];

			for (int j = 0; j < activitiesNumber; j++) {
				tasks[2*j] = in.nextInt();
				tasks[2*j+1] = in.nextInt();
			}
			printSolution(tasks, i);
		}
	}

	private static void printSolution(int[] tasks, int i) {
		String parentAssignments = getParentAssignments(tasks);
		System.out.println("Case #" + i + ": " + parentAssignments);
	}

	private static String getParentAssignments(int[] tasks) {
		StringBuilder stringBuilder = new StringBuilder();
		
		//0 - free or nor. 0 for free, 1 for not
		//1 - end time
		int[] parentC = new int[2];
		parentC[0] = 0;
		
		int[] parentJ = new int[2];
		parentJ[0] = 0;
		
		for (int i = 0; i < tasks.length; i+=2) {
			if (tasks[i]  > parentC[1]) {
				parentC[1] = tasks[i+1];
				stringBuilder.append("C");
			} else if (tasks[i] > parentJ[1]) {
				parentJ[1] = tasks[i+1];
				stringBuilder.append("J");
			} else {
				return "IMPOSSIBLE";
			}
		}
		return stringBuilder.toString();
	}


}
