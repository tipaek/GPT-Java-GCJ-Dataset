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
            String[] inputLines = new String[N];
            for (int j = 0; j < N; j++) {
                inputLines[j] = scanner.nextLine();
            }
            int[] intervals = Arrays.stream(String.join(" ", inputLines).split(" "))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
            processTestCase(i, N, intervals);
        }
    }

    private static void processTestCase(int testCase, int N, int[] intervals) {
        List<Integer> cameronIntervals = new ArrayList<>();
        List<Integer> jamieIntervals = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        boolean isImpossible = false;

        cameronIntervals.add(intervals[0]);
        cameronIntervals.add(intervals[1]);
        Collections.sort(cameronIntervals);
        result.append("C");

        for (int i = 2; i < intervals.length; i += 2) {
            if (i + 1 == intervals.length) {
                break;
            }

            cameronIntervals.add(intervals[i]);
            cameronIntervals.add(intervals[i + 1]);
            Collections.sort(cameronIntervals);

            int start = intervals[i];
            int endIndex = cameronIntervals.indexOf(intervals[i + 1]);
            int prevEnd = cameronIntervals.get(endIndex - 1);

            if (prevEnd != start) {
                cameronIntervals.remove((Integer) intervals[i]);
                cameronIntervals.remove((Integer) intervals[i + 1]);

                jamieIntervals.add(intervals[i]);
                jamieIntervals.add(intervals[i + 1]);
                Collections.sort(jamieIntervals);

                start = intervals[i];
                endIndex = jamieIntervals.indexOf(intervals[i + 1]);
                prevEnd = jamieIntervals.get(endIndex - 1);

                if (prevEnd != start && endIndex % 2 == 1) {
                    jamieIntervals.remove((Integer) intervals[i]);
                    jamieIntervals.remove((Integer) intervals[i + 1]);
                    isImpossible = true;
                } else if (endIndex % 2 == 1) {
                    result.append("J");
                } else {
                    isImpossible = true;
                }
            } else if (endIndex % 2 == 1) {
                result.append("C");
            } else {
                isImpossible = true;
            }

            if (isImpossible) {
                break;
            }
        }

        if (isImpossible) {
            System.out.println("Case #" + testCase + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}