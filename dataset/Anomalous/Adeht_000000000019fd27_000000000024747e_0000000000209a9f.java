import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        for (int i = 0; i < testCaseCount; i++) {
            String input = sc.nextLine();
            StringBuilder output = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                while (currentDepth < digit) {
                    output.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    output.append(')');
                    currentDepth--;
                }
                output.append(ch);
            }

            while (currentDepth > 0) {
                output.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + (i + 1) + ": " + output.toString());
        }
        sc.close();
    }
}