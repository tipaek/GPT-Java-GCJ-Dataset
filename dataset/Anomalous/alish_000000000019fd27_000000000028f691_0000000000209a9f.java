import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String inputString = scanner.nextLine();
            LinkedList<Character> resultList = new LinkedList<>();

            int firstDigit = Character.getNumericValue(inputString.charAt(0));
            appendCharacters(resultList, '(', firstDigit);
            resultList.add(inputString.charAt(0));

            for (int i = 0; i < inputString.length() - 1; i++) {
                int currentDigit = Character.getNumericValue(inputString.charAt(i));
                int nextDigit = Character.getNumericValue(inputString.charAt(i + 1));

                if (currentDigit > nextDigit) {
                    appendCharacters(resultList, ')', currentDigit - nextDigit);
                } else if (currentDigit < nextDigit) {
                    appendCharacters(resultList, '(', nextDigit - currentDigit);
                }
                resultList.add(inputString.charAt(i + 1));
            }

            int lastDigit = Character.getNumericValue(inputString.charAt(inputString.length() - 1));
            appendCharacters(resultList, ')', lastDigit);

            System.out.print("Case #" + caseNumber + ": ");
            for (char character : resultList) {
                System.out.print(character);
            }
            System.out.println();
        }
    }

    private static void appendCharacters(LinkedList<Character> list, char character, int count) {
        for (int i = 0; i < count; i++) {
            list.add(character);
        }
    }
}