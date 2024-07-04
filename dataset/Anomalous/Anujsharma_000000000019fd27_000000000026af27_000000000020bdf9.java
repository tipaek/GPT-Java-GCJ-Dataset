import java.util.Scanner;

public class SchedulePlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int j = 0; j < n; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }

            int cEndTime = 0, jEndTime = 0;
            char[] schedule = new char[n];
            boolean possible = true;

            for (int currentTime = 0; currentTime <= 1440; currentTime++) {
                if (cEndTime > 0) cEndTime--;
                if (jEndTime > 0) jEndTime--;

                for (int k = 0; k < n; k++) {
                    if (currentTime == startTimes[k]) {
                        if (cEndTime == 0) {
                            cEndTime = endTimes[k] - startTimes[k];
                            schedule[k] = 'C';
                        } else if (jEndTime == 0) {
                            jEndTime = endTimes[k] - startTimes[k];
                            schedule[k] = 'J';
                        } else {
                            System.out.println("Case #" + i + ": IMPOSSIBLE");
                            possible = false;
                            break;
                        }
                    }
                }

                if (!possible) break;
            }

            if (possible) {
                System.out.println("Case #" + i + ": " + new String(schedule));
            }
        }

        scanner.close();
    }
}