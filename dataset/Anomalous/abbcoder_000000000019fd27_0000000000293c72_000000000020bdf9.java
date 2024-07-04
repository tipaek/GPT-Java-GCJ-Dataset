import java.util.*;

public class Solution {

    public static void main(String[] args) {
        List<int[][]> cases = readCases();

        for (int c = 1; c <= cases.size(); c++) {
            int[][] intervals = cases.get(c - 1);
            int N = intervals[0][0];

            List<int[]> times = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                int[] se = intervals[i + 1];
                times.add(new int[]{se[0], se[1], i});
            }
            times.sort(Comparator.comparingInt(a -> a[0]));

            int cameronEnd = 0;
            int jamieEnd = 0;
            boolean isPossible = true;
            char[] schedule = new char[N];

            for (int[] interval : times) {
                int start = interval[0];
                int end = interval[1];
                int index = interval[2];

                if (cameronEnd <= start) {
                    cameronEnd = end;
                    schedule[index] = 'C';
                } else if (jamieEnd <= start) {
                    jamieEnd = end;
                    schedule[index] = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }
            String result = isPossible ? new String(schedule) : "IMPOSSIBLE";
            printResult(String.format("Case #%d: %s", c, result));
        }
    }

    private static List<int[][]> readCases() {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        List<int[][]> cases = new ArrayList<>(T);

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[N + 1][];
            intervals[0] = new int[]{N};
            for (int j = 0; j < N; j++) {
                intervals[j + 1] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            cases.add(intervals);
        }
        scanner.close();
        return cases;
    }

    private static void printResult(String result) {
        System.out.println(result);
    }
}