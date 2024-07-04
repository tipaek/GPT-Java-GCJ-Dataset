import java.io.*;
import java.util.*;

/**
 * Solution
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        try {
            solve(sc);
        } finally {
            sc.close();
        }
    }

    private static void solve(Scanner sc) {
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            walk(i, N);
        }
    }

    private static void walk(int T, int N) {
        System.out.format("Case #%d:\n", T);

        System.out.println("1 1");
        N--;

        int i = 2, j = 1, v = 1;
        while (N >= v) {
            N -= v;
            System.out.printf("%d %d\n", i, j);
            v++;
            if (N >= v) {
                i++;
                j++;
            }
        }
        if (N > 0) {
            j++;
            N--;
            System.out.printf("%d %d\n", i++, j++);
        }
        while (N > 0) {
            N--;
            System.out.printf("%d %d\n", i++, j++);
        }
    }
}