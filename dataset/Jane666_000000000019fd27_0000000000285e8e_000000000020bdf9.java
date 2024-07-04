import java.util.*;

class Solution {
    public static void solve(Scanner input, int t) {
        // get the input
        int N = input.nextInt();
        int[][] intervals = new int[N][2];
        for (int i = 0 ; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                intervals[i][j] = input.nextInt();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int cEnd = 0, jEnd = 0;
        // sort the intervals by starting time
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        for (int i = 0; i < N; i++) {
            if (cEnd <= jEnd) {
                if (intervals[i][0] < cEnd) {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                    break;
                } else {
                    cEnd = intervals[i][1];
                    sb.append("C");
                }
            } else {
                if (intervals[i][0] < jEnd) {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                    break;
                } else {
                    jEnd = intervals[i][1];
                    sb.append("J");
                }
            }
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