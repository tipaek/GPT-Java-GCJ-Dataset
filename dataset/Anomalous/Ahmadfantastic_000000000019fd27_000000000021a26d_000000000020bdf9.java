import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            scanner.nextLine();
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int S = scanner.nextInt();
                int E = scanner.nextInt();
                activities.add(new Activity(i, S, E));
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
            activities.sort((a1, a2) -> Integer.compare(a1.start, a2.start));

            char[] schedule = new char[N];
            boolean isImpossible = false;
            Activity lastC = null;
            Activity lastJ = null;

            for (Activity activity : activities) {
                if (lastC == null || lastC.end <= activity.start) {
                    schedule[activity.id] = 'C';
                    lastC = activity;
                } else if (lastJ == null || lastJ.end <= activity.start) {
                    schedule[activity.id] = 'J';
                    lastJ = activity;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + new String(schedule));
            }
        }
    }

    private static class Activity {
        int id;
        int start;
        int end;

        public Activity(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }
}