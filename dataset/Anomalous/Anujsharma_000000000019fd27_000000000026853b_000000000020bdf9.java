import java.util.Scanner;

public class Scheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(); // Number of activities
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int j = 0; j < n; j++) {
                startTimes[j] = sc.nextInt();
                endTimes[j] = sc.nextInt();
            }

            StringBuilder schedule = new StringBuilder();
            int cEndTime = 0, jEndTime = 0;
            boolean isPossible = true;

            for (int currentTime = 0; currentTime <= 1440; currentTime++) {
                if (cEndTime > 0) cEndTime--;
                if (jEndTime > 0) jEndTime--;

                for (int k = 0; k < n; k++) {
                    if (currentTime == startTimes[k]) {
                        if (cEndTime == 0) {
                            cEndTime = endTimes[k] - startTimes[k];
                            schedule.append("C");
                        } else if (jEndTime == 0) {
                            jEndTime = endTimes[k] - startTimes[k];
                            schedule.append("J");
                        } else {
                            System.out.println("IMPOSSIBLE");
                            isPossible = false;
                            break;
                        }
                    }
                }

                if (!isPossible) break;
            }

            if (isPossible) {
                System.out.println(schedule.toString());
            }
        }

        sc.close();
    }
}