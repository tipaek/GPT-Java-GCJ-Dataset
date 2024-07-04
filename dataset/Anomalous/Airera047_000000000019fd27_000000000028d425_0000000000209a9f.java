import java.util.Scanner;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();

        for (int i = 0; i < testCases; i++) {
            String inputStr = input.next();
            int depth = 0;
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < inputStr.length(); j++) {
                char currentChar = inputStr.charAt(j);
                int targetDepth = Character.getNumericValue(currentChar);

                while (depth < targetDepth) {
                    result.append("(");
                    depth++;
                }
                while (depth > targetDepth) {
                    result.append(")");
                    depth--;
                }

                result.append(currentChar);
            }

            while (depth > 0) {
                result.append(")");
                depth--;
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
    }
}