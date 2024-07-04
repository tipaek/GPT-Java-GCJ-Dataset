import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            scanner.nextLine();
            int n = scanner.nextInt();
            List<int[]> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                scanner.nextLine();
                intervals.add(new int[]{scanner.nextInt(), scanner.nextInt()});
            }

            solveScheduling(testCase, intervals);
        }

        scanner.close();
    }

    private static void solveScheduling(int testCase, List<int[]> intervals) {
        StringBuilder result = new StringBuilder();
        intervals.sort(Comparator.comparingInt(interval -> interval[0]));

        int cEnd = 0, jEnd = 0;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (cEnd <= start) {
                result.append('C');
                cEnd = end;
            } else if (jEnd <= start) {
                result.append('J');
                jEnd = end;
            } else {
                result.setLength(0);
                result.append("IMPOSSIBLE");
                break;
            }
        }

        System.out.println("Case #" + testCase + ": " + result);
    }

    public static void solveBrackets(int testCase, String str) {
        StringBuilder result = new StringBuilder();
        int openBrackets = 0;

        for (char c : str.toCharArray()) {
            int requiredBrackets = c - '0';

            while (openBrackets < requiredBrackets) {
                result.append('(');
                openBrackets++;
            }

            while (openBrackets > requiredBrackets) {
                result.append(')');
                openBrackets--;
            }

            result.append(c);
        }

        while (openBrackets > 0) {
            result.append(')');
            openBrackets--;
        }

        System.out.println("Case #" + testCase + ": " + result);
    }
}