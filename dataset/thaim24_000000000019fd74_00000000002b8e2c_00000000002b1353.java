import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=0; t<T; t++) {
            int N = sc.nextInt();
            List<int[]> ans = solve(N);

            System.out.println("Case #" + (t+1) + ":");
            for (int i=0; i<ans.size(); i++) {
                System.out.println(ans.get(i)[0] + " " + ans.get(i)[1]);
            }
        }
    }

    private static List<int[]> solve(int N) {
        List<int[]> ans = new ArrayList();
        int r = 1, k = 1;

        ans.add(new int[]{r, k});
        N -= 1;

        while (N>0) {
            // System.err.println("size=" + ans.size() + " left=" + N);
            if (N >= Math.pow(2, r)) {

                int s = r%2 == 0 ? r+1 : 1;
                int d = r%2 == 0 ? -1 : 1;
                for (int p=0; p<r+1; p++) {
                    ans.add(new int[]{r+1, s + d*p});
                }
                r++;
                k = k == 1 ? r : 1;
                N -= Math.pow(2, r-1);
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
