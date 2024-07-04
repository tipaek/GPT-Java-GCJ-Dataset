import java.util.*;

public class Solution {

    static class Pair {
        int start;
        int end;
        int index;

        public Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<Pair> activities = new ArrayList<>();
            char[] schedule = new char[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Pair(start, end, i));
            }

            activities.sort(Comparator.comparingInt((Pair p) -> p.start).thenComparingInt(p -> p.end));

            int endC = 0, endJ = 0;
            boolean possible = true;

            for (Pair activity : activities) {
                if (activity.start >= endC) {
                    schedule[activity.index] = 'C';
                    endC = activity.end;
                } else if (activity.start >= endJ) {
                    schedule[activity.index] = 'J';
                    endJ = activity.end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + t + ": " + new String(schedule));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}