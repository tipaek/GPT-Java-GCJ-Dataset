import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        for (int i = 0; i < t; i++) {
            String qItems = scanner.nextLine();
            System.out.print("Case #" + (i + 1) + ": ");
            int[] q = qItems.chars().map(Character::getNumericValue).toArray();

            for (int j = 0; j < q.length; j++) {
                if (j == 0) {
                    printParentheses(q[j], 0);
                } else {
                    printParentheses(q[j], q[j - 1]);
                }
                System.out.print(q[j]);
            }
            printParentheses(0, q[q.length - 1]);
            System.out.println();
        }
        scanner.close();
    }

    private static void printParentheses(int current, int previous) {
        int diff = current - previous;
        if (diff > 0) {
            for (int k = 0; k < diff; k++) {
                System.out.print("(");
            }
        } else {
            for (int k = 0; k < -diff; k++) {
                System.out.print(")");
            }
        }
    }
}