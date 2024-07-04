import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int totalCases = testCases;

        while (testCases > 0) {
            int n = scanner.nextInt();
            int cameronMin = 0, cameronMax = 0;
            int jamieMin = Integer.MAX_VALUE, jamieMax = Integer.MIN_VALUE;
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int i = 1; i <= n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (i == 1) {
                    result.append("C");
                    cameronMin = start;
                    cameronMax = end;
                } else if (isOverlapping(cameronMin, cameronMax, start, end)) {
                    if (isOverlapping(jamieMin, jamieMax, start, end) || 
                        (jamieMin != Integer.MAX_VALUE && jamieMax != Integer.MIN_VALUE && start <= jamieMin && end >= jamieMax)) {
                        System.out.println("Case #" + (totalCases - testCases + 1) + ": IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    } else {
                        result.append("J");
                        jamieMin = Math.min(jamieMin, start);
                        jamieMax = Math.max(jamieMax, end);
                    }
                } else {
                    result.append("C");
                    cameronMin = Math.min(cameronMin, start);
                    cameronMax = Math.max(cameronMax, end);
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + (totalCases - testCases + 1) + ": " + result.toString());
            }

            testCases--;
        }
    }

    private static boolean isOverlapping(int min, int max, int start, int end) {
        return (min < start && max > start) || (min < end && max > end) || (start <= min && end >= max);
    }
}