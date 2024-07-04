import java.util.Scanner;

public class abc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int j = 0; j < n; j++) {
                startTimes[j] = scanner.nextInt();
            }
            for (int j = 0; j < n; j++) {
                endTimes[j] = scanner.nextInt();
            }

            int cFreeTime = 0, jFreeTime = 0;
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;

            for (int currentTime = 0; currentTime <= 1440; currentTime++) {
                if (cFreeTime > 0) {
                    cFreeTime--;
                }
                if (jFreeTime > 0) {
                    jFreeTime--;
                }

                for (int k = 0; k < n; k++) {
                    if (currentTime == startTimes[k]) {
                        if (cFreeTime == 0) {
                            cFreeTime = endTimes[k] - startTimes[k];
                            schedule.append("C");
                        } else if (jFreeTime == 0) {
                            jFreeTime = endTimes[k] - startTimes[k];
                            schedule.append("J");
                        } else {
                            System.out.println("IMPOSSIBLE");
                            possible = false;
                            break;
                        }
                    }
                }
                if (!possible) {
                    break;
                }
            }

            if (possible) {
                System.out.println(schedule.toString());
            }
        }
    }
}