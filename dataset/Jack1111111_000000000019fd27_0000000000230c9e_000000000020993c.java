import java.util.*;
class Solution {
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] nums = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    nums[i][j] = sc.nextInt();
                }
            }
            int trace = 0;
            for (int i = 0; i < N; i++) {
                trace += nums[i][i];
            }
            int rows = 0;
            int cols = 0;

            for (int i = 0; i < N; i++) {
                Set<Integer> sr = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (sr.contains(nums[i][j])) {
                        rows++;
                        break;
                    } else {
                        sr.add(nums[i][j]);
                    }

                }
            }

            for (int i = 0; i < N; i++) {
                Set<Integer> sr = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (sr.contains(nums[j][i])) {
                        cols++;
                        break;
                    } else {
                        sr.add(nums[j][i]);
                    }

                }
            }
            System.out.println("Case #" + t + ": " + trace + " " + rows + " " + cols);
        }
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        s.solve();
    }

}