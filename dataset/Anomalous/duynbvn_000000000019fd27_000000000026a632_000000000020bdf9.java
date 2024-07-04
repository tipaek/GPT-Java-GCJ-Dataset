import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activitiesCount = scanner.nextInt();
            List<TimeInterval> cSchedule = new ArrayList<>(activitiesCount);
            List<TimeInterval> jSchedule = new ArrayList<>(activitiesCount);
            StringBuilder assignment = new StringBuilder();
            boolean isImpossible = false;

            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int finish = scanner.nextInt();

                if (canAssign(start, finish, cSchedule)) {
                    cSchedule.add(new TimeInterval(start, finish));
                    assignment.append("C");
                } else if (canAssign(start, finish, jSchedule)) {
                    jSchedule.add(new TimeInterval(start, finish));
                    assignment.append("J");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + assignment.toString());
            }
        }
    }

    private static boolean canAssign(int start, int finish, List<TimeInterval> schedule) {
        for (TimeInterval interval : schedule) {
            if (interval.overlaps(start, finish)) {
                return false;
            }
        }
        return true;
    }

    private static class TimeInterval {
        int start;
        int finish;

        TimeInterval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        boolean overlaps(int start, int finish) {
            return (start < this.finish && finish > this.start);
        }
    }
}