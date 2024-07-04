import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            int activityNum = in.nextInt();
            in.nextLine();
            int[][] times = new int[activityNum][2];
            String[] activities = new String[activityNum];
            for (int j = 0; j < activityNum; j++) {
                String[] startEnd = in.nextLine().split(" ");
                times[j][0] = Integer.parseInt(startEnd[0]);
                times[j][1] = Integer.parseInt(startEnd[1]);
            }
            String[][] parents = new String[2][1440];
            for (int j = 0; j < activityNum; j++) {
                boolean free = true;
                for (int k = times[j][0]; k < times[j][1]; k++) {
                    if (parents[0][k] != null) {
                        free = false;
                        break;
                    }
                }
                if (free) {
                    activities[j] = "J";
                    for (int k = times[j][0]; k < times[j][1]; k++) {
                        parents[0][k] = "J";
                    }
                } else {
                    activities[j] = "N";
                }
            }
            StringBuilder order = new StringBuilder();
            boolean possible = true;
            for (int j = 0; j < activityNum; j++) {
                if (activities[j].equals("N")) {
                    boolean free = true;
                    for (int k = times[j][0]; k < times[j][1]; k++) {
                        if (parents[1][k] != null) {
                            free = false;
                            break;
                        }
                    }
                    if (free) {
                        activities[j] = "C";
                        for (int k = times[j][0]; k < times[j][1]; k++) {
                            parents[1][k] = "C";
                        }
                    } else {
                        possible = false;
                        break;
                    }
                }
            }

            if (possible) {
                for (int j = 0; j < activityNum; j++) {
                    order.append(activities[j]);
                }
                int caseNum = i + 1;
                System.out.println("Case #" + caseNum + ": " + order.toString());
            } else {
                int caseNum = i + 1;
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }
}
