import java.util.*;

public class Solution {

    static int getNumberAt(String number, int index) {
        return number.charAt(index) - '0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer t = sc.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int depthLevel = 0;
            String numbers = sc.next();
            String result = "";

            for (int i = 0; i < numbers.length(); i++) {
                int currentNumber = getNumberAt(numbers, i);

                // Not deep enough
                while (currentNumber > depthLevel) {
                    result += '(';
                    depthLevel++;
                }

                // Too deep
                while (currentNumber < depthLevel) {
                    result += ')';
                    depthLevel--;
                }

                // Add number
                result += currentNumber;
            }

            // Return to depth 0
            while (depthLevel > 0) {
                result += ')';
                depthLevel--;
            }

            System.out.println("Case #" + caseNum + ": " + result);

        }

    }

}
