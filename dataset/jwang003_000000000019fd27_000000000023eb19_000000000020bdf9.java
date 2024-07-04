import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();

        for (int i = 0; i < c; i++) {
            int a = in.nextInt();
            in.nextLine();
            int[][] events = new int[a][2];
            String[] activities = new String[a];
            for (int j = 0; j < a; j++) {
                String[] startEnd = in.nextLine().split(" ");
                events[j][0] = Integer.parseInt(startEnd[0]);
                events[j][1] = Integer.parseInt(startEnd[1]);
            }
            String[][] parents = new String[2][1441];
            for (int j = 0; j < a; j++) {
                boolean free = true;
                for (int k = events[j][0]+1; k < events[j][1]; k++) {
                    if (parents[0][k] != null) {
                        free = false;
                        break;
                    }
                }
                if (free) {
                    activities[j] = "J";
                    for (int k = events[j][0]; k <= events[j][1]; k++) {
                        parents[0][k] = "J";
                    }
                } else {
                    activities[j] = "N";
                }
            }
            StringBuilder order = new StringBuilder();
            boolean possible = true;
            for (int j = 0; j < a; j++) {
                if (activities[j].equals("N")) {
                    boolean free = true;
                    for (int k = events[j][0]+1; k < events[j][1]; k++) {
                        if (parents[1][k] != null) {
                            free = false;
                            break;
                        }
                    }
                    if (free) {
                        activities[j] = "C";
                        for (int k = events[j][0]; k <= events[j][1]; k++) {
                            parents[1][k] = "C";
                        }
                    } else {
                        possible = false;
                        break;
                    }
                }
            }

            if (possible) {
                for (int j = 0; j < a; j++) {
                    order.append(activities[j]);
                }
            } else {
                order.setLength(0);
                order.append("IMPOSSIBLE");
            }
            int caseNum = i + 1;
            System.out.println("Case #" + caseNum + ": " + order);
        }
    }
}
