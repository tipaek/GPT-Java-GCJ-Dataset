import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static int caseCount = 1;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfCases = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            for (int i = 0; i < numberOfCases; i++) {
                processCase(scanner);
            }
        }
    }

    private static void processCase(Scanner scanner) {
        String input = scanner.nextLine();
        List<Character> resultList = new LinkedList<>();
        char[] inputCharacters = input.toCharArray();

        for (int i = 0; i < inputCharacters.length; i++) {
            if (inputCharacters[i] == '1') {
                resultList.add('(');
                resultList.add('1');
                i++;
                while (i < inputCharacters.length && inputCharacters[i] == '1') {
                    resultList.add('1');
                    i++;
                }
                i--;
                resultList.add(')');
            } else {
                resultList.add('0');
            }
        }

        StringBuilder resultString = new StringBuilder();
        for (char character : resultList) {
            resultString.append(character);
        }

        System.out.println("Case #" + caseCount + ": " + resultString);
        caseCount++;
    }
}