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
            String input = scanner.nextLine();
            int currentDepth = 0;
            List<Character> result = new ArrayList<>();

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (currentDepth < digit) {
                    result.add('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.add(')');
                    currentDepth--;
                }
                result.add(ch);
            }

            while (currentDepth > 0) {
                result.add(')');
                currentDepth--;
            }

            StringBuilder output = new StringBuilder();
            for (char ch : result) {
                output.append(ch);
            }

            System.out.println("Case #" + caseNumber + ": " + output.toString());
            caseNumber++;
        }
    }
}