import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = sc.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }

                result.append(ch);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + caseNum + ": " + result.toString());
        }

        sc.close();
    }
}