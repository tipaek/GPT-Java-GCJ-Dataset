import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = input.nextInt();

        for (int a = 0; a < tests; a++) {
            StringBuilder result = new StringBuilder();
            int N = input.nextInt();
            List<int[]> intervals = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int start = input.nextInt();
                int finish = input.nextInt();
                intervals.add(new int[]{start, finish});
            }

            intervals.sort(Comparator.comparingInt(interval -> interval[0]));

            int cEnd = 0, jEnd = 0;
            boolean possible = true;

            for (int[] interval : intervals) {
                int start = interval[0];
                int finish = interval[1];

                if (start >= cEnd) {
                    result.append('C');
                    cEnd = finish;
                } else if (start >= jEnd) {
                    result.append('J');
                    jEnd = finish;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + (a + 1) + ": " + result);
        }
    }
}