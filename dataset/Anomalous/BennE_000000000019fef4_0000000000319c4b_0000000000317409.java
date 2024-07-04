import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Scanner;

public class Solution {
    private static final String RESULT_PATTERN = "Case #{0}: {1}";

    private static String getSolution(Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String sequence = scanner.next();

        int currentY = y;

        for (int i = 0; i <= sequence.length(); i++) {
            if (currentY == 0 && i >= x) {
                return String.valueOf(i);
            }

            if (i == sequence.length()) {
                break;
            }

            char direction = sequence.charAt(i);
            switch (direction) {
                case 'N':
                    currentY++;
                    break;
                case 'S':
                    currentY--;
                    break;
                default:
                    throw new RuntimeException();
            }

            if (i < x) {
                continue;
            }

            if (currentY > 0) {
                currentY--;
            } else if (currentY < 0) {
                currentY++;
            }
        }

        return "IMPOSSIBLE";
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        // Scanner scanner = new Scanner(new FileInputStream("A.in"));

        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String solution = getSolution(scanner);
            System.out.println(MessageFormat.format(RESULT_PATTERN, i, solution));
        }
    }

    private static String ask(String question, Scanner scanner) {
        System.out.println(question);
        return scanner.next();
    }
}