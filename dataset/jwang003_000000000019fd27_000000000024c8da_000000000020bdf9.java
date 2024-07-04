import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        //read number of cases
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            //read number of activities
            int activityNum = in.nextInt();
            //discard line
            in.nextLine();
            //create 2d array for start and end times of each interval
            int[][] times = new int[activityNum][2];
            String[] activities = new String[activityNum];
            for (int j = 0; j < activityNum; j++) {
                String[] startEnd = in.nextLine().split(" ");
                times[j][0] = Integer.parseInt(startEnd[0]);
                times[j][1] = Integer.parseInt(startEnd[1]);
            }
            boolean[][] parents = new boolean[2][1440];
            boolean possible = true;
            //check if C works
            for (int j = 0; j < activityNum; j++) {
                boolean free = true;
                for (int k = times[j][0]; k < times[j][1]; k++) {
                    if (parents[0][k]) {
                        free = false;
                        break;
                    }
                }
                if (free) {
                    activities[j] = "C";
                    for (int k = times[j][0]; k < times[j][1]; k++) {
                        parents[0][k] = true;
                    }
                } else {
                    //C doesn't work, check J
                    free = true;
                    for (int k = times[j][0]; k < times[j][1]; k++) {
                        if (parents[1][k]) {
                            free = false;
                            break;
                        }
                    }
                    if (free) {
                        activities[j] = "J";
                        for (int k = times[j][0]; k < times[j][1]; k++) {
                            parents[1][k] = true;
                        }
                    } else {
                        //If C and J don't work, it is impossible
                        possible = false;
                        break;
                    }
                }
            }

            StringBuilder order = new StringBuilder();
            int caseNum = i + 1;

            if (possible) {
                for (String name : activities) {
                    order.append(name);
                }
                System.out.println("Case #" + caseNum + ": " + order.toString());
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }
}
