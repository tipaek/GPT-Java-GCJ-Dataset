import java.util.*;
class Solution {
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] times = new int[N][3];
            for (int i = 0; i < N; i++) {
                times[i][0] = sc.nextInt();
                times[i][1] = sc.nextInt();
                times[i][2] = i;
            }
            Arrays.sort(times, (a,b)-> (a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]));
            char[] result = new char[N];
            String r = "";
            int endC = times[0][1];
            int endJ = 0;
            result[times[0][2]] = 'C';
            for (int i = 1; i < times.length; i++) {
                int index = times[i][2];
                if (times[i][0] >= endC) {
                    result[index] = 'C';
                    endC = times[i][1];
                } else if (times[i][0] >= endJ) {
                    result[index] = 'J';
                    endJ = times[i][1];
                } else {
                    r = "IMPOSSIBLE";
                    break;
                }
            }
            if (r.length() != 0) {
                System.out.println("case #" + t + ": " + r);
            } else {
                System.out.println("case #" + t + ": " + String.valueOf(result));
            }
        }
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        s.solve();
    }

}