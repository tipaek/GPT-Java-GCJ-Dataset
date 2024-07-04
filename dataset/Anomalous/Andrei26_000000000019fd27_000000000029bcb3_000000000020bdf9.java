import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int activities = scanner.nextInt();
            byte[] cSchedule = new byte[1441];
            byte[] jSchedule = new byte[1441];

            StringBuilder result = new StringBuilder();

            for (int activityIndex = 0; activityIndex < activities; activityIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean assignedToC = true;

                for (int time = start; time < end; time++) {
                    if (cSchedule[time] == 1) {
                        assignedToC = false;
                        break;
                    }
                }

                if (assignedToC) {
                    for (int time = start; time < end; time++) {
                        cSchedule[time] = 1;
                    }
                    result.append("C");
                } else {
                    boolean assignedToJ = true;

                    for (int time = start; time < end; time++) {
                        if (jSchedule[time] == 1) {
                            assignedToJ = false;
                            break;
                        }
                    }

                    if (assignedToJ) {
                        for (int time = start; time < end; time++) {
                            jSchedule[time] = 1;
                        }
                        result.append("J");
                    } else {
                        result.setLength(0);
                        result.append("IMPOSSIBLE");
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
    }
}