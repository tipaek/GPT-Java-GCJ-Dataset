import java.util.Scanner;

public class Solution {
     public static String generateParentheses(int N, boolean type) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (type) {
                result.append("(");
            } else {
                result.append(")");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        String[] result = new String[T];

        input.nextLine();

        for (int i = 0; i < T; i++) {
            String inputString = input.nextLine();
            int count = 0;
            StringBuilder testResult = new StringBuilder();

            for (int j = 0; j < inputString.length(); j++) {
                int number = Integer.parseInt(String.valueOf(inputString.charAt(j)));
                if (count < number) {
                    testResult.append(generateParentheses(number - count, true));
                    testResult.append(number);
                    count = number;
                } else if (count > number) {
                    testResult.append(generateParentheses(count - number, false));
                    testResult.append(number);
                    count = number;
                } else {
                    testResult.append(number);
                }
            }
            testResult.append(generateParentheses(count, false));
            result[i] = testResult.toString();

        }

        for (int i = 0; i < T; i++) {
            System.out.println(String.format("Case #%d: %s", i + 1, result[i]));
        }
    }
}
