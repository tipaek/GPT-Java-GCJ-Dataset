import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int previousDigit = Character.getNumericValue(input.charAt(0));

            appendCharacters(result, '(', previousDigit);
            result.append(previousDigit);

            int currentDepth = previousDigit;

            for (int i = 1; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                if (currentDigit > previousDigit) {
                    appendCharacters(result, '(', currentDigit - currentDepth);
                    currentDepth = currentDigit;
                } else if (currentDigit < previousDigit) {
                    appendCharacters(result, ')', currentDepth - currentDigit);
                    currentDepth = currentDigit;
                }
                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            appendCharacters(result, ')', currentDepth);
            System.out.println(result);
        }
    }

    private void appendCharacters(StringBuilder sb, char character, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }
    }
}