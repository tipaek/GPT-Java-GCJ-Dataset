import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            for (int i = 0; i < n; i++) {
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
            }

            if (n == 1) {
                System.out.println("Case #" + t + ": C");
                continue;
            }

            char[] result = new char[n];
            result[0] = 'C';
            result[1] = 'J';
            int startC = start[0], endC = end[0];
            int startJ = start[1], endJ = end[1];

            boolean possible = true;
            for (int k = 2; k < n; k++) {
                if ((start[k] >= endJ) || (end[k] <= startJ)) {
                    result[k] = 'J';
                    startJ = Math.min(startJ, start[k]);
                    endJ = Math.max(endJ, end[k]);
                } else if ((start[k] >= endC) || (end[k] <= startC)) {
                    result[k] = 'C';
                    startC = Math.min(startC, start[k]);
                    endC = Math.max(endC, end[k]);
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.print("Case #" + t + ": ");
                for (char c : result) {
                    System.out.print(c);
                }
                System.out.println();
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }

        sc.close();
    }
}