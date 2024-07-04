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

        int i = 1;
        if (N == 501) {
            System.out.println("1 1");
            System.out.println("2 1");
            System.out.println("3 2");
            N -= 4;
            i = 3;
        }

        while (N > 0) {
            System.out.printf("%d %d\n", i, i);
            i++;
            N--;
        }
    }
}