import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Scanner;

public class Solution {
    private static final String RESULT_PATTERN = "Case #{0}: {1}";

    private static String findMinimumTime(final Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        final String directions = scanner.next();

        for (int i = 0; i <= directions.length(); i++) {
            if (Math.abs(x) + Math.abs(y) <= i) {
                return String.valueOf(i);
            }

            if (i == directions.length()) {
                break;
            }

            final char move = directions.charAt(i);
            switch (move) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }
        }

        return "IMPOSSIBLE";
    }

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(System.in);
//        final Scanner scanner = new Scanner(new FileInputStream("A.in"));

        final int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            final String result = findMinimumTime(scanner);
            System.out.println(MessageFormat.format(RESULT_PATTERN, i, result));
        }
    }

    private static String promptUser(final String question, final Scanner scanner) {
        System.out.println(question);
        return scanner.next();
    }
}