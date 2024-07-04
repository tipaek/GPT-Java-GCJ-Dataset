import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int numCases = stdin.nextInt();

        for (int caseNumber = 1; caseNumber <= numCases; caseNumber++) {
            char[] inputLine = stdin.next().toCharArray();
            int length = inputLine.length;
            int[] digits = new int[length];

            for (int i = 0; i < length; i++) {
                digits[i] = inputLine[i] - '0';
            }

            System.out.print("Case #" + caseNumber + ": ");
            int currentLevel = 0;

            for (int i = 0; i < length; i++) {
                if (digits[i] > currentLevel) {
                    for (int j = currentLevel; j < digits[i]; j++) {
                        System.out.print("(");
                    }
                } else if (digits[i] < currentLevel) {
                    for (int j = digits[i]; j < currentLevel; j++) {
                        System.out.print(")");
                    }
                }

                System.out.print(digits[i]);
                currentLevel = digits[i];
            }

            for (int i = 0; i < currentLevel; i++) {
                System.out.print(")");
            }
            System.out.println();
        }
    }
}