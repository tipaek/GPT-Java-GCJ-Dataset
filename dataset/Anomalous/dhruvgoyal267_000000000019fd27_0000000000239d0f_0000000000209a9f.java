import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        int originalTestCases = testCases;

        while (testCases-- > 0) {
            String input = scanner.nextLine();
            ArrayList<Character> resultArray = new ArrayList<>();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (currentDepth < digit) {
                    resultArray.add('(');
                    currentDepth++;
                }

                while (currentDepth > digit) {
                    resultArray.add(')');
                    currentDepth--;
                }

                resultArray.add(ch);
            }

            while (currentDepth > 0) {
                resultArray.add(')');
                currentDepth--;
            }

            StringBuilder result = new StringBuilder();
            for (char c : resultArray) {
                result.append(c);
            }

            System.out.println("Case #" + (originalTestCases - testCases) + ": " + result);
        }

        scanner.close();
    }
}