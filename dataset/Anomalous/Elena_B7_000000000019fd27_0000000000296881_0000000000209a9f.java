import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        try (InputStream fromStream = System.in) {
            readInput(fromStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readInput(InputStream fromStream) {
        scanner = new Scanner(fromStream);
        int testCasesNum = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= testCasesNum; i++) {
            handleTestCase(i);
        }
        scanner.close();
    }

    private static void handleTestCase(int testId) {
        char[] digits = scanner.nextLine().toCharArray();
        StringBuilder result = new StringBuilder();

        int prevDigit = 0;

        for (char digitChar : digits) {
            int curDigit = digitChar - '0';
            int distance = prevDigit - curDigit;

            if (distance < 0) {
                result.append("(".repeat(-distance));
            } else if (distance > 0) {
                result.append(")".repeat(distance));
            }

            result.append(digitChar);
            prevDigit = curDigit;
        }

        if (prevDigit > 0) {
            result.append(")".repeat(prevDigit));
        }

        System.out.printf("Case #%d: %s%n", testId, result);
    }

    private static InputStream getFromFile() throws IOException {
        File initialFile = new File("src/input2.txt");
        return new FileInputStream(initialFile);
    }
}