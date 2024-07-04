import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            List<int[]> intervals = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                intervals.add(new int[]{sc.nextInt(), sc.nextInt(), i});
            }

            intervals.sort(Comparator.comparingInt(a -> a[0]));

            int[] assignments = new int[N];
            int lastC = 0, lastJ = 0;
            boolean possible = true;

            for (int[] interval : intervals) {
                if (interval[0] >= lastC) {
                    assignments[interval[2]] = 'C';
                    lastC = interval[1];
                } else if (interval[0] >= lastJ) {
                    assignments[interval[2]] = 'J';
                    lastJ = interval[1];
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                StringBuilder result = new StringBuilder();
                for (int assignment : assignments) {
                    result.append((char) assignment);
                }
                System.out.println(result.toString());
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}