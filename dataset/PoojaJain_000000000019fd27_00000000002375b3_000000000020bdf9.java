
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int noOfTestCases = in.nextInt();
		StringBuilder finalAns = new StringBuilder();

		for (int i = 0; i < noOfTestCases; i++) {

			StringBuilder ans = new StringBuilder();
			int noOfTasks = in.nextInt();
			int[] cameron = new int[1441];
			int[] jamie = new int[1441];

			for (int j = 0; j < noOfTasks; j++) {
				int startTime = in.nextInt();
				int endTime = in.nextInt();

				String TaskAssignedTo = new String();

				boolean camBusy = false, taskAssigned = false, jamieBusy = false;
				int[] temp = new int[1441];

				for (int k = startTime+1; k <= endTime; k++) {
					if (cameron[k] == 1) {
						camBusy = true;
						temp = new int[1441];
						break;
					} else {
						temp[k] = 1;
					}
				}
				if (!camBusy) {
					for(int p =0;p<1441;p++){
						if(temp[p] ==1) cameron[p]=1;
					}
					temp = new int[1441];
					taskAssigned = true;
					TaskAssignedTo = "C";
				} else {

					for (int k = startTime+1; k <= endTime; k++) {
						if (jamie[k] == 1) {
							jamieBusy = true;
							temp = new int[1441];
							break;
						} else {
							temp[k] = 1;
						}
					}

					if (!jamieBusy) {
						for(int p =0;p<1441;p++){
							if(temp[p] ==1) jamie[p]=1;
						}
						temp = new int[1441];
						taskAssigned = true;
						TaskAssignedTo = "J";
					} else {
						taskAssigned = false;
					}

				}

				if (taskAssigned) {
					ans.append(TaskAssignedTo);
				} else {
					ans = new StringBuilder();
					ans.append("IMPOSSIBLE");
				}

			}

			finalAns.append("Case #" + (i + 1) + ": " + ans.toString().trim());
			finalAns.append('\n');
		}

		System.out.println(finalAns.toString().trim());
		in.close();
	}
}
