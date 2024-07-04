import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int intervalsCount = Integer.parseInt(scanner.nextLine());
            int[] startTimes = new int[intervalsCount];
            int[] endTimes = new int[intervalsCount];

            for (int i = 0; i < intervalsCount; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            scanner.nextLine(); // Consume the remaining newline

            ArrayList<String> cSchedule = new ArrayList<>();
            ArrayList<String> jSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < intervalsCount; i++) {
                boolean canUseC = true;
                boolean canUseJ = true;

                for (String time : cSchedule) {
                    int cStart = Integer.parseInt(time.split(" ")[0]);
                    int cEnd = Integer.parseInt(time.split(" ")[1]);
                    if (cStart <= startTimes[i] && cEnd > startTimes[i]) {
                        canUseC = false;
                        break;
                    }
                }

                for (String time : jSchedule) {
                    int jStart = Integer.parseInt(time.split(" ")[0]);
                    int jEnd = Integer.parseInt(time.split(" ")[1]);
                    if (jStart <= startTimes[i] && jEnd > startTimes[i]) {
                        canUseJ = false;
                        break;
                    }
                }

                String interval = startTimes[i] + " " + endTimes[i];
                if (canUseC && !result.toString().equals("IMPOSSIBLE")) {
                    cSchedule.add(interval);
                    result.append("C");
                } else if (canUseJ) {
                    jSchedule.add(interval);
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