import java.util.Scanner;

public class Solution {

    private static final String OPEN_PARENTHESIS = "(";
    private static final String CLOSE_PARENTHESIS = ")";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Integer cases = in.nextInt();

        for (int i = 1; i <= cases; i ++) {

            String result = formatParenthesis(in.next());
            System.out.format("Case #%d: %s\n", i, result);
        }
    }

    private static String formatParenthesis(String number) {

        StringBuffer result = new StringBuffer("");

        Integer lastNumber = -1;

        Integer parenthesisToFinish = 0;

        for (Character c : number.toCharArray()) {

            Integer currentNumber = Integer.valueOf(c.toString());

            if (lastNumber == -1) {
                parenthesisToFinish += currentNumber;
                result.append(createParenthesis(currentNumber, OPEN_PARENTHESIS));
                result.append(currentNumber);

            } else if (lastNumber == currentNumber) {
                result.append(currentNumber);

            } else if (lastNumber > currentNumber) {
                result.append(createParenthesis(lastNumber - currentNumber, CLOSE_PARENTHESIS));
                parenthesisToFinish -= lastNumber - currentNumber;
                result.append(currentNumber);

            } else if (lastNumber < currentNumber) {
                parenthesisToFinish += currentNumber - lastNumber;
                result.append(createParenthesis(currentNumber - lastNumber, OPEN_PARENTHESIS));
                result.append(currentNumber);
            }

            lastNumber = currentNumber;
        }

        result.append(createParenthesis(parenthesisToFinish, CLOSE_PARENTHESIS));

        return result.toString();
    }

    private static String createParenthesis(Integer number, String parenthesis) {

        String result = "";

        for (int i = 0; i < number; i++)
            result += parenthesis;

        return result;
    }

}
