import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static boolean isOverlap(int start, int end, int[] s, int[] e) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] != -1 && !(start >= e[i] || end <= s[i])) {
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

            StringBuilder result1 = new StringBuilder();
            StringBuilder result2 = new StringBuilder();
            String finalResult = "";

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isOverlap(start, end, startC1, endC1)) {
                    result1.append("C");
                    startC1[j] = start;
                    endC1[j] = end;
                } else if (isOverlap(start, end, startJ1, endJ1)) {
                    result1.append("J");
                    startJ1[j] = start;
                    endJ1[j] = end;
                } else {
                    result1 = new StringBuilder("IMPOSSIBLE");
                }

                if (isOverlap(start, end, startJ2, endJ2)) {
                    result2.append("J");
                    startJ2[j] = start;
                    endJ2[j] = end;
                } else if (isOverlap(start, end, startC2, endC2)) {
                    result2.append("C");
                    startC2[j] = start;
                    endC2[j] = end;
                } else {
                    result2 = new StringBuilder("IMPOSSIBLE");
                }

                if (!result1.toString().contains("IMPOSSIBLE")) {
                    finalResult = result1.toString();
                } else if (!result2.toString().contains("IMPOSSIBLE")) {
                    finalResult = result2.toString();
                } else {
                    finalResult = "IMPOSSIBLE";
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + finalResult);
        }
    }
}