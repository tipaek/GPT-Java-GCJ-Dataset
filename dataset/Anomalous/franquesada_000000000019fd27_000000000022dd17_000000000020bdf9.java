import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int tasks = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();
            Person C = new Person("C");
            Person J = new Person("J");
            C.addActivity(new Interval(scanner.nextInt(), scanner.nextInt()));
            J.addActivity(new Interval(scanner.nextInt(), scanner.nextInt()));
            StringBuilder result = new StringBuilder("CJ");

            for (int i = 2; i < tasks; i++) {
                intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
            }

            boolean impossible = false;
            for (Interval interval : intervals) {
                boolean canAssignToC = C.canAddActivity(interval);
                boolean canAssignToJ = J.canAddActivity(interval);

                if (canAssignToC) {
                    C.addActivity(interval);
                    result.append("C");
                } else if (canAssignToJ) {
                    J.addActivity(interval);
                    result.append("J");
                } else {
                    System.out.printf("Case #%d: IMPOSSIBLE\n", caseNum);
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                System.out.printf("Case #%d: %s\n", caseNum, result.toString());
            }
        }
    }

    private static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlaps(Interval other) {
            return (this.start < other.end && this.end > other.start);
        }
    }

    private static class Person {
        List<Interval> activities;
        String name;

        public Person(String name) {
            this.name = name;
            this.activities = new ArrayList<>();
        }

        public void addActivity(Interval interval) {
            this.activities.add(interval);
        }

        public boolean canAddActivity(Interval interval) {
            for (Interval activity : activities) {
                if (activity.overlaps(interval)) {
                    return false;
                }
            }
            return true;
        }
    }
}