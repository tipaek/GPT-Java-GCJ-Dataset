import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfTests = input.nextInt();
        String openBrackets = "(((((((((";
        String closeBrackets = ")))))))))";

        for (int currentTest = 1; currentTest <= numOfTests; currentTest++) {
            String raw = input.next();
            StringBuilder processed = new StringBuilder();

            for (int i = 0; i < raw.length(); i++) {
                int num = Character.getNumericValue(raw.charAt(i));
                processed.append(openBrackets, 0, num)
                         .append(raw.charAt(i))
                         .append(closeBrackets, 0, num);
            }

            for (int i = 1; i < processed.length(); i++) {
                if (processed.charAt(i) == '(' && processed.charAt(i - 1) == ')') {
                    processed.delete(i - 1, i + 1);
                    i--;
                }
            }

            System.out.println("Case #" + currentTest + ": " + processed);
        }
    }
}