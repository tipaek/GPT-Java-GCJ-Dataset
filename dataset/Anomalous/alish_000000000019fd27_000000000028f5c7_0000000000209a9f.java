import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            String inputString = scanner.nextLine();
            LinkedList<Character> outputList = new LinkedList<>();

            int firstDigit = Character.getNumericValue(inputString.charAt(0));
            appendCharacters(outputList, '(', firstDigit);
            outputList.add(inputString.charAt(0));

            for (int i = 0; i < inputString.length() - 1; i++) {
                int currentDigit = Character.getNumericValue(inputString.charAt(i));
                int nextDigit = Character.getNumericValue(inputString.charAt(i + 1));

                if (currentDigit > nextDigit) {
                    appendCharacters(outputList, ')', currentDigit - nextDigit);
                } else if (currentDigit < nextDigit) {
                    appendCharacters(outputList, '(', nextDigit - currentDigit);
                }
                outputList.add(inputString.charAt(i + 1));
            }

            int lastDigit = Character.getNumericValue(inputString.charAt(inputString.length() - 1));
            appendCharacters(outputList, ')', lastDigit);

            System.out.print("Case #" + caseNum + ": ");
            for (char ch : outputList) {
                System.out.print(ch);
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