import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (InputStream fromStream = System.in) {
            readInput(fromStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readInput(InputStream fromStream) {
        try (Scanner scanner = new Scanner(fromStream)) {
            int testCasesNum = Integer.parseInt(scanner.nextLine());
            for (int i = 1; i <= testCasesNum; i++) {
                handleTestCase(scanner, i);
            }
        }
    }

    private static void handleTestCase(Scanner scanner, int testId) {
        char[] digits = scanner.nextLine().toCharArray();
        int prevDigit = 0;
        int curDigit;
        int distance;

        StringBuilder result = new StringBuilder();
        for (char digit : digits) {
            curDigit = digit - '0';
            distance = prevDigit - curDigit;

            if (distance < 0) {
                result.append("(".repeat(-distance));
            } else if (distance > 0) {
                result.append(")".repeat(distance));
            }

            result.append(digit);
            prevDigit = curDigit;
        }

        if (prevDigit > 0) {
            result.append(")".repeat(prevDigit));
        }

        System.out.println(result);
    }

    private static InputStream getFromFile() throws IOException {
        File initialFile = new File("src/input2.txt");
        return new FileInputStream(initialFile);
    }
}