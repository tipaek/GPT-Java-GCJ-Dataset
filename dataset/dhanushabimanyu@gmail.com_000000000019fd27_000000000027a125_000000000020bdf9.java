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
            Arrays.fill(startC1, -1);
            Arrays.fill(startJ1, -1);
            Arrays.fill(endC1, -1);
            Arrays.fill(endJ1, -1);
            String result = "";
            for (int j = 0; j < n; j++) {
                int start = s.nextInt();
                int end = s.nextInt();
                if (isOverlap(start, end, startC1, endC1)) {
                    result = result + "C";
                    startC1[j] = start;
                    endC1[j] = end;
                } else if (isOverlap(start, end, startJ1, endJ1)) {
                    result = result + "J";
                    startJ1[j] = start;
                    endJ1[j] = end;
                } else {
                    result = "IMPOSSIBLE";
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + result);

        }
    }
}
