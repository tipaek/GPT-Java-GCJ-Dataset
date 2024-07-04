
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    Scanner in = new Scanner(System.in);

    void solve501(int t, int n) {
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

    void solve1000(int t, int n) {
        List<int[]> pos = new ArrayList<>();
        pos.add(new int[]{1, 1});
        n--;
        int i = 1;
        while (i*(i+1)/2 <= n) {
            i++;
        }
        i--;
        int k;
        for (k=1;k<=i;k++) {
            pos.add(new int[]{k+1, 2});
            n -= k;
        }
        while (n > 0) {
            pos.add(new int[]{k+1, 1});
            k++;
            n--;
        }

        System.out.println(String.format("Case #%d:", t));
        for (int[] p : pos) {
            System.out.println(p[0] + " " + p[1]);
        }
    }

    void solve(int t, int n) {
        if (n <= 501) solve501(t, n);
        else {
            solve1000(t, n);
        }
    }

    void run() {
        int T = in.nextInt();
        for (int t=1;t<=T;t++) {
            int n = in.nextInt();
            solve(t, n);
        }

    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
