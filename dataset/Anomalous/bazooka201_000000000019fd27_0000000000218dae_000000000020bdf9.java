import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            System.out.print("Case #" + t + ": ");
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
                boolean canUseC = true;
                boolean canUseJ = true;

                for (String time : cSchedule) {
                    int cStart = Integer.parseInt(time.split(" ")[0]);
                    int cEnd = Integer.parseInt(time.split(" ")[1]);
                    if (cStart < startTimes[i] && cEnd > startTimes[i]) {
                        canUseC = false;
                        break;
                    }
                }

                for (String time : jSchedule) {
                    int jStart = Integer.parseInt(time.split(" ")[0]);
                    int jEnd = Integer.parseInt(time.split(" ")[1]);
                    if (jStart < startTimes[i] && jEnd > startTimes[i]) {
                        canUseJ = false;
                        break;
                    }
                }

                String currentTask = startTimes[i] + " " + endTimes[i];
                if (canUseC && result.indexOf("IMPOSSIBLE") == -1) {
                    cSchedule.add(0, currentTask);
                    result.append("C");
                } else if (canUseJ) {
                    jSchedule.add(0, currentTask);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println(result.toString());
        }
        scanner.close();
    }
}