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
            int[] startC1 = new int[n];
            int[] startJ1 = new int[n];
            int[] endC1 = new int[n];
            int[] endJ1 = new int[n];
            int[] startC2 = new int[n];
            int[] startJ2 = new int[n];
            int[] endC2 = new int[n];
            int[] endJ2 = new int[n];
            Arrays.fill(startC1, -1);
            Arrays.fill(startJ1, -1);
            Arrays.fill(startC2, -1);
            Arrays.fill(startJ2, -1);
            Arrays.fill(endC1, -1);
            Arrays.fill(endJ1, -1);
            Arrays.fill(endJ2, -1);
            String result = "";
            String result2 = "";
            String result1 = "";
            for (int j = 0; j < n; j++) {
                int start = s.nextInt();
                int end = s.nextInt();
                if (isOverlap(start, end, startC1, endC1)) {
                    result1 = result1 + "C";
                    startC1[j] = start;
                    endC1[j] = end;
                } else if (isOverlap(start, end, startJ1, endJ1)) {
                    result1 = result1 + "J";
                    startJ1[j] = start;
                    endJ1[j] = end;
                } else {
                    result1 = "IMPOSSIBLE";
                }

                if (isOverlap(start, end, startJ2, endJ2)) {
                    result2 = result2 + "J";
                    startJ2[j] = start;
                    endJ2[j] = end;
                } else if (isOverlap(start, end, startC2, endC2)) {
                    result2 = result2 + "C";
                    startC2[j] = start;
                    endC2[j] = end;
                } else {
                    result2 = "IMPOSSIBLE";
                }

                if (!result1.contains("IMPOSSIBLE")) {
                    result = result1;
                } else if (!result2.contains("IMPOSSIBLE")) {
                    result = result2;
                } else {
                    result = "IMPOSSIBLE";
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + result);

        }
    }
}
