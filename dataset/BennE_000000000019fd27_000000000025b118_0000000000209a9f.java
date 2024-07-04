import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Scanner;

public class Solution {
    private static final String RESULT_PATTERN = "Case #{0}: {1}";

    private static String getSolution(final Scanner scanner) {
        final String input = scanner.next();
        StringBuilder output = new StringBuilder();
        int currentLevel = 0;
        for (final char c : input.toCharArray()) {
            final int value = Character.getNumericValue(c);

            while(value > currentLevel) {
                output.append('(');
                currentLevel++;
            }

            while(value < currentLevel) {
                output.append(')');
                currentLevel--;
            }

            output.append(c);
        }
        for (int i = 0; i < currentLevel; i++) {
            output.append(')');
        }

        return output.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(System.in);
//        final Scanner scanner = new Scanner(new FileInputStream("A.in"));

        final int testCases = scanner.nextInt();
        for(int i = 1; i<= testCases; i++) {
            final String solution = getSolution(scanner);
            System.out.println(MessageFormat.format(RESULT_PATTERN, i, solution));
        }
    }
}
