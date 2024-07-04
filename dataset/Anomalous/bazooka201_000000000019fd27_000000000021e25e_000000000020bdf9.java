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
            scanner.nextLine(); // Consume the remaining newline

            ArrayList<String> cSchedule = new ArrayList<>();
            ArrayList<String> jSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                boolean canAssignC = true;
                boolean canAssignJ = true;

                for (String timeSlot : cSchedule) {
                    int cStart = Integer.parseInt(timeSlot.split(" ")[0]);
                    int cEnd = Integer.parseInt(timeSlot.split(" ")[1]);
                    if ((cStart <= startTimes[i] && cEnd > startTimes[i]) || 
                        (cStart < endTimes[i] && cEnd >= endTimes[i]) || 
                        (cStart < startTimes[i] && cEnd > endTimes[i])) {
                        canAssignC = false;
                        break;
                    }
                }

                for (String timeSlot : jSchedule) {
                    int jStart = Integer.parseInt(timeSlot.split(" ")[0]);
                    int jEnd = Integer.parseInt(timeSlot.split(" ")[1]);
                    if ((jStart <= startTimes[i] && jEnd > startTimes[i]) || 
                        (jStart < endTimes[i] && jEnd >= endTimes[i]) || 
                        (jStart < startTimes[i] && jEnd > endTimes[i])) {
                        canAssignJ = false;
                        break;
                    }
                }

                String timeSlot = startTimes[i] + " " + endTimes[i];
                if (canAssignC && !result.toString().equals("IMPOSSIBLE")) {
                    cSchedule.add(timeSlot);
                    result.append("C");
                } else if (canAssignJ && !result.toString().equals("IMPOSSIBLE")) {
                    jSchedule.add(timeSlot);
                    result.append("J");
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}