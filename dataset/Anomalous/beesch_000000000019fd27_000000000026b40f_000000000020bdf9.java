import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();

            for (int i = 1; i <= t; ++i) {
                Set<Activity> cActivities = new TreeSet<>();
                Set<Activity> jActivities = new TreeSet<>();

                int n = in.nextInt();
                boolean isImpossible = false;
                StringBuilder result = new StringBuilder();

                for (int a = 1; a <= n; ++a) {
                    Activity newActivity = new Activity(in.nextInt(), in.nextInt());

                    if (isImpossible) {
                        continue;
                    }

                    if (cActivities.add(newActivity)) {
                        result.append('C');
                    } else if (jActivities.add(newActivity)) {
                        result.append('J');
                    } else {
                        isImpossible = true;
                    }
                }

                if (isImpossible) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + i + ": " + result.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Activity implements Comparable<Activity> {
        private final int start;
        private final int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(Activity other) {
            if ((start >= other.getStart() && start < other.getEnd()) ||
                (end > other.getStart() && end <= other.getEnd()) ||
                (start >= other.getStart() && end <= other.getEnd()) ||
                (start <= other.getStart() && end >= other.getEnd())) {
                return 0;
            }
            return Integer.compare(start, other.start);
        }
    }
}