import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        
        for (int caseIndex = 1; caseIndex <= numCases; caseIndex++) {
            String line = input.next();
            StringBuilder result = new StringBuilder();
            int previous = 0;

            for (char currentChar : line.toCharArray()) {
                int currentVal = Character.getNumericValue(currentChar);

                if (currentVal > previous) {
                    appendCharacters(result, '(', currentVal - previous);
                } else if (currentVal < previous) {
                    appendCharacters(result, ')', previous - currentVal);
                }

                result.append(currentVal);
                previous = currentVal;
            }

            appendCharacters(result, ')', previous);

            System.out.printf("Case #%d: %s%n", caseIndex, result.toString());
        }

        input.close();
    }

    private static void appendCharacters(StringBuilder builder, char character, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(character);
        }
    }
}