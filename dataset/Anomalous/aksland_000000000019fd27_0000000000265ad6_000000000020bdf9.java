import java.util.Scanner;

public class Solution {

    static int[][] events;
    static boolean[] path;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tCases = sc.nextInt();

        for (int i = 0; i < tCases; i++) {
            int nActivities = sc.nextInt();
            events = new int[nActivities][2];
            path = new boolean[nActivities];

            for (int j = 0; j < nActivities; j++) {
                events[j][0] = sc.nextInt();
                events[j][1] = sc.nextInt();
            }

            System.out.print("Case #" + (i + 1) + ": ");

            if (assignActivities(0)) {
                StringBuilder result = new StringBuilder();
                for (boolean assignedToC : path) {
                    result.append(assignedToC ? 'C' : 'J');
                }
                System.out.println(result.toString());
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static boolean assignActivities(int current) {
        if (current == path.length) return true;

        boolean canAssignToC = true;
        boolean canAssignToJ = true;

        for (int i = 0; i < current; i++) {
            if (events[i][1] > events[current][0] && events[current][1] > events[i][0]) {
                if (path[i]) {
                    canAssignToC = false;
                } else {
                    canAssignToJ = false;
                }
            }
        }

        if (canAssignToC) {
            path[current] = true;
            if (assignActivities(current + 1)) {
                return true;
            }
            path[current] = false;
        }

        if (canAssignToJ) {
            return assignActivities(current + 1);
        }

        return false;
    }
}