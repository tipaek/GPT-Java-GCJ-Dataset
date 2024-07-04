import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            solve(scanner);
            System.out.println();
        }
        scanner.close();
    }

    static void solve(Scanner scanner) {
        String input = scanner.next();
        int[] digits = input.chars().map(c -> c - '0').toArray();
        StringBuilder result = new StringBuilder();

        int currentDepth = 0;

        for (int digit : digits) {
            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }
            result.append(digit);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        System.out.print(result.toString());
    }
}