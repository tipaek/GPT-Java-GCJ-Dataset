import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = Integer.parseInt(sc.nextLine());
		for (int testcase = 1; testcase <= testcases; testcase++) {
			int no_of_activities = Integer.parseInt(sc.nextLine());
			int[][] c = new int[no_of_activities][2];
			int[][] j = new int[no_of_activities][2];
			int countc = 0, countj = 0;
			String output = "";
			for (int i = 0; i < no_of_activities; i++) {
				String[] timeslot = sc.nextLine().split(" ");
				boolean r1 = false, r2 = false;
				int startTime = Integer.parseInt(timeslot[0]);
				int endTime = Integer.parseInt(timeslot[1]);
				for (int[] a : c) {
					if ((startTime > a[0] && startTime < a[1]) || (endTime > a[0] && endTime < a[1])) {
						r1 = true;
					}
				}
				if(!r1) {
					c[countc][0] = startTime;
					c[countc][1] = endTime;
					countc++;
					output+="C";
					continue;
				}
				if(r1 == true) {
					for (int[] a : j) {
						if ((startTime > a[0] && startTime < a[1]) || (endTime > a[0] && endTime < a[1])) {
							r2 = true;
						}
					}
					if(!r2) {
						j[countj][0] = startTime;
						j[countj][1] = endTime;
						countj++;
						output+="J";
						continue;
					}
					else {
						output = "IMPOSSIBLE";
						break;
					}
				}
				
			}
			System.out.println("Case #" + testcase + ": " + output);
		}
		sc.close();
	}
}
