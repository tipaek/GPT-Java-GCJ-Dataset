import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numStrings = scanner.nextInt();
            String[] patterns = new String[numStrings];
            for (int i = 0; i < numStrings; i++) {
                patterns[i] = scanner.next();
            }
            processTestCase(testCase, patterns);
        }
    }

    public static void processTestCase(int testCaseNumber, String[] patterns) {
        String result = "*";
        String currentPattern = patterns[0].replace("*", "");

        for (int i = 1; i < patterns.length; i++) {
            String nextPattern = patterns[i].replace("*", "");

            if (nextPattern.contains(currentPattern)) {
                currentPattern = nextPattern;
            } else if (!currentPattern.contains(nextPattern)) {
                result = "*";
                break;
            }
            result = currentPattern;
        }

        System.out.println("Case #" + testCaseNumber + ": " + result);
    }
}