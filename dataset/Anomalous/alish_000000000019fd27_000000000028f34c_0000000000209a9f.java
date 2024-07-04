import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.nextLine();
            LinkedList<Character> resultList = new LinkedList<>();

            int firstDigit = Character.getNumericValue(inputString.charAt(0));
            addCharacters(resultList, '(', firstDigit);
            resultList.add(inputString.charAt(0));

            for (int i = 0; i < inputString.length() - 1; i++) {
                int currentDigit = Character.getNumericValue(inputString.charAt(i));
                int nextDigit = Character.getNumericValue(inputString.charAt(i + 1));

                if (currentDigit > nextDigit) {
                    addCharacters(resultList, ')', currentDigit - nextDigit);
                } else if (currentDigit < nextDigit) {
                    addCharacters(resultList, '(', nextDigit - currentDigit);
                }
                resultList.add(inputString.charAt(i + 1));
            }

            int lastDigit = Character.getNumericValue(inputString.charAt(inputString.length() - 1));
            addCharacters(resultList, ')', lastDigit);

            System.out.println("Case #" + caseNumber + ":");
            for (char c : resultList) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void addCharacters(LinkedList<Character> list, char character, int count) {
        for (int i = 0; i < count; i++) {
            list.add(character);
        }
    }
}