import java.util.*;
class Solution {
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] times = new int[N][2];
            for (int i = 0; i < N; i++) {
                times[i][0] = sc.nextInt();
                times[i][1] = sc.nextInt();
            }
            Arrays.sort(times, (a,b)-> (a[1]!=b[1]?a[1]-b[1]:a[0]-b[0]));
            StringBuffer sb = new StringBuffer();
            sb.append('C');
            int endC = times[0][1];
            int endJ = 0;
            for (int i = 1; i < times.length; i++) {
                if (times[i][0] >= endC) {
                    sb.append('C');
                    endC = times[i][1];
                } else {
                    if (times[i][0] >= endJ) {
                        sb.append('J');
                        endJ = times[i][1];
                    } else {
                        sb.delete(0,sb.length());
                        sb.append("IMPOSSIBLE");
                        break;
                    }
                }
            }
            System.out.println("case #" + t + ": " + sb.toString());
        }
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        s.solve();
    }

}