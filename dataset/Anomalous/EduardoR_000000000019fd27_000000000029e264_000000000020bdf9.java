import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = input.nextInt();

        for (int t = 0; t < tests; t++) {
            String result = "";
            int N = input.nextInt();
            List<int[]> intervals = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int start = input.nextInt();
                int finish = input.nextInt();
                intervals.add(new int[]{start, finish, i});
            }

            intervals.sort(Comparator.comparingInt(a -> a[0]));

            int[] endC = {0};
            int[] endJ = {0};
            char[] schedule = new char[N];

            boolean possible = true;

            for (int[] interval : intervals) {
                if (interval[0] >= endC[0]) {
                    endC[0] = interval[1];
                    schedule[interval[2]] = 'C';
                } else if (interval[0] >= endJ[0]) {
                    endJ[0] = interval[1];
                    schedule[interval[2]] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            result = possible ? new String(schedule) : "IMPOSSIBLE";
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
}