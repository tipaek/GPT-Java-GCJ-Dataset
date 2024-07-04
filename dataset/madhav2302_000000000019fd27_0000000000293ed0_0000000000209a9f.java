import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int testNumber = 1; testNumber <= T; testNumber++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int numberOfOpenParentheses = 0;
            for (char c : input.toCharArray()) {
                int depth = Integer.parseInt(c + "");

                if (depth > numberOfOpenParentheses) {
                    while (numberOfOpenParentheses < depth) {
                        result.append("(");
                        numberOfOpenParentheses++;
                    }
                } else if (depth < numberOfOpenParentheses) {
                    while (numberOfOpenParentheses > depth) {
                        result.append(")");
                        numberOfOpenParentheses--;
                    }
                }

                result.append(c);
            }

            while (numberOfOpenParentheses > 0) {
                result.append(")");
                numberOfOpenParentheses--;
            }

            System.out.println("Case #" + testNumber + ": " + result);
        }


    }
}
