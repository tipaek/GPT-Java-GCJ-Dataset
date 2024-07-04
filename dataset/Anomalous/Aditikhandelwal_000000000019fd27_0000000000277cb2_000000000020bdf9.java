import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int originalTestCases = testCases;

        while (testCases > 0) {
            int n = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            int[] cameron = {Integer.MAX_VALUE, Integer.MIN_VALUE};
            int[] jamie = {Integer.MAX_VALUE, Integer.MIN_VALUE};

            for (int i = 1; i <= n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (i == 1) {
                    result.append("C");
                    cameron[0] = start;
                    cameron[1] = end;
                } else if (overlaps(cameron, start, end)) {
                    if (overlaps(jamie, start, end)) {
                        System.out.println("Case #" + (originalTestCases - testCases + 1) + ": IMPOSSIBLE");
                        result = new StringBuilder("IMPOSSIBLE");
                        break;
                    } else {
                        result.append("J");
                        updateTime(jamie, start, end);
                    }
                } else {
                    result.append("C");
                    updateTime(cameron, start, end);
                }
            }

            if (!result.toString().equals("IMPOSSIBLE")) {
                if (cameron[0] <= jamie[0]) {
                    System.out.println("Case #" + (originalTestCases - testCases + 1) + ": " + result);
                } else {
                    StringBuilder swappedResult = new StringBuilder();
                    for (char ch : result.toString().toCharArray()) {
                        swappedResult.append(ch == 'C' ? 'J' : 'C');
                    }
                    System.out.println("Case #" + (originalTestCases - testCases + 1) + ": " + swappedResult);
                }
            }
            testCases--;
        }
    }

    private static boolean overlaps(int[] time, int start, int end) {
        return (time[0] < start && time[1] > start) || (time[0] < end && time[1] > end) || (start <= time[0] && end >= time[1]);
    }

    private static void updateTime(int[] time, int start, int end) {
        if (start < time[0]) {
            time[0] = start;
        }
        if (end > time[1]) {
            time[1] = end;
        }
    }
}