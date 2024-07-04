import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private void solve() {
        StringBuilder result = new StringBuilder();
        String input = scanner.next();
        char[] chars = input.toCharArray();
        int previous = 0;

        for (char c : chars) {
            int current = Character.getNumericValue(c);
            int difference = current - previous;

            if (difference > 0) {
                result.append("(".repeat(difference));
            } else {
                result.append(")".repeat(-difference));
            }

            result.append(current);
            previous = current;
        }

        result.append(")".repeat(previous));
        System.out.print(result.toString());
    }

    private void run() {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.print("Case #" + i + ": ");
            solve();
            System.out.println();
        }
        scanner.close();
    }

    public static void main(String[] args) {
        try {
            new Solution().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}