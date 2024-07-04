import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static boolean isOverlap(int start, int end, int[] s, int[] e) {
        boolean result = true;
        for (int i = 0; i < s.length; i++) {
            if (s[i] != -1 && (start >= e[i] || end <= s[i])) {
                result = true;
            } else if (s[i] != -1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        boolean flag = true;
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int[] startC = new int[n];
            int[] startJ = new int[n];
            int[] endC = new int[n];
            int[] endJ = new int[n];
            Arrays.fill(startC, -1);
            Arrays.fill(startJ, -1);
            Arrays.fill(endC, -1);
            Arrays.fill(endJ, -1);
            String result = "";
            for (int j = 0; j < n; j++) {
                int start = s.nextInt();
                int end = s.nextInt();
                if (isOverlap(start, end, startJ, endJ)) {
                    result = result + "J";
                    startJ[j] = start;
                    endJ[j] = end;
                }
                 else if (isOverlap(start, end, startC, endC)) {
                    result = result + "C";
                    startC[j] = start;
                    endC[j] = end;
                }  else {
                    result = "IMPOSSIBLE";
                }
            }
            if (result.contains("IMPOSSIBLE")) {
                System.out.println("Case #" + (i + 1) + ": " + "IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }
}
