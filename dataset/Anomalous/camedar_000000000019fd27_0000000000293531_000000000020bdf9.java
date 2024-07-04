import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after the integer input
            int[] cameron = new int[2];
            int[] jaime = new int[2];
            StringBuilder result = new StringBuilder();

            boolean impossible = false;
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character after the integer input

                if (isAvailable(cameron, start, end)) {
                    cameron[0] = start;
                    cameron[1] = end;
                    result.append("C");
                } else if (isAvailable(jaime, start, end)) {
                    jaime[0] = start;
                    jaime[1] = end;
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            // Output response for each test case
            System.out.println("Case #" + i + ": " + result.toString());

            if (!impossible) {
                scanner.nextLine(); // Consume the remaining input for the current test case if not impossible
            }
        }
    }

    private static boolean isAvailable(int[] person, int start, int end) {
        return (person[0] == 0 && person[1] == 0) || person[1] <= start || person[0] >= end;
    }
}