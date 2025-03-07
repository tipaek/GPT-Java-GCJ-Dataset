import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activities = Integer.parseInt(scanner.nextLine());
            int[] startTimes = new int[activities];
            int[] endTimes = new int[activities];

            for (int i = 0; i < activities; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            scanner.nextLine(); // Consume the remaining newline

            ArrayList<String> cSchedule = new ArrayList<>();
            ArrayList<String> jSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < activities; i++) {
                boolean canAssignC = true;
                boolean canAssignJ = true;

                for (String time : cSchedule) {
                    int cStart = Integer.parseInt(time.split(" ")[0]);
                    int cEnd = Integer.parseInt(time.split(" ")[1]);
                    if (cStart <= startTimes[i] && cEnd > startTimes[i]) {
                        canAssignC = false;
                        break;
                    }
                }

                for (String time : jSchedule) {
                    int jStart = Integer.parseInt(time.split(" ")[0]);
                    int jEnd = Integer.parseInt(time.split(" ")[1]);
                    if (jStart <= startTimes[i] && jEnd > startTimes[i]) {
                        canAssignJ = false;
                        break;
                    }
                }

                String timeSlot = startTimes[i] + " " + endTimes[i];
                if (canAssignC && !result.toString().equals("IMPOSSIBLE")) {
                    cSchedule.add(timeSlot);
                    result.append("C");
                } else if (canAssignJ) {
                    jSchedule.add(timeSlot);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}