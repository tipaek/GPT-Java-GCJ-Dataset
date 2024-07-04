
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    Scanner in = new Scanner(System.in);

    void solve(int t) {
        int n = in.nextInt();
        List<int[]> pos = new ArrayList<>();
        if (n <= 500) {
            for (int i=0;i<n;i++) pos.add(new int[]{i+1, i+1});
        } else {
            pos.add(new int[]{1, 1});
            pos.add(new int[]{2, 2});
            pos.add(new int[]{3, 2});
            n -= 4;
            int i = 3;
            while (n > 0) {
                pos.add(new int[]{i, i});
                i++;
                n--;
            }
        }
        System.out.println(String.format("Case #%d:", t));
        for (int[] p : pos) {
            System.out.println(p[0] + " " + p[1]);
        }
    }

    void run() {
        int T = in.nextInt();
        for (int t=1;t<=T;t++) solve(t);

    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
