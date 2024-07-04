import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            List<Character> ch = new ArrayList<>(Arrays.asList('C', 'J'));

            for (int i = 0; i < n; i++) {
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
            }

            int startC = start[0], endC = end[0], gapSC = 0, gapEC = 0;
            int startJ = start[1], endJ = end[1], gapSJ = 0, gapEJ = 0;
            boolean isImpossible = false;

            for (int k = 2; k < n; k++) {
                if ((start[k] >= endJ && end[k] >= endJ) || (start[k] >= gapSJ && end[k] <= gapEJ)) {
                    ch.add('J');
                    gapSJ = endJ;
                    gapEJ = start[k];
                    startJ = Math.min(startJ, start[k]);
                    endJ = Math.max(endJ, end[k]);
                } else if ((start[k] <= startJ && end[k] <= startJ) || (start[k] >= gapSJ && end[k] <= gapEJ)) {
                    ch.add('J');
                    gapSJ = end[k];
                    gapEJ = startJ;
                    startJ = Math.min(startJ, start[k]);
                    endJ = Math.max(endJ, end[k]);
                } else if ((start[k] >= endC && end[k] >= endC) || (start[k] >= gapSC && end[k] <= gapEC)) {
                    ch.add('C');
                    gapSC = endC;
                    gapEC = start[k];
                    startC = Math.min(startC, start[k]);
                    endC = Math.max(endC, end[k]);
                } else if ((start[k] <= startC && end[k] <= startC) || (start[k] >= gapSC && end[k] <= gapEC)) {
                    ch.add('C');
                    gapSC = end[k];
                    gapEC = startC;
                    startC = Math.min(startC, start[k]);
                    endC = Math.max(endC, end[k]);
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + t + ": ");
                for (char c : ch) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
        sc.close();
    }
}