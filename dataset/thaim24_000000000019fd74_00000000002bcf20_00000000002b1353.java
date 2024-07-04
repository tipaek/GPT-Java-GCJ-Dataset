import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=0; t<T; t++) {
            int N = sc.nextInt();
            List<int[]> ans = solve2(N);

            System.out.println("Case #" + (t+1) + ":");
            for (int i=0; i<ans.size(); i++) {
                System.out.println(ans.get(i)[0] + " " + ans.get(i)[1]);
            }
        }
    }

    private static List<int[]> solve2(int N) {
        List<int[]> ans = new ArrayList();
        int r = 1, k = 1;

        ans.add(new int[]{r, k});
        N -= 1;

        while (N>0) {
            // System.err.println("size=" + ans.size() + " left=" + N);
            if (N >= Math.pow(2, (r+1)-1)) {
                N -= Math.pow(2, r);

                int s = r % 2 == 0 ? r + 1 : 1;
                int d = r % 2 == 0 ? -1 : 1;
                for (int p = 0; p < r + 1; p++) {
                    ans.add(new int[]{r + 1, s + d * p});
                }
                r++;
                k = k == 1 ? r : 1;
            } else if (N > (1 + r) + (1 + r+1)) {
                N -= 2*r + 3;
                
                if (k == 1) {
                    ans.add(new int[]{r+1, 1});
                    ans.add(new int[]{r+1, 2});
                    ans.add(new int[]{r+2, 2});
                    ans.add(new int[]{r+2, 1});

                    r += 2;
                } else {
                    ans.add(new int[]{r+1, r+1});
                    ans.add(new int[]{r+1, r});
                    ans.add(new int[]{r+2, r+1});
                    ans.add(new int[]{r+2, r+2});

                    r += 2;
                    k += 2;
                }
            } else {
                for (int i=0; i<N; i++) {
                    ans.add(new int[]{r+1, k == 1 ? 1 : r+1});
                    r++;
                }
                N = 0;
            }
        }

        return ans;
    }
}
