import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(sc.nextLine());
        String[] outputs = new String[testCaseCount];

        for (int i = 0; i < testCaseCount; i++) {
            String input = sc.nextLine();
            StringBuilder result = new StringBuilder();
            int[] digits = input.chars().map(Character::getNumericValue).toArray();

            int currentDepth = 0;
            for (int digit : digits) {
                while (currentDepth < digit) {
                    result.append("(");
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(")");
                    currentDepth--;
                }
                result.append(digit);
            }
            while (currentDepth > 0) {
                result.append(")");
                currentDepth--;
            }

            outputs[i] = result.toString();
        }

        for (int i = 0; i < testCaseCount; i++) {
            System.out.println("Case #" + (i + 1) + ": " + outputs[i]);
        }
    }
}