import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        scanner.close();

        LinkedList<Character> resultList = new LinkedList<>();

        int firstDigit = Character.getNumericValue(inputString.charAt(0));
        for (int i = 0; i < firstDigit; i++) {
            resultList.add('(');
        }
        resultList.add(inputString.charAt(0));

        for (int i = 0; i < inputString.length() - 1; i++) {
            int currentDigit = Character.getNumericValue(inputString.charAt(i));
            int nextDigit = Character.getNumericValue(inputString.charAt(i + 1));

            if (currentDigit > nextDigit) {
                for (int j = 0; j < currentDigit - nextDigit; j++) {
                    resultList.add(')');
                }
            } else if (currentDigit < nextDigit) {
                for (int j = 0; j < nextDigit - currentDigit; j++) {
                    resultList.add('(');
                }
            }
            resultList.add(inputString.charAt(i + 1));
        }

        int lastDigit = Character.getNumericValue(inputString.charAt(inputString.length() - 1));
        for (int i = 0; i < lastDigit; i++) {
            resultList.add(')');
        }

        for (char c : resultList) {
            System.out.print(c);
        }
    }
}