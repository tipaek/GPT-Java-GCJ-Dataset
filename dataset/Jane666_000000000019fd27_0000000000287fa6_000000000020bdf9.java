import java.util.*;

public class Solution {
    public static void solve(Scanner input, int t) {
        // get the input
        int N = input.nextInt();
        int[][] intervals = new int[N][3];
        for (int i = 0 ; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j < 2) {
                    intervals[i][j] = input.nextInt();
                } else {
                    intervals[i][j] = i;  // old index
                }
                
            }
        }
        Map<Integer, Character> map = new HashMap<>();
        int cEnd = 0, jEnd = 0;
        // sort the intervals by starting time
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        for (int i = 0; i < N; i++) {
            if (cEnd <= intervals[i][0]) {
                cEnd = intervals[i][1];
                map.put(intervals[i][2], 'C');
            } else if (jEnd <= intervals[i][0]) {
                jEnd = intervals[i][1];
                map.put(intervals[i][2], 'J');
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                return;
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map.get(i));
        }
        System.out.println("Case #" + t + ": " + sb.toString());
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            solve(input, i);
        }
    }
}