import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static boolean isOverlap(int start, int end, int[] s, int[] e) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] != -1 && (start < e[i] && end > s[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] startC = new int[n];
            int[] startJ = new int[n];
            int[] endC = new int[n];
            int[] endJ = new int[n];
            Arrays.fill(startC, -1);
            Arrays.fill(startJ, -1);
            Arrays.fill(endC, -1);
            Arrays.fill(endJ, -1);

            StringBuilder result = new StringBuilder();
            boolean isPossible = true;

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isOverlap(start, end, startC, endC)) {
                    result.append("C");
                    startC[j] = start;
                    endC[j] = end;
                } else if (isOverlap(start, end, startJ, endJ)) {
                    result.append("J");
                    startJ[j] = start;
                    endJ[j] = end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + (i + 1) + ": " + result.toString());
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }
}