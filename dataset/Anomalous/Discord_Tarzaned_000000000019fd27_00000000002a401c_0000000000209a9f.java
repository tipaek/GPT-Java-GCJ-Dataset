import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCaseCount; caseNumber++) {
            System.out.print("Case #" + caseNumber + ": ");
            processCase(scanner);
            System.out.println();
        }
        scanner.close();
    }

    public static void processCase(Scanner scanner) {
        String input = scanner.next();
        int[] differences = new int[input.length() - 1];

        for (int i = 0; i < input.length() - 1; i++) {
            differences[i] = (input.charAt(i) - '0') - (input.charAt(i + 1) - '0');
        }

        int initialBrackets = input.charAt(0) - '0';
        for (int i = 0; i < initialBrackets; i++) {
            System.out.print("(");
        }
        System.out.print(input.charAt(0));

        for (int i = 0; i < differences.length; i++) {
            if (differences[i] > 0) {
                for (int j = 0; j < differences[i]; j++) {
                    System.out.print(")");
                }
            } else if (differences[i] < 0) {
                for (int j = 0; j < -differences[i]; j++) {
                    System.out.print("(");
                }
            }
            System.out.print(input.charAt(i + 1));
        }

        int closingBrackets = input.charAt(input.length() - 1) - '0';
        for (int i = 0; i < closingBrackets; i++) {
            System.out.print(")");
        }
    }
}