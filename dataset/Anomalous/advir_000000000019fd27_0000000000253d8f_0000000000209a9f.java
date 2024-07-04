import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        for (int i = 0; i < t; i++) {
            String qItems = scanner.nextLine();
            System.out.print("Case #" + (i + 1) + ": ");
            int[] q = qItems.chars().map(Character::getNumericValue).toArray();
            int previous = 0;

            for (int j = 0; j < q.length; j++) {
                int current = q[j];
                if (current > previous) {
                    for (int k = 0; k < current - previous; k++) {
                        System.out.print("(");
                    }
                } else if (current < previous) {
                    for (int k = 0; k < previous - current; k++) {
                        System.out.print(")");
                    }
                }
                System.out.print(current);
                previous = current;
            }

            for (int k = 0; k < previous; k++) {
                System.out.print(")");
            }

            System.out.println();
        }

        scanner.close();
    }
}