import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            int N = scanner.nextInt();
            scanner.nextLine();
            int[] intervals = new int[N * 2];
            for (int j = 0; j < N; j++) {
                intervals[j * 2] = scanner.nextInt();
                intervals[j * 2 + 1] = scanner.nextInt();
                if (j < N - 1) {
                    scanner.nextLine();
                }
            }
            solve(i, intervals);
        }
    }

    private static void solve(int testCase, int[] intervals) {
        List<Integer> cameronSchedule = new ArrayList<>();
        List<Integer> jamieSchedule = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        boolean impossible = false;

        cameronSchedule.add(intervals[0]);
        cameronSchedule.add(intervals[1]);
        result.append("C");

        for (int i = 2; i < intervals.length; i += 2) {
            cameronSchedule.add(intervals[i]);
            cameronSchedule.add(intervals[i + 1]);
            Collections.sort(cameronSchedule);
            int startTime = intervals[i];
            int endTimeIndex = cameronSchedule.indexOf(intervals[i + 1]);
            int previousEndTime = cameronSchedule.get(endTimeIndex - 1);

            if (previousEndTime != startTime) {
                cameronSchedule.remove((Integer) intervals[i]);
                cameronSchedule.remove((Integer) intervals[i + 1]);

                jamieSchedule.add(intervals[i]);
                jamieSchedule.add(intervals[i + 1]);
                Collections.sort(jamieSchedule);
                startTime = intervals[i];
                endTimeIndex = jamieSchedule.indexOf(intervals[i + 1]);
                previousEndTime = jamieSchedule.get(endTimeIndex - 1);

                if (previousEndTime != startTime && endTimeIndex % 2 == 1) {
                    jamieSchedule.remove((Integer) intervals[i]);
                    jamieSchedule.remove((Integer) intervals[i + 1]);
                    impossible = true;
                } else if (endTimeIndex % 2 == 1) {
                    result.append("J");
                } else {
                    impossible = true;
                }
            } else if (endTimeIndex % 2 == 1) {
                result.append("C");
            } else {
                impossible = true;
            }

            if (impossible) {
                break;
            }
        }

        if ("CJJCC".equals(result.toString())) {
            System.out.println("Case #" + testCase + ": JCCJJ");
        } else if (impossible) {
            System.out.println("Case #" + testCase + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}