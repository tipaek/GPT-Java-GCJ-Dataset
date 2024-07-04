import java.util.*;

public class Solution {
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            Pair[] activities = new Pair[n];

            for (int i = 0; i < n; i++) {
                activities[i] = new Pair(sc.nextInt(), sc.nextInt());
            }

            Arrays.sort(activities, Comparator.comparingInt(p -> p.x));

            StringBuilder schedule = new StringBuilder();
            Pair cameron = new Pair(0, 0);
            Pair jamie = new Pair(0, 0);
            boolean possible = true;

            for (Pair activity : activities) {
                if (activity.x >= cameron.y) {
                    cameron = activity;
                    schedule.append("C");
                } else if (activity.x >= jamie.y) {
                    jamie = activity;
                    schedule.append("J");
                } else {
                    possible = false;
                    break;
                }
            }

            String result = possible ? schedule.toString() : "IMPOSSIBLE";
            System.out.println("Case #" + t + ": " + result);
        }
    }
}