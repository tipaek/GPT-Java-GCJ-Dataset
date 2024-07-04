import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int length = input.length();
            int firstOneIndex = -1, lastZeroIndex = -1;

            for (int i = 0; i < length; i++) {
                char currentChar = input.charAt(i);

                if (currentChar == '0') {
                    if (firstOneIndex != -1) {
                        result.append("(").append(input, firstOneIndex, i).append(")");
                        firstOneIndex = -1;
                    }
                    result.append(currentChar);
                    lastZeroIndex = i;
                } else {
                    if (firstOneIndex == -1) {
                        firstOneIndex = i;
                    }
                }
            }

            if (firstOneIndex != -1) {
                result.append("(").append(input.substring(lastZeroIndex + 1)).append(")");
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }
}