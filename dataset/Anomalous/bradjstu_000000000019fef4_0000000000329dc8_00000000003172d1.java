import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= testCases; i++) {
            processTestCase(i, scanner);
        }
    }

    private static void processTestCase(int testCaseNumber, Scanner scanner) {
        String[] firstLine = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(firstLine[0]);
        int d = Integer.parseInt(firstLine[1]);

        String[] numberStrings = scanner.nextLine().split("\\s+");
        List<Long> numbers = new ArrayList<>();

        for (String numberString : numberStrings) {
            if (!numberString.isEmpty()) {
                numbers.add(Long.parseLong(numberString));
            }
        }

        boolean hasDuplicate = false;
        boolean hasTriplicate = false;

        Set<Long> uniqueNumbers = new HashSet<>();
        Set<Long> duplicateNumbers = new HashSet<>();

        for (Long number : numbers) {
            if (!uniqueNumbers.add(number)) {
                hasDuplicate = true;
                if (!duplicateNumbers.add(number)) {
                    hasTriplicate = true;
                }
            }
        }

        int result;
        if (hasTriplicate) {
            result = 0;
        } else if (hasDuplicate && d > 2) {
            result = 1;
        } else if (d > 2) {
            result = 2;
        } else if (hasDuplicate) {
            result = 0;
        } else {
            result = 1;
        }

        printTestCaseOutput(testCaseNumber, result);
    }

    private static void printTestCaseOutput(int testCaseNumber, int result) {
        System.out.println("Case #" + testCaseNumber + ": " + result);
    }
}