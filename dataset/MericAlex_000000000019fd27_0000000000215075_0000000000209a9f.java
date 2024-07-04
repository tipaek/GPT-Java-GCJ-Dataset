import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer maxCases = Integer.valueOf(scanner.nextLine());
        int currentCase = 0;
        while (maxCases != currentCase) {
            String resultString = "";
            String input = scanner.nextLine();
            int parenthesesNumber = 0;
            for (int charPos = 0; charPos < input.length(); charPos++) {
                int value = Integer.parseInt(String.valueOf(input.charAt(charPos)));
                boolean valueMatch = false;
                while (!valueMatch) {
                    if (value > parenthesesNumber) {
                        resultString = resultString + "(";
                        parenthesesNumber++;
                    } else if (value < parenthesesNumber) {
                        resultString = resultString + ")";
                        parenthesesNumber--;
                    } else {
                        resultString = resultString + value;
                        valueMatch = true;
                    }
                }
            }
            boolean parenthesesClosed = false;
            while (!parenthesesClosed) {
                if(parenthesesNumber != 0) {
                    resultString = resultString + ")";
                    parenthesesNumber--;
                } else {
                    parenthesesClosed = true;
                }
            }
            System.out.println("Case #" + (currentCase + 1) + " " + resultString);
            currentCase++;
        }
    }
}