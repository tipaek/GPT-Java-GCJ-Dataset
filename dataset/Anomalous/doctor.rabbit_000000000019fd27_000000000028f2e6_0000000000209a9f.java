import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = Character.getNumericValue(scanner.nextLine().charAt(0));
        int caseNumber = 1;

        while (scanner.hasNextLine()) {
            String inputString = scanner.nextLine();
            int currentDepth = 0;
            List<Character> outputList = new ArrayList<>();

            for (char currentChar : inputString.toCharArray()) {
                int currentDigit = Character.getNumericValue(currentChar);

                while (currentDepth < currentDigit) {
                    outputList.add('(');
                    currentDepth++;
                }
                while (currentDepth > currentDigit) {
                    outputList.add(')');
                    currentDepth--;
                }

                outputList.add(currentChar);
            }

            while (currentDepth > 0) {
                outputList.add(')');
                currentDepth--;
            }

            StringBuilder outputString = new StringBuilder();
            for (char ch : outputList) {
                outputString.append(ch);
            }

            System.out.println("Case #" + caseNumber + ": " + outputString.toString());
            caseNumber++;
        }
    }
}