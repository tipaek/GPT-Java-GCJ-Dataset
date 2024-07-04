import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = Integer.parseInt(sc.nextLine());
        for (int tt = 1; tt <= t; tt++) {
            int n = Integer.parseInt(sc.nextLine());
            char[] rr = new char[n];
            int[][] ac = new int[n][3];
            for (int i = 0; i < n; i++) {
                String[] ll = sc.nextLine().split(" ");
                ac[i][0] = Integer.parseInt(ll[0]);
                ac[i][1] = Integer.parseInt(ll[1]);
                ac[i][2] = i;
            }
            Arrays.sort(ac, Comparator.comparingInt(o -> o[0]));

            int cb = -1;
            int jb = -1;
            boolean correct = true;
            for (int i = 0; i < n; i++) {
                if (cb <= ac[i][0]) {
                    cb = ac[i][1];
                    rr[ac[i][2]] = 'C';
                } else if (jb <= ac[i][0]) {
                    jb = ac[i][1];
                    rr[ac[i][2]] = 'J';
                } else {
                    correct = false;
                    break;
                }
            }

            if (!correct) {
                System.out.println("Case #" + tt + ": " + "IMPOSSIBLE");
            } else {
                StringBuilder res = new StringBuilder();
                for (char ch : rr) {
                    res.append(ch);
                }
                System.out.println("Case #" + tt + ": " + res);
            }

        }
    }
}
