import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            String inputString = scanner.nextLine();
            processTestCase(testCase, inputString);
        }
    }

    private static void processTestCase(int testCaseNumber, String inputString) {
        List<Character> result = generateSequence(inputString.charAt(0), inputString.charAt(0) - '0');

        for (int i = 1; i < inputString.length(); i++) {
            int currentDigit = inputString.charAt(i) - '0';
            int lastIndex = result.size() - 1;
            int parenthesesCount = 0;

            while (lastIndex >= 0 && result.get(lastIndex) == ')' && parenthesesCount < currentDigit) {
                lastIndex--;
                parenthesesCount++;
            }

            int remainingParentheses = currentDigit - parenthesesCount;
            List<Character> newSequence = generateSequence(inputString.charAt(i), remainingParentheses);
            result.addAll(lastIndex + 1, newSequence);
        }

        String resultString = result.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println("Case #" + testCaseNumber + ": " + resultString);
    }

    private static List<Character> generateSequence(char digit, int parenthesesCount) {
        List<Character> sequence = new ArrayList<>();

        for (int i = 0; i < parenthesesCount; i++) {
            sequence.add('(');
        }

        sequence.add(digit);

        for (int i = 0; i < parenthesesCount; i++) {
            sequence.add(')');
        }

        return sequence;
    }
}