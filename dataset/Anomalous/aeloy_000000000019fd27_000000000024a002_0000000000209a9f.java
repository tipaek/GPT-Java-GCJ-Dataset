import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            List<Integer> digits = input.chars()
                                        .mapToObj(c -> c - '0')
                                        .collect(Collectors.toList());

            System.out.print("Case #" + (i + 1) + ": ");
            printNestingDepth(digits);
            System.out.println();
        }
    }

    private static void printNestingDepth(List<Integer> digits) {
        int currentDepth = 0;

        for (int digit : digits) {
            while (currentDepth < digit) {
                System.out.print("(");
                currentDepth++;
            }
            while (currentDepth > digit) {
                System.out.print(")");
                currentDepth--;
            }
            System.out.print(digit);
        }

        while (currentDepth > 0) {
            System.out.print(")");
            currentDepth--;
        }
    }
}