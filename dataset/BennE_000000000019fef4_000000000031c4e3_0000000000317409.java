import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Scanner;

public class Solution {
    private static final String RESULT_PATTERN = "Case #{0}: {1}";

    private static String getSolution(final Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        final String sequence = scanner.next();

        for(int i = 0; i <= sequence.length(); i++) {
            if(Math.abs(x) + Math.abs(y) <= i) {
                return String.valueOf(i);
            }

            if(i == sequence.length()) {
                break;
            }

            final char direction = sequence.charAt(i);
            if(direction == 'N') {
                y++;
            } else if(direction == 'S') {
                y--;
            } else if(direction == 'E') {
                x++;
            } else {
                x--;
            }
        }

        return "IMPOSSIBLE";
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

    private static String ask(final String question, final Scanner scanner) {
        System.out.println(question);
        return scanner.next();
    }
}
