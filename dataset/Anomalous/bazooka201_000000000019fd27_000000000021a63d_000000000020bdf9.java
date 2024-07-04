import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            scanner.nextLine();

            ArrayList<int[]> cSchedule = new ArrayList<>();
            ArrayList<int[]> jSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int start = startTimes[i];
                int end = endTimes[i];
                boolean canAssignToC = true;
                boolean canAssignToJ = true;

                for (int[] time : cSchedule) {
                    if (!(end <= time[0] || start >= time[1])) {
                        canAssignToC = false;
                        break;
                    }
                }

                for (int[] time : jSchedule) {
                    if (!(end <= time[0] || start >= time[1])) {
                        canAssignToJ = false;
                        break;
                    }
                }

                if (canAssignToC) {
                    cSchedule.add(new int[]{start, end});
                    result.append("C");
                } else if (canAssignToJ) {
                    jSchedule.add(new int[]{start, end});
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}