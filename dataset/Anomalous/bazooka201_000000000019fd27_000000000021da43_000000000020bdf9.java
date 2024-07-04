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

                for (String time : cSchedule) {
                    int cStart = Integer.parseInt(time.split(" ")[0]);
                    int cEnd = Integer.parseInt(time.split(" ")[1]);
                    if ((startTimes[i] < cEnd && endTimes[i] > cStart)) {
                        canAssignC = false;
                        break;
                    }
                }

                for (String time : jSchedule) {
                    int jStart = Integer.parseInt(time.split(" ")[0]);
                    int jEnd = Integer.parseInt(time.split(" ")[1]);
                    if ((startTimes[i] < jEnd && endTimes[i] > jStart)) {
                        canAssignJ = false;
                        break;
                    }
                }

                String timeSlot = startTimes[i] + " " + endTimes[i];

                if (canAssignC) {
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

            System.out.println("Case #" + t + ": " + result);
        }
    }
}