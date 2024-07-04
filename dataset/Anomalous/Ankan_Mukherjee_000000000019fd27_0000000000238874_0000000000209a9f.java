import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            int currentLevel = 0;

            System.out.print("Case #" + caseNumber + ": ");

            for (char digitChar : input.toCharArray()) {
                int digit = Character.getNumericValue(digitChar);

                if (currentLevel < digit) {
                    printBrackets('(', digit - currentLevel);
                } else if (currentLevel > digit) {
                    printBrackets(')', currentLevel - digit);
                }

                currentLevel = digit;
                System.out.print(digit);
            }

            printBrackets(')', currentLevel);
            System.out.println();
        }
    }

    private static void printBrackets(char bracket, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(bracket);
        }
    }
}