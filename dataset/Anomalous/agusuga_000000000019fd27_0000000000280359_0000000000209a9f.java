import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            String inputString = scanner.nextLine();
            int currentLevel = 0;

            System.out.print("Case #" + (caseIndex + 1) + ": ");

            for (int i = 0; i < inputString.length(); i++) {
                int digit = Character.getNumericValue(inputString.charAt(i));

                if (digit > currentLevel) {
                    for (int j = 0; j < digit - currentLevel; j++) {
                        System.out.print("(");
                    }
                } else if (digit < currentLevel) {
                    for (int j = 0; j < currentLevel - digit; j++) {
                        System.out.print(")");
                    }
                }

                System.out.print(digit);
                currentLevel = digit;
            }

            for (int j = 0; j < currentLevel; j++) {
                System.out.print(")");
            }

            System.out.println();
        }

        scanner.close();
    }
}