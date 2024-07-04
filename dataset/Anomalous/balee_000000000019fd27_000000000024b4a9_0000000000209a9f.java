import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

    private static final String OPEN_BRACKETS = "((((((((((";
    private static final String CLOSE_BRACKETS = "))))))))))";
    
    private static String process(Scanner scanner) {
        char[] inputChars = scanner.next().toCharArray();
        StringBuilder result = new StringBuilder();
        int openCount = 0;

        for (char c : inputChars) {
            int digit = c - '0';
            if (digit > openCount) {
                result.append(OPEN_BRACKETS, openCount, digit);
            } else if (digit < openCount) {
                result.append(CLOSE_BRACKETS, digit, openCount);
            }
            result.append(c);
            openCount = digit;
        }
        result.append(CLOSE_BRACKETS, 0, openCount);
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in.available() > 0 ? System.in :
            new FileInputStream(Thread.currentThread().getStackTrace()[1].getClassName() + ".practice.in"));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            System.out.printf("Case #%d: %s%n", i, process(scanner));
        }
    }
}