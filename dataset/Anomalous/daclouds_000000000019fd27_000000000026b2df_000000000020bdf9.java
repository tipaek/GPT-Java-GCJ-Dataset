import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    
    static boolean isOverlap(int end, int start) {
        return end > start;
    }

    static boolean isImpossible(int n, int[][] intervals, int index) {
        for (int i = index; i < n; i++) {
            if (!isOverlap(intervals[i - 1][1], intervals[i][0])) {
                return false;
            }
        }
        return true;
    }
    
    static char toggleChar(char current) {
        return current == 'C' ? 'J' : 'C';
    }

    static String solve(int n, int[][] intervals) {
        StringBuilder result = new StringBuilder();
        result.append("C");
        for (int i = 1; i < n; i++) {
            if (isImpossible(n, intervals, i)) {
                return "IMPOSSIBLE";
            }
            if (isOverlap(intervals[i - 1][1], intervals[i][0])) {
                result.append(toggleChar(result.charAt(result.length() - 1)));
            } else {
                result.append(result.charAt(result.length() - 1));
            }
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().split(" ");
                intervals[i][0] = Integer.parseInt(input[0]);
                intervals[i][1] = Integer.parseInt(input[1]);
            }
            System.out.println("Case #" + (t + 1) + ": " + solve(n, intervals));
        }

        scanner.close();
    }
}