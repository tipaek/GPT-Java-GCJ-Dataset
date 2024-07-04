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
            int[][] ivs = new int[N][3];
            for (int j = 0; j < N; j++) {
                ivs[j][0] = sc.nextInt();
                ivs[j][1] = sc.nextInt();
                ivs[j][2] = j;
            }
            solve(ivs, i);
        }
    }

    private static void solve(int[][] ivs, int T) {
        System.out.printf("Case #%d: ", T);
        int N = ivs.length;

        Arrays.sort(ivs, (iv1, iv2) -> iv1[0] - iv2[0]);

        char[] assignee = new char[N];
        int jend = 0, cend = 0;
        for (int i = 0; i < N; i++) {
            int[] iv = ivs[i];
            if (iv[0] >= cend) {
                assignee[iv[2]] = 'C';
                cend = iv[1];
            } else if (iv[0] >= jend) {
                assignee[iv[2]] = 'J';
                jend = iv[1];
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        System.out.println(new String(assignee));
    }
}