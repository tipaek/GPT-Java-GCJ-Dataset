import java.util.Scanner;

public class Scheduling {
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

            int cAvailableAt = 0, jAvailableAt = 0;
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;

            for (int minute = 0; minute <= 1440; minute++) {
                if (cAvailableAt > 0) cAvailableAt--;
                if (jAvailableAt > 0) jAvailableAt--;

                for (int k = 0; k < n; k++) {
                    if (minute == startTimes[k]) {
                        if (cAvailableAt == 0) {
                            cAvailableAt = endTimes[k] - startTimes[k];
                            schedule.append("C");
                        } else if (jAvailableAt == 0) {
                            jAvailableAt = endTimes[k] - startTimes[k];
                            schedule.append("J");
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
                System.out.println("Case #" + i + ": " + schedule.toString());
            }
        }

        scanner.close();
    }
}