import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int d;
		int times = input.nextInt();
		for (d = 0; d < times; d++) {

		System.out.print("Case #" + (d + 1) + ": ");
		boolean imp = false;
		int i;
		int j;
		int activitycount = input.nextInt();
// fixed
		int[][] fixedactivitytimes = new int[activitycount][2];
		for (i = 0; i < activitycount; i++) {
			fixedactivitytimes[i][0] = input.nextInt();
			fixedactivitytimes[i][1] = input.nextInt();
		}
// stuff that will change
		int[][] activitytimes = new int[activitycount][2];
		for (i = 0; i < activitycount; i++) {
			activitytimes[i][0] = fixedactivitytimes[i][0];
			activitytimes[i][1] = fixedactivitytimes[i][1];
		}
// make ascending
		for (i = 0; i < activitycount; i++) {
			for (j = i + 1; j < activitycount; j++) {
				if (activitytimes[i][0] > activitytimes[j][0] || (activitytimes[i][0] == activitytimes[j][0] && activitytimes[i][1] > activitytimes[j][1])) {
					int temp = activitytimes[i][0];
					activitytimes[i][0] = activitytimes[j][0];
					activitytimes[j][0] = temp;
					temp = activitytimes[i][1];
					activitytimes[i][1] = activitytimes[j][1];
					activitytimes[j][1] = temp;
				}
			}
		}
// all the times for the first person (Cameron) and turn those times into (-1, -1)
		int[][] firstactivitytimes = new int[activitycount][2];
		firstactivitytimes[0][0] = activitytimes[0][0];
		firstactivitytimes[0][1] = activitytimes[0][1];
		activitytimes[0][0] = -1;
		activitytimes[0][1] = -1;
		int count = 0;
		for (i = 1; i < activitycount; i++) {
			if (firstactivitytimes[count][1] <= activitytimes[i][0]) {
				firstactivitytimes[count + 1][0] = activitytimes[i][0];
				firstactivitytimes[count + 1][1] = activitytimes[i][1];
				activitytimes[i][0] = -1;
				activitytimes[i][1] = -1;
				count += 1;
			}
		}
		int count2 = 0;
		int[][] secondactivitytimes = new int[2][2];
		for (i = 0; i < activitycount; i++) {
			if (activitytimes[i][0] != -1) {
				if (count2 == 0) {
					secondactivitytimes[1][0] = activitytimes[i][0];
					secondactivitytimes[1][1] = activitytimes[i][1];
				}
				else {
					int temp2 = secondactivitytimes[1][0];
					secondactivitytimes[1][0] = activitytimes[i][0];
					secondactivitytimes[0][0] = temp2;
					temp2 = secondactivitytimes[1][1];
					secondactivitytimes[1][1] = activitytimes[i][1];
					secondactivitytimes[0][1] = temp2;
				}
			}
			count2 += 1;
			if (secondactivitytimes[0][1] > secondactivitytimes[1][0]) {
				imp = true;
				System.out.println("IMPOSSIBLE");
				break;
			}
		}
		if (imp)
			continue;
		for (i = 0; i < activitycount; i++) {
			boolean same = false;
			for (j = 0; j < activitycount; j++) {
				if (fixedactivitytimes[i][0] == activitytimes[j][0] && fixedactivitytimes[i][1] == activitytimes[j][1])
					same = true;
			}
			if (same)
				System.out.print("J");
			else
				System.out.print("C");
		}
		System.out.println();

		}
	}
}