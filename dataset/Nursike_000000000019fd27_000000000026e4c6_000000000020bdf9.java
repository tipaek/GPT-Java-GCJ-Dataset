import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tn = in.nextInt();
        for (int t = 0; t < tn; t++) {
            solve(in, t + 1);
        }
    }

    private static void solve(Scanner in, int t) {
        int n = in.nextInt();

        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
            a[i][2] = i;
        }

        Arrays.sort(a, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        char[] res = new char[n];
        int lastC = 0;
        int lastJ = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (a[i][0] >= lastC) {
                lastC = a[i][1];
                res[a[i][2]] = 'C';
            } else if (a[i][0] >= lastJ) {
                lastJ = a[i][1];
                res[a[i][2]] = 'J';
            } else break;
            k++;
        }
        if (k != n) {
            System.out.println("Case #" + t + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + t + ": " + new String(res));
        }
    }
}