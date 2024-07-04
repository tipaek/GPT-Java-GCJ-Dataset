import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activities = Integer.parseInt(scanner.nextLine());
            int[] startTimes = new int[activities];
            int[] endTimes = new int[activities];

            for (int i = 0; i < activities; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            scanner.nextLine(); // Consume the remaining newline character

            ArrayList<String> cSchedule = new ArrayList<>();
            ArrayList<String> jSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < activities; i++) {
                boolean canAssignToC = true;
                boolean canAssignToJ = true;

                for (String timeSlot : cSchedule) {
                    int cStart = Integer.parseInt(timeSlot.split(" ")[0]);
                    int cEnd = Integer.parseInt(timeSlot.split(" ")[1]);

                    if ((cStart <= startTimes[i] && cEnd > startTimes[i]) || 
                        (cStart < endTimes[i] && cEnd >= endTimes[i]) || 
                        (cStart >= startTimes[i] && cEnd <= endTimes[i])) {
                        canAssignToC = false;
                        break;
                    }
                }

                for (String timeSlot : jSchedule) {
                    int jStart = Integer.parseInt(timeSlot.split(" ")[0]);
                    int jEnd = Integer.parseInt(timeSlot.split(" ")[1]);

                    if ((jStart <= startTimes[i] && jEnd > startTimes[i]) || 
                        (jStart < endTimes[i] && jEnd >= endTimes[i]) || 
                        (jStart >= startTimes[i] && jEnd <= endTimes[i])) {
                        canAssignToJ = false;
                        break;
                    }
                }

                String timeSlot = startTimes[i] + " " + endTimes[i];
                if (canAssignToC && !result.toString().equals("IMPOSSIBLE")) {
                    cSchedule.add(timeSlot);
                    result.append("C");
                } else if (canAssignToJ && !result.toString().equals("IMPOSSIBLE")) {
                    jSchedule.add(timeSlot);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                }
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
        scanner.close();
    }
}