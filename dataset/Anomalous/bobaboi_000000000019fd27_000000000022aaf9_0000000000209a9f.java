import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static int caseNumber = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            processCase(scanner);
        }
    }

    private static void processCase(Scanner scanner) {
        String input = scanner.nextLine();
        List<Character> result = new ArrayList<>();
        char[] characters = input.toCharArray();

        char previousChar = '0';
        for (int i = 0; i < characters.length; i++) {
            char currentChar = characters[i];

            if (currentChar > previousChar) {
                appendCharacters(result, '(', currentChar - previousChar);
            } else if (currentChar < previousChar) {
                appendCharacters(result, ')', previousChar - currentChar);
            }

            result.add(currentChar);
            previousChar = currentChar;

            // Skip subsequent occurrences of the same character
            while (i + 1 < characters.length && characters[i + 1] == currentChar) {
                result.add(currentChar);
                i++;
            }
        }

        int closingBrackets = previousChar - '0';
        appendCharacters(result, ')', closingBrackets);

        System.out.println("Case #" + caseNumber + ": " + listToString(result));
        caseNumber++;
    }

    private static void appendCharacters(List<Character> list, char character, int count) {
        for (int i = 0; i < count; i++) {
            list.add(character);
        }
    }

    private static String listToString(List<Character> list) {
        StringBuilder sb = new StringBuilder(list.size());
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}