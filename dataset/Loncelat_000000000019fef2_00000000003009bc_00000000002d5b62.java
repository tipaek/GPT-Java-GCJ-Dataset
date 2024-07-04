import java.io.*;
import java.util.*;
class Solution {

    static int vals[];
    static int cvals[];
    static int X, Y;

    static int log;
    static int minlen = Integer.MAX_VALUE;

    static char dir[] = {'E', 'W', 'N', 'S'};

    static Scanner sc;
    static void testcase(int no) {

        X = sc.nextInt();
        Y = sc.nextInt();

        if (X == 0 && Y == 0) { System.out.format("Case #%d: %s\n", no, ""); return; }

        log = (int) (2 * (Math.log(Math.abs(X) + Math.abs(Y)) / Math.log(2) + 1e-10));

        vals = new int[4];
        cvals = new int[4];

        recurse(0);

        StringBuilder outp = new StringBuilder();

        if (cvals[0] - cvals[1] == X && cvals[2] - cvals[3] == Y) {
           // System.out.println(cvals[2] + " " + cvals[3]);
            for (int i = 0; i < minlen; i++) {
                int mask = 1 << i;
                for (int j = 0; j < 4; j++) {
                    if ((cvals[j] & mask) != 0) {
                        outp.append(dir[j]);
                        break;
                    }
                }

            }

        } else {
            outp.append("IMPOSSIBLE");
        }

        System.out.format("Case #%d: %s\n", no, outp.toString());

    }
    public static void main(String args[]) {
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            testcase(i + 1);
        }
    }

    static boolean recurse(int level) {
        if (level > log + 1) { return false; }

        int mask = 1 << level;

        if (vals[0] - vals[1] == X && vals[2] - vals[3] == Y) {
            if (level < minlen) {
                for (int j = 0; j < 4; j++) cvals[j] = vals[j];
                minlen = level;
            }
            return true;
        }

        for (int i = 0; i < 4; i++) {
            vals[i] |= mask;
            recurse(level + 1);
            vals[i] &= ~mask;
        }

        return false;

    }
}