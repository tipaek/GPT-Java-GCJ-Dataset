import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());

        main: for (int test = 1; test <= testCases; test++) {
            int numberOfActivities = Integer.parseInt(scanner.nextLine());
            Interval[] activities = new Interval[numberOfActivities];

            for (int a = 0; a < numberOfActivities; a++) {
                String[] parts = scanner.nextLine().split(" ");
                activities[a] = new Interval(a, Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            }

            Arrays.sort(activities, Comparator.comparingInt(f -> f.start));

            int jamieFreeAt = 0;
            int cameronFreeAt = 0;

            for (Interval next : activities) {
                if (jamieFreeAt <= next.start) {
                    next.owner = "J";
                    jamieFreeAt = next.end;
                } else if (cameronFreeAt <= next.start) {
                    next.owner = "C";
                    cameronFreeAt = next.end;
                } else {
                    System.out.println("Case #" + test + ": IMPOSSIBLE");
                    continue main;
                }
            }

            Arrays.sort(activities, Comparator.comparingInt(f -> f.id));

            StringBuilder sb = new StringBuilder();
            for (Interval a : activities) {
                sb.append(a.owner);
            }

            System.out.println("Case #" + test + ": " + sb.toString());
        }
    }

    static class Interval {
        int id;
        int start;
        int end;
        String owner;

        public Interval(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }
}
