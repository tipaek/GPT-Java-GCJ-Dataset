import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int previous = 0;

            for (char ch : input.toCharArray()) {
                int current = ch - '0';

                if (current > previous) {
                    result.append("(".repeat(current - previous));
                } else if (current < previous) {
                    result.append(")".repeat(previous - current));
                }
                
                result.append(ch);
                previous = current;
            }

            result.append(")".repeat(previous));

            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }
}